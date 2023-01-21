package org.example.controllers;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;
import org.example.models.PhapluatplusArticle;
import org.example.utils.PhapluatplusConstants;

public class PhapluatplusController extends AbstractController<PhapluatplusArticle> {

  public static ArticleProvider provider = ArticleProvider.PHAPLUATPLUS;

  public PhapluatplusController() {
    super();
  }

  @Override
  protected void doSetVariables() {
    this.setProvider(provider);
    this.setHEADER_LOCATOR(PhapluatplusConstants.PHAPLUATPLUS_HEADER);
    this.setDESCRIPTION_LOCATOR(PhapluatplusConstants.PHAPLUATPLUS_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_TO);
  }

  @Override
  public void initData() {
    ArticleCategory category = ArticleCategory.BANDOC;
    this.articleList.add(new PhapluatplusArticle("", category));
  }

  @Override
  public void initNewsSite() {
    chromeDriverService.openUrl(this.newsSite, PhapluatplusConstants.PHAPLUATPLUS_URL);
  }
}
