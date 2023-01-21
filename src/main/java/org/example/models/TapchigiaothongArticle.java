package org.example.models;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;

public class TapchigiaothongArticle extends Article {

  public TapchigiaothongArticle(String url) {
    super(url, null, ArticleProvider.TAPCHIGIAOTHONG);
  }

  public TapchigiaothongArticle(String url, ArticleCategory category) {
    super(url, category, ArticleProvider.TAPCHIGIAOTHONG);
  }

}
