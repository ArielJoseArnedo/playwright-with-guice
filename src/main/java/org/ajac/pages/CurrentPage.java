package org.ajac.pages;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.vavr.control.Try;

import javax.inject.Singleton;

@Singleton
public class CurrentPage {

    private final Page page;

    public CurrentPage() {
        this.page = create()
          .getOrElseThrow(throwable -> new RuntimeException("Error loading initiation page", throwable));
    }

    private Try<Page> create(){
        return Try.of(Playwright::create)
          .map(Playwright::chromium)
          .map(playwrigth -> playwrigth.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)).newPage());
    }

    public Page getPage() {
        return page;
    }
}
