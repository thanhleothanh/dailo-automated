package org.example.controllers;

public interface AutomationProcess<T> {
  void initDailo();
  void initData();
  void initNewsSite();
  void runProcess(T article);
}
