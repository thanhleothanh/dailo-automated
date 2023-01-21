package org.example.controllers;

import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.example.enums.ArticleProvider;
import org.example.models.Article;
import org.example.services.ChromeDriverService;
import org.example.utils.DailoConstants;

@Data
public abstract class AbstractController<T extends Article> implements AutomationProcess<T> {

  protected ChromeDriverService chromeDriverService;
  protected Page dailoSite;
  protected Page newsSite;
  protected List<T> articleList = new ArrayList<>();
  private ArticleProvider provider;
  private String HEADER_LOCATOR;
  private String DESCRIPTION_LOCATOR;
  private String CONTENT_LOCATOR_FROM;
  private String CONTENT_LOCATOR_TO;

  protected AbstractController(ArticleProvider provider) {
    this.provider = provider;
    this.chromeDriverService = new ChromeDriverService();
    this.dailoSite = chromeDriverService.getBrowser().newPage();
    this.newsSite = chromeDriverService.getBrowser().newPage();
  }

  public void doProcess() {
    doSetVariables();
    initData();
    initDailo();
    initNewsSite();
    for (T article : articleList) {
      if (provider.equals(article.getProvider())) {
        try {
          runProcess(article);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
    chromeDriverService.getBrowser().close();
  }

  protected abstract void doSetVariables();

  @Override
  public void initDailo() {
    chromeDriverService.openUrl(this.dailoSite, DailoConstants.DAILO_URL);
    chromeDriverService.inputIntoLocator(this.dailoSite, DailoConstants.DAILO_USERNAME, DailoConstants.DAILO_USERNAME_VALUE);
    chromeDriverService.inputIntoLocator(this.dailoSite, DailoConstants.DAILO_PASSWORD, DailoConstants.DAILO_PASSWORD_VALUE);
    chromeDriverService.clickOnLocator(this.dailoSite, DailoConstants.DAILO_LOGIN_BUTTON);
    chromeDriverService.openUrl(this.dailoSite, DailoConstants.DAILO_URL);
  }

  @Override
  public void runProcess(T article) {
    chromeDriverService.openUrl(this.dailoSite, DailoConstants.DAILO_URL);
    chromeDriverService.openUrl(this.newsSite, article.getUrl());
    inputHeader();
    selectCategory(article.getCategory().getValue());
    inputDescription();
    inputContent();
    submitArticle();
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
      Thread.sleep(7000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
