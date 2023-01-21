package org.example.services;

import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import org.example.enums.ArticleProvider;
import org.example.models.Article;
import org.example.utils.DailoConstants;

@Data
public abstract class AbstractSyncService<T extends Article> implements AutomationProcess<T> {

  protected ChromeDriverService chromeDriverService;
  protected Page dailoSite;
  protected Page newsSite;
  protected List<T> articleList = new ArrayList<>();
  private ArticleProvider provider;
  private String HEADER_LOCATOR;
  private String DESCRIPTION_LOCATOR;
  private String CONTENT_LOCATOR_FROM;
  private String CONTENT_LOCATOR_TO;
  private final double DEFAULT_TIMEOUT = 25000.0;
  private final long DEFAULT_WAIT_FOR_SUBMIT = 7000L;

  protected AbstractSyncService(ArticleProvider provider) {
    this.provider = provider;
    this.chromeDriverService = new ChromeDriverService();
    this.dailoSite = chromeDriverService.getBrowser().newPage();
    this.dailoSite.setDefaultNavigationTimeout(DEFAULT_TIMEOUT);
    this.dailoSite.setDefaultTimeout(DEFAULT_TIMEOUT);
    this.newsSite = chromeDriverService.getBrowser().newPage();
    this.newsSite.setDefaultNavigationTimeout(DEFAULT_TIMEOUT);
    this.newsSite.setDefaultTimeout(DEFAULT_TIMEOUT);
  }

  public void doProcess() {
    doSetVariables();
    beforeProcess();
    for (T article : articleList) {
      boolean processed = false;
      while (!processed) {
        try {
          runProcess(article);
          processed = true;
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
    afterProcess();
  }

  protected abstract void initData();

  protected abstract void initNewsSite();

  protected void initDailo() {
    chromeDriverService.openUrl(this.dailoSite, DailoConstants.DAILO_URL);
    chromeDriverService.inputIntoLocator(this.dailoSite, DailoConstants.DAILO_USERNAME, DailoConstants.DAILO_USERNAME_VALUE);
    chromeDriverService.inputIntoLocator(this.dailoSite, DailoConstants.DAILO_PASSWORD, DailoConstants.DAILO_PASSWORD_VALUE);
    chromeDriverService.clickOnLocator(this.dailoSite, DailoConstants.DAILO_LOGIN_BUTTON);
  }

  protected abstract void doSetVariables();

  @Override
  public void beforeProcess() {
    initData();
    initDailo();
    initNewsSite();
  }

  @Override
  public void runProcess(T article) {
    if (!provider.equals(article.getProvider())) {
      System.out.println("invalid article being processed! check your article provider!");
      return;
    }
    if (Objects.nonNull(article.getUrl())) {
      System.out.println("url not found!");
      return;
    }
    chromeDriverService.openUrl(this.newsSite, article.getUrl());
    chromeDriverService.openUrl(this.dailoSite, DailoConstants.DAILO_URL);
    inputHeader();
    selectCategory(article.getCategory().getValue());
    inputDescription();
    inputContent();
    submitArticle();
  }

  @Override
  public void afterProcess() {
    chromeDriverService.getBrowser().close();
  }

  private void inputHeader() {
    chromeDriverService.copyInLocator(this.newsSite, HEADER_LOCATOR);
    chromeDriverService.pasteToLocator(this.dailoSite, DailoConstants.DAILO_HEADER);
  }

  private void selectCategory(Integer dataOptionArrayIndex) {
    chromeDriverService.clickOnLocator(dailoSite, DailoConstants.DAILO_CATEGORY);
    chromeDriverService.clickOnLocator(dailoSite, String.format(DailoConstants.DAILO_CATEGORY_OPTIONS, dataOptionArrayIndex.toString()));
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

  private void submitArticle() {
    //time wait for upload image and submit
    try {
      Thread.sleep(DEFAULT_WAIT_FOR_SUBMIT);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
