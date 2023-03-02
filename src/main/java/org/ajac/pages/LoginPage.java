package org.ajac.pages;

import com.google.inject.Inject;
import io.github.cdimascio.dotenv.Dotenv;

public class LoginPage {
    private final CurrentPage currentPage;
    private final Dotenv dotenv;

    @Inject
    public LoginPage(CurrentPage currentPage, Dotenv dotenv) {
        this.currentPage = currentPage;
        this.dotenv = dotenv;
    }

    public void showPageLogin() {
        currentPage.getPage().navigate(dotenv.get("loginPage"));
    }

    public void fillUsernameField() {
        currentPage.getPage().locator(dotenv.get("usernameXPath")).fill(dotenv.get("username"));
    }

    public void fillPasswordFied() {
        currentPage.getPage().locator(dotenv.get("passwordXPath")).fill(dotenv.get("password"));
    }

    public void login() {
        currentPage.getPage().locator(dotenv.get("buttonLogin")).click();
    }
}
