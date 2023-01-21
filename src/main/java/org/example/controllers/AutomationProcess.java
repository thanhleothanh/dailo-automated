package org.example.controllers;

import org.example.models.Article;

public interface AutomationProcess<T extends Article> {
  void initDailo();
  void initData();
  void initNewsSite();
  void runProcess(T article);
}
