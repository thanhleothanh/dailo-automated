package org.example;

import org.example.services.VietnamplusSyncService;

public class Main {

  public static void main(String[] args) {
//    PhapluatplusSyncService service = new PhapluatplusSyncService();
//    service.doProcess();
    VietnamplusSyncService service = new VietnamplusSyncService();
    service.doProcess();
//    TapchigiaothongSyncService service = new TapchigiaothongSyncService();
//    service.doProcess();
  }
}