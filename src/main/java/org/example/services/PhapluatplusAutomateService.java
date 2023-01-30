package org.example.services;

import org.example.enums.ArticleProvider;
import org.example.utils.PhapluatplusConstants;

public class PhapluatplusAutomateService extends AbstractAutomateService {

  public PhapluatplusAutomateService() {
    super(ArticleProvider.PHAPLUATPLUS);
  }

  @Override
  protected void doSetVariables() {
    this.setNewsSiteUrl(PhapluatplusConstants.PHAPLUATPLUS_URL);
    this.setHeaderLocator(PhapluatplusConstants.PHAPLUATPLUS_HEADER);
    this.setDescriptionLocator(PhapluatplusConstants.PHAPLUATPLUS_DESCRIPTION);
    this.setContentLocatorFrom(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_FROM);
    this.setContentLocatorTo(PhapluatplusConstants.PHAPLUATPLUS_CONTENT_TO);
  }
}
