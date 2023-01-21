package org.example.controllers;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;
import org.example.models.TapchigiaothongArticle;
import org.example.utils.TapchigiaothongConstants;

public class TapchigiaothongController extends AbstractController<TapchigiaothongArticle> {

  public TapchigiaothongController() {
    super(ArticleProvider.TAPCHIGIAOTHONG);
  }

  @Override
  protected void doSetVariables() {
    this.setHEADER_LOCATOR(TapchigiaothongConstants.TAPCHIGIAOTHONG_HEADER);
    this.setDESCRIPTION_LOCATOR(TapchigiaothongConstants.TAPCHIGIAOTHONG_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(TapchigiaothongConstants.TAPCHIGIAOTHONG_CONTENT_TO);
  }

  @Override
  public void initData() {
    ArticleCategory category = ArticleCategory.GIAOTHONGVANTAI;
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/thanh-tra-so-gtvt-da-nang-xu-phat-loat-phuong-tien-tai-xe-vi-pham-van-chuyen-hanh-khach-183230120150746469.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/bo-gtvt-phat-dong-phong-trao-thi-dua-nam-2023-183230117162556322.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/da-nang-xu-ly-xe-khach-42-cho-nhoi-nhet-57-nguoi-183230119095207939.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/nhan-vien-duong-sat-tra-lai-hanh-khach-hon-30-trieu-dong-bo-quen-tren-tau-18323011923571917.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/metro-nhon-ga-ha-noi-khong-kip-khai-thac-dip-tet-tuyen-nhan-su-den-het-thang-1-2023-183230121111610989.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/cap-nhat-gio-mo-dong-tuyen-tau-cat-linh-ha-dong-tu-mung-1-den-mung-5-tet-nguyen-dan-2023-183230121120906312.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/thanh-tra-so-gtvt-da-nang-xu-phat-loat-phuong-tien-tai-xe-vi-pham-van-chuyen-hanh-khach-183230120150746469.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/cong-doan-gtvt-viet-chuc-tet-nguoi-lao-dong-cac-don-dang-truc-tet-183230121090907637.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/cap-nhat-gio-mo-dong-tuyen-tau-cat-linh-ha-dong-tu-mung-1-den-mung-5-tet-nguyen-dan-2023-183230121120906312.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/metro-nhon-ga-ha-noi-khong-kip-khai-thac-dip-tet-tuyen-nhan-su-den-het-thang-1-2023-183230121111610989.htm", category));
    this.articleList.add(new TapchigiaothongArticle("https://tapchigiaothong.vn/cong-doan-gtvt-viet-chuc-tet-nguoi-lao-dong-cac-don-dang-truc-tet-183230121090907637.htm", category));
  }

  @Override
  public void initNewsSite() {
    chromeDriverService.openUrl(this.newsSite, TapchigiaothongConstants.TAPCHIGIAOTHONG_URL);
  }
}
