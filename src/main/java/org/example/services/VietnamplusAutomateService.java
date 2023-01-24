package org.example.services;

import org.example.enums.ArticleProvider;
import org.example.utils.VietnamplusConstants;

public class VietnamplusAutomateService extends AbstractAutomateService {

  public VietnamplusAutomateService() {
    super(ArticleProvider.VIETNAMPLUS);
  }

  @Override
  protected void doSetVariables() {
    this.setNEWS_SITE_URL(VietnamplusConstants.VIETNAMPLUS_URL);
    this.setHEADER_LOCATOR(VietnamplusConstants.VIETNAMPLUS_HEADER);
    this.setDESCRIPTION_LOCATOR(VietnamplusConstants.VIETNAMPLUS_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(VietnamplusConstants.VIETNAMPLUS_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(VietnamplusConstants.VIETNAMPLUS_CONTENT_TO);
  }
}
