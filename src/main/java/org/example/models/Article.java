package org.example.models;

import java.io.Serializable;
import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;

public class Article implements Serializable {
  private String url;
  private ArticleCategory category = ArticleCategory.BANDOC;
  private ArticleProvider provider;

  public Article(String url, ArticleProvider provider) {
    this.url = url;
    this.provider = provider;
  }

  public Article(String url, ArticleCategory category, ArticleProvider provider) {
    this.url = url;
    this.category = category;
    this.provider = provider;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ArticleCategory getCategory() {
    return category;
  }

  public void setCategory(ArticleCategory category) {
    this.category = category;
  }

  public ArticleProvider getProvider() {
    return provider;
  }
}
