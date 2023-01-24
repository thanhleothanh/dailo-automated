package org.example;

import java.util.Scanner;
import org.example.enums.ArticleProvider;
import org.example.services.PhapluatplusAutomateService;
import org.example.services.TapchigiaothongAutomateService;
import org.example.services.VietnamplusAutomateService;

public class Main {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      System.out.println();
      System.out.println("=================================================================================================");
      System.out.printf("Choose an article provider %s: ", ArticleProvider.getArticleProviderNames());
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
    System.out.println("Process ended!");
    System.exit(0);
  }
}