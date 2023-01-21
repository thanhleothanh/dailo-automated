package org.example.controllers;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;
import org.example.models.PhapluatplusArticle;
import org.example.utils.PhapluatplusConstants;

public class PhapluatplusController extends AbstractController<PhapluatplusArticle> {

  public PhapluatplusController() {
    super(ArticleProvider.PHAPLUATPLUS);
  }

  @Override
  protected void doSetVariables() {
    this.setHEADER_LOCATOR(PhapluatplusConstants.PHAPLUATPLUS_HEADER);
    this.setDESCRIPTION_LOCATOR(PhapluatplusConstants.PHAPLUATPLUS_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_TO);
  }

  @Override
  public void initData() {
    ArticleCategory category = ArticleCategory.DOISONGXAHOI;
    this.articleList.add(new PhapluatplusArticle("", category));
    this.articleList.add(new PhapluatplusArticle("", category));
    this.articleList.add(new PhapluatplusArticle("", category));
    this.articleList.add(new PhapluatplusArticle("", category));
    this.articleList.add(new PhapluatplusArticle("", category));
    this.articleList.add(new PhapluatplusArticle("", category));
    this.articleList.add(new PhapluatplusArticle("", category));
  }

  @Override
  public void initNewsSite() {
    chromeDriverService.openUrl(this.newsSite, PhapluatplusConstants.PHAPLUATPLUS_URL);
  }
}
