package org.ajac.services;

import com.google.inject.Inject;
import io.github.cdimascio.dotenv.Dotenv;
import io.vavr.control.Try;

import java.time.DayOfWeek;

public class ScheduleService {

    private final Dotenv dotenv;

    @Inject
    public ScheduleService(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public boolean isValidToBook(DayOfWeek dayOfWeek) {
        return Try.of(() -> Integer.parseInt(dotenv.get("laterDays")))
          .map(laterDays -> calculateDayOfClassWeek(dayOfWeek, laterDays))
          .map(ClassDay::get)
          .map(ClassDay::isClassDayValid)
          .getOrElseThrow(throwable -> new RuntimeException("Error converting the days after reservation", throwable));
    }

    private int calculateDayOfClassWeek(DayOfWeek dayOfWeek, int laterDays) {
        final int daysAfterOf = dayOfWeek.getValue() + laterDays;
        return daysAfterOf <= 7
          ? daysAfterOf
          : daysAfterOf - 7;
    }
}
