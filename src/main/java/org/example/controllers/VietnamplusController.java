package org.example.controllers;

import org.example.enums.ArticleCategory;
import org.example.enums.ArticleProvider;
import org.example.models.VietnamplusArticle;
import org.example.utils.VietnamplusConstants;

public class VietnamplusController extends AbstractController<VietnamplusArticle> {

  public static ArticleProvider provider = ArticleProvider.VIETNAMPLUS;

  public VietnamplusController() {
    super();
  }

  @Override
  protected void doSetVariables() {
    this.setProvider(provider);
    this.setHEADER_LOCATOR(VietnamplusConstants.VIETNAMPLUS_HEADER);
    this.setDESCRIPTION_LOCATOR(VietnamplusConstants.VIETNAMPLUS_DESCRIPTION);
    this.setCONTENT_LOCATOR_FROM(VietnamplusConstants.VIETNAMPLUS_CONTENT_FROM);
    this.setCONTENT_LOCATOR_TO(VietnamplusConstants.VIETNAMPLUS_CONTENT_TO);
  }

  @Override
  public void initData() {
    ArticleCategory category = ArticleCategory.DOISONGXAHOI;
    this.articleList.add(new VietnamplusArticle("https://www.vietnamplus.vn/nhung-phuong-phap-phong-chong-ngo-doc-giai-ruou-dip-tet/841727.vnp", category));
    this.articleList.add(new VietnamplusArticle("https://www.vietnamplus.vn/tao-nhieu-san-pham-du-lich-suc-khoe-dang-cap-cho-du-lich-co-do-hue/842281.vnp", category));
  }

  @Override
  public void initNewsSite() {
    chromeDriverService.openUrl(this.newsSite, VietnamplusConstants.VIETNAMPLUS_URL);
    chromeDriverService.clickOnLocator(this.newsSite, VietnamplusConstants.VIETNAMPLUS_MOBILE_SWITCH);
  }
}
