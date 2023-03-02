package org.ajac.tasks;

import com.google.inject.Inject;
import org.ajac.pages.ProgramsPage;

public class ProgramFlow {

    private final ProgramsPage programsPage;

    @Inject
    public ProgramFlow(ProgramsPage programsPage) {
        this.programsPage = programsPage;
    }

    public void selectProgram() {
        programsPage.selectProgram();
    }
}
