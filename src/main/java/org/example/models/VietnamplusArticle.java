package org.example.models;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;

public class VietnamplusArticle extends Article {

  public VietnamplusArticle(String url) {
    super(url, null, ArticleProvider.VIETNAMPLUS);
  }

  public VietnamplusArticle(String url, ArticleCategory category) {
    super(url, category, ArticleProvider.VIETNAMPLUS);
  }

}
