package org.example.services;

import com.microsoft.playwright.Page;
import java.util.Objects;
import java.util.Scanner;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.ArticleProvider;
import org.example.utils.Constants;
import org.example.utils.DailoConstants;

@Data
public abstract class AbstractAutomateService implements AutomationProcess {

  private static final Logger log = LogManager.getLogger(AbstractAutomateService.class);

  protected ChromeDriverService chromeDriverService;
  protected Page dailoSite;
  protected Page newsSite;
  private ArticleProvider provider;
  private String NEWS_SITE_URL;
  private String HEADER_LOCATOR;
  private String DESCRIPTION_LOCATOR;
  private String CONTENT_LOCATOR_FROM;
  private String CONTENT_LOCATOR_TO;

  protected AbstractAutomateService(ArticleProvider provider) {
    this.provider = provider;
    this.chromeDriverService = new ChromeDriverService();
  }

  public void doProcess() {
    doSetVariables();
    beforeProcess();
    runProcess();
    afterProcess();
  }

  protected abstract void doSetVariables();

  @Override
  public void beforeProcess() {
    this.dailoSite = chromeDriverService.getBrowser().newPage();
    this.newsSite = chromeDriverService.getBrowser().newPage();
    this.newsSite.setDefaultNavigationTimeout(Constants.DEFAULT_TIMEOUT);
    this.newsSite.setDefaultTimeout(Constants.DEFAULT_TIMEOUT);
    chromeDriverService.openUrl(this.dailoSite, DailoConstants.DAILO_URL);
    chromeDriverService.inputIntoLocator(this.dailoSite, DailoConstants.DAILO_USERNAME, DailoConstants.DAILO_USERNAME_VALUE);
    chromeDriverService.inputIntoLocator(this.dailoSite, DailoConstants.DAILO_PASSWORD, DailoConstants.DAILO_PASSWORD_VALUE);
    chromeDriverService.clickOnLocator(this.dailoSite, DailoConstants.DAILO_LOGIN_BUTTON);
    chromeDriverService.openUrl(this.dailoSite, DailoConstants.DAILO_URL);
  }


  @Override
  public void runProcess() {
    try (Scanner in = new Scanner(System.in)) {
      log.info("-------------------------------{}-------------------------------", provider.getName());
      int counter = 0;
      while (true) {
        log.info("(Processed: {}) Enter url, \"exit\" to exit: ", counter);
        String url = in.nextLine();
        if (Objects.isNull(url) || url.trim().equalsIgnoreCase(Constants.EXIT_KEYWORD)) {
          return;
        }
        try {
          chromeDriverService.openUrl(this.newsSite, url.trim());
          inputHeader();
          inputDescription();
          inputContent();
          counter++;
        } catch (Exception e) {
          log.error(e.getMessage());
        }
      }
    }
  }

  @Override
  public void afterProcess() {
    chromeDriverService.getBrowser().close();
  }

  private void inputHeader() {
    chromeDriverService.copyInLocator(this.newsSite, HEADER_LOCATOR);
    chromeDriverService.pasteToLocator(this.dailoSite, DailoConstants.DAILO_HEADER);
  }

  private void inputDescription() {
    chromeDriverService.copyInLocator(this.newsSite, DESCRIPTION_LOCATOR);
    chromeDriverService.pasteToLocator(this.dailoSite, DailoConstants.DAILO_DESCRIPTION_IFRAME);
  }

  private void inputContent() {
    chromeDriverService.selectAndCopyInLocators(this.newsSite, CONTENT_LOCATOR_FROM, CONTENT_LOCATOR_TO);
    chromeDriverService.pasteToLocator(this.dailoSite, DailoConstants.DAILO_CONTENT_IFRAME);
    chromeDriverService.typeToIFrameLocator(
        this.dailoSite,
        DailoConstants.DAILO_CONTENT_IFRAME,
        DailoConstants.DAILO_CONTENT_IFRAME_BODY,
        newsSite.url());
  }
}
