package org.example.services;

import org.example.enums.ArticleProvider;
import org.example.utils.TapchigiaothongConstants;

public class TapchigiaothongAutomateService extends AbstractAutomateService {

  public TapchigiaothongAutomateService() {
    super(ArticleProvider.TAPCHIGIAOTHONG);
  }

  @Override
  protected void doSetVariables() {
    this.setNEWS_SITE_URL(TapchigiaothongConstants.TAPCHIGIAOTHONG_URL);
    this.setHEADER_LOCATOR(TapchigiaothongConstants.TAPCHIGIAOTHONG_HEADER);
    this.setDESCRIPTION_LOCATOR(TapchigiaothongConstants.TAPCHIGIAOTHONG_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_TO);
  }
}
