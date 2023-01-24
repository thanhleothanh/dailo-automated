package org.example.services;

import org.example.enums.ArticleProvider;
import org.example.utils.VietnamplusConstants;

public class VietnamplusSyncService extends AbstractSyncService {

  public VietnamplusSyncService() {
    super(ArticleProvider.VIETNAMPLUS);
  }

  @Override
  protected void doSetVariables() {
    this.setHEADER_LOCATOR(VietnamplusConstants.VIETNAMPLUS_HEADER);
    this.setDESCRIPTION_LOCATOR(VietnamplusConstants.VIETNAMPLUS_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(VietnamplusConstants.VIETNAMPLUS_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(VietnamplusConstants.VIETNAMPLUS_CONTENT_TO);
  }

  @Override
  protected void initNewsSite() {
    chromeDriverService.openUrl(this.newsSite, VietnamplusConstants.VIETNAMPLUS_URL);
    chromeDriverService.clickOnLocator(this.newsSite, VietnamplusConstants.VIETNAMPLUS_MOBILE_SWITCH);
  }
}
