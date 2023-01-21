package org.example.services;

import org.example.models.Article;

public interface AutomationProcess<T extends Article> {
  void beforeProcess();
  void runProcess(T article);
  void afterProcess();
}
