package org.example;

import java.util.Scanner;
import org.example.enums.ArticleProvider;
import org.example.services.PhapluatplusSyncService;
import org.example.services.TapchigiaothongSyncService;
import org.example.services.VietnamplusSyncService;

public class Main {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      System.out.println();
      System.out.println("=========================================================================");
      System.out.printf("Choose an article provider %s: ", ArticleProvider.getArticleProviderNames());
      String input = in.nextLine();
      ArticleProvider provider = ArticleProvider.of(input);
      switch (provider) {
        case PHAPLUATPLUS:
          PhapluatplusSyncService phapluatplusSyncService = new PhapluatplusSyncService();
          phapluatplusSyncService.doProcess();
          break;
        case VIETNAMPLUS:
          VietnamplusSyncService vietnamplusSyncService = new VietnamplusSyncService();
          vietnamplusSyncService.doProcess();
          break;
        case TAPCHIGIAOTHONG:
          TapchigiaothongSyncService tapchigiaothongSyncService = new TapchigiaothongSyncService();
          tapchigiaothongSyncService.doProcess();
          break;
        default:
          break;
      }
    }
    System.out.println("Process ended!");
    System.exit(0);
  }
}