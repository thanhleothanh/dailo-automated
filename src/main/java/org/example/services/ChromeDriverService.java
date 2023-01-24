package org.example.services;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ChromeDriverService implements AutoCloseable, KeyboardActions {

  private final Playwright playWrightInstance;
  private final Browser browser;

  public ChromeDriverService() {
    playWrightInstance = Playwright.create();
    browser = playWrightInstance.chromium().launch(new LaunchOptions().setHeadless(false));
  }

  public void openUrl(Page page, String url) {
    page.navigate(url);
  }

  public void inputIntoLocator(Page page, String uniqueLocator, String input) {
    Locator locator = page.locator(uniqueLocator);
    locator.fill(input);
  }

  public void clickOnLocator(Page page, String uniqueLocator) {
    Locator locator = page.locator(uniqueLocator);
    locator.click();
  }

  public void copyInLocator(Page page, String uniqueLocator) {
    Locator locator = page.locator(uniqueLocator);
    locator.click(new ClickOptions().setClickCount(3));
    copy(page);
  }

  public void pasteToLocator(Page page, String uniqueLocator) {
    Locator locator = page.locator(uniqueLocator);
    locator.focus();
    paste(page);
  }

  public void typeToIFrameLocator(Page page, String iFrameLocator, String iFrameInputLocator, String input) {
    page.frameLocator(iFrameLocator).locator(iFrameInputLocator).type(input);
  }

  public void selectAndCopyInLocators(Page page, String uniqueLocatorFrom, String uniqueLocatorTo) {
    Locator locatorTo = page.locator(uniqueLocatorFrom);
    locatorTo.click(new ClickOptions().setClickCount(3));
    keyDown(page, "Shift");

    Locator locatorFrom = page.locator(uniqueLocatorTo);
    locatorFrom.click();
    keyUp(page, "Shift");

    copy(page);
  }

  public Browser getBrowser() {
    return browser;
  }

  @Override
  public void close() {
    playWrightInstance.close();
  }
}
