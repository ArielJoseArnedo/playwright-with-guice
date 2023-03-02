package org.ajac.cronjobs;

import akka.actor.ActorSystem;
import com.google.inject.Inject;
import io.github.cdimascio.dotenv.Dotenv;
import org.ajac.FlowsRunner;
import scala.concurrent.ExecutionContext;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutionJob {

   private static final Logger logger = LoggerFactory.getLogger(ExecutionJob.class);

    private final FlowsRunner flowsRunner;
    private final Dotenv dotenv;

    @Inject
    public ExecutionJob(FlowsRunner flowsRunner, Dotenv dotenv) {
        this.flowsRunner = flowsRunner;
        this.dotenv = dotenv;
    }

    public void initialize() {
        ActorSystem.create().scheduler().scheduleWithFixedDelay(
          Duration.ofMinutes(calculateTimeOfExecution()),
          Duration.ofDays(Integer.parseInt(dotenv.get("executionFrequencyInDays"))),
          flowsRunner,
          ExecutionContext.global()
        );
    }

    private long calculateTimeOfExecution() {
        final int hourExecution = Integer.parseInt(dotenv.get("hourExecution"));
        final int minuteExecution = Integer.parseInt(dotenv.get("minuteExecution"));

        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        final ZonedDateTime possibleExecutionTime = now.withHour(hourExecution).withMinute(minuteExecution).withSecond(0);

        final ZonedDateTime executionTime = now.isAfter(possibleExecutionTime)
          ? possibleExecutionTime.plusDays(1)
          : possibleExecutionTime;
        logger.info("The date on which the scheduled task will run will be: {}", executionTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a")));
        return ChronoUnit.MINUTES.between(now, executionTime);
    }
}
