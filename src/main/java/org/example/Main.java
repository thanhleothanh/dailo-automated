package org.example;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.ArticleProvider;
import org.example.services.PhapluatplusAutomateService;
import org.example.services.TapchigiaothongAutomateService;
import org.example.services.VietnamplusAutomateService;

public class Main {
  private static final Logger log = LogManager.getLogger(Main.class);

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      log.info("Choose an article provider {}: ", ArticleProvider.getArticleProviderNames());
      String input = in.nextLine();
      ArticleProvider provider = ArticleProvider.of(input);
      switch (provider) {
        case PHAPLUATPLUS:
          new PhapluatplusAutomateService().doProcess();
          break;
        case VIETNAMPLUS:
          new VietnamplusAutomateService().doProcess();
          break;
        case TAPCHIGIAOTHONG:
          new TapchigiaothongAutomateService().doProcess();
          break;
        default:
          break;
      }
    }
    log.warn("Process ended!");
    System.exit(0);
  }
}