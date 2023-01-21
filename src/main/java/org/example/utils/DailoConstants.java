package org.example.utils;

public class DailoConstants {

  public static String DAILO_URL = "http://dailo.vn/admin/news/add-news/";
  public static String DAILO_USERNAME = "//*[@id=\"login\"]/form/p[1]/input";
  public static String DAILO_USERNAME_VALUE = "admintrinh";
  public static String DAILO_PASSWORD = "//*[@id=\"password\"]";
  public static String DAILO_PASSWORD_VALUE = "admintrinh12@";
  public static String DAILO_LOGIN_BUTTON = "//*[@id=\"login\"]/form/button/span";
  public static String DAILO_HEADER = "//*[@id=\"title\"]";
  public static String DAILO_CATEGORY = "//*[@id=\"chosen_categories_id_chosen\"]";
  public static String DAILO_CATEGORY_OPTIONS = "li[class=\"active-result\"][data-option-array-index=\"%s\"]";
  public static String DAILO_DESCRIPTION_IFRAME = "//*[@id=\"description_ifr\"]";
  public static String DAILO_CONTENT_IFRAME = "//*[@id=\"wysiwyg_content_ifr\"]";
  public static String DAILO_CONTENT_IFRAME_BODY = "#tinymce";
  public static String DAILO_SUBMIT_BUTTON = "//*[@id=\"ajax-load-data\"]/div[2]/div[1]/div[2]/div[1]/div/div[1]";
}
