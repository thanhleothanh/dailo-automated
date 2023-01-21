package org.example.services;

import com.microsoft.playwright.Page;

public interface KeyboardActions {

  default void copy(Page page) {
    page.keyboard().press("Control+C");
  }

  default void paste(Page page) {
    page.keyboard().press("Control+V");
  }

  default void keyDown(Page page, String key) {
    page.keyboard().down(key);
  }

  default void keyUp(Page page, String key) {
    page.keyboard().up(key);
  }
}
