package org.ajac.tasks;

import com.google.inject.Inject;
import org.ajac.pages.EnglistProgramPage;

public class ReservationFlow {

    private final EnglistProgramPage englistProgramPage;

    @Inject
    public ReservationFlow(EnglistProgramPage englistProgramPage) {
        this.englistProgramPage = englistProgramPage;
    }

    public void reserveAnEnglishClass() {
        englistProgramPage.selectResertationClassMenu();
        englistProgramPage.selectSide();
        englistProgramPage.selectAfterTomorrowDay();
    }
}
