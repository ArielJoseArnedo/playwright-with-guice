package org.ajac.pages;

import com.google.inject.Inject;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.cdimascio.dotenv.Dotenv;


public class ProgramsPage {
    private final CurrentPage currentPage;
    private final Dotenv dotenv;

    @Inject
    public ProgramsPage(CurrentPage currentPage, Dotenv dotenv) {
        this.currentPage = currentPage;
        this.dotenv = dotenv;
    }

    public void selectProgram() {
        currentPage.getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(dotenv.get("textProgram"))).first().click();
    }
}
