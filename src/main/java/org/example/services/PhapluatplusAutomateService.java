package org.example.services;

import org.example.enums.ArticleProvider;
import org.example.utils.PhapluatplusConstants;

public class PhapluatplusAutomateService extends AbstractAutomateService {

  public PhapluatplusAutomateService() {
    super(ArticleProvider.PHAPLUATPLUS);
  }

  @Override
  protected void doSetVariables() {
    this.setNEWS_SITE_URL(PhapluatplusConstants.PHAPLUATPLUS_URL);
    this.setHEADER_LOCATOR(PhapluatplusConstants.PHAPLUATPLUS_HEADER);
    this.setDESCRIPTION_LOCATOR(PhapluatplusConstants.PHAPLUATPLUS_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_TO);
  }
}
