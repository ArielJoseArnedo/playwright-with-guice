package org.ajac.tasks;

import com.google.inject.Inject;
import org.ajac.pages.LoginPage;

public class LoginFlow {

    private final LoginPage loginPage;

    @Inject
    public LoginFlow(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void showPageLogin() {
        loginPage.showPageLogin();
    }

    public void startLogin() {
        loginPage.fillUsernameField();
        loginPage.fillPasswordFied();
        loginPage.login();
    }
}
