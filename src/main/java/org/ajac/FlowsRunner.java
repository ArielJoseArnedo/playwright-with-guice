package org.ajac;

import com.google.inject.Inject;
import org.ajac.tasks.LoginFlow;
import org.ajac.tasks.ProgramFlow;
import org.ajac.tasks.ReservationFlow;

public class FlowsRunner implements Runnable {

    private final LoginFlow login;
    private final ProgramFlow programFlow;
    private final ReservationFlow reservationFlow;

    @Inject
    public FlowsRunner(LoginFlow login, ProgramFlow programFlow, ReservationFlow reservationFlow) {
        this.login = login;
        this.programFlow = programFlow;
        this.reservationFlow = reservationFlow;
    }

    @Override
    public void run() {
        login.showPageLogin();
        login.startLogin();

        programFlow.selectProgram();

        reservationFlow.reserveAnEnglishClass();
    }
}
