package org.example.services;

import org.example.enums.ArticleProvider;
import org.example.utils.TapchigiaothongConstants;

public class TapchigiaothongAutomateService extends AbstractAutomateService {

  public TapchigiaothongAutomateService() {
    super(ArticleProvider.TAPCHIGIAOTHONG);
  }

  @Override
  protected void doSetVariables() {
    this.setNewsSiteUrl(TapchigiaothongConstants.TAPCHIGIAOTHONG_URL);
    this.setHeaderLocator(TapchigiaothongConstants.TAPCHIGIAOTHONG_HEADER);
    this.setDescriptionLocator(TapchigiaothongConstants.TAPCHIGIAOTHONG_DESCRIPTION);
    this.setContentLocatorFrom(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_FROM);
    this.setContentLocatorTo(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_TO);
  }
}
