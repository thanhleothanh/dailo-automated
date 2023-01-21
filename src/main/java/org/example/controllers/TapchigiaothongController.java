package org.example.controllers;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;
import org.example.models.TapchigiaothongArticle;
import org.example.utils.TapchigiaothongConstants;

public class TapchigiaothongController extends AbstractController<TapchigiaothongArticle> {

  public TapchigiaothongController() {
    super(ArticleProvider.TAPCHIGIAOTHONG);
  }

  @Override
  protected void doSetVariables() {
    this.setHEADER_LOCATOR(TapchigiaothongConstants.TAPCHIGIAOTHONG_HEADER);
    this.setDESCRIPTION_LOCATOR(TapchigiaothongConstants.TAPCHIGIAOTHONG_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_TO);
  }

  @Override
  public void initData() {
    ArticleCategory category = ArticleCategory.GIAOTHONGVANTAI;
    this.articleList.add(new TapchigiaothongArticle("", category));
    this.articleList.add(new TapchigiaothongArticle("", category));
    this.articleList.add(new TapchigiaothongArticle("", category));
    this.articleList.add(new TapchigiaothongArticle("", category));
    this.articleList.add(new TapchigiaothongArticle("", category));
    this.articleList.add(new TapchigiaothongArticle("", category));
    this.articleList.add(new TapchigiaothongArticle("", category));
    this.articleList.add(new TapchigiaothongArticle("", category));
  }

  @Override
  public void initNewsSite() {
    chromeDriverService.openUrl(this.newsSite, TapchigiaothongConstants.TAPCHIGIAOTHONG_URL);
  }
}
