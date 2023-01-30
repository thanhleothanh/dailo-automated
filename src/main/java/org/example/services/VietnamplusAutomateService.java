package org.example.services;

import org.example.enums.ArticleProvider;
import org.example.utils.VietnamplusConstants;

public class VietnamplusAutomateService extends AbstractAutomateService {

  public VietnamplusAutomateService() {
    super(ArticleProvider.VIETNAMPLUS);
  }

  @Override
  protected void doSetVariables() {
    this.setNewsSiteUrl(VietnamplusConstants.VIETNAMPLUS_URL);
    this.setHeaderLocator(VietnamplusConstants.VIETNAMPLUS_HEADER);
    this.setDescriptionLocator(VietnamplusConstants.VIETNAMPLUS_DESCRIPTION);
    this.setContentLocatorFrom(VietnamplusConstants.VIETNAMPLUS_CONTENT_FROM);
    this.setContentLocatorTo(VietnamplusConstants.VIETNAMPLUS_CONTENT_TO);
  }
}
