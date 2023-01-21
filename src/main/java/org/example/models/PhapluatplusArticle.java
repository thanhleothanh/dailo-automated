package org.example.models;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;

public class PhapluatplusArticle extends Article {
  public PhapluatplusArticle(String url) {
    super(url, null, ArticleProvider.PHAPLUATPLUS);
  }

  public PhapluatplusArticle(String url, ArticleCategory category) {
    super(url, category, ArticleProvider.PHAPLUATPLUS);
  }
}
