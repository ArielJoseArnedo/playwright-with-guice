package org.ajac.pages;

import com.google.inject.Inject;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.cdimascio.dotenv.Dotenv;

public class EnglistProgramPage {

    private final CurrentPage currentPage;
    private final Dotenv dotenv;

    @Inject
    public EnglistProgramPage(CurrentPage currentPage, Dotenv dotenv) {
        this.currentPage = currentPage;
        this.dotenv = dotenv;
    }

    public void selectResertationClassMenu() {
        currentPage.getPage().locator(dotenv.get("buttonReservation")).click();
    }

    public void selectSide() {
        currentPage.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(dotenv.get("buttonSite"))).click();
    }

    public void selectAfterTomorrowDay() {
        currentPage.getPage().locator(dotenv.get("buttonAfterTomorrow")).click();
    }


}
