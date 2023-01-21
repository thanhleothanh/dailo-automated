package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleCategory {
  TIEUDIEM(0, "Tiêu điểm"),
  CHUYENDE(1, "Chuyên đề"),
  DOCNHIEU(2, "Đọc nhiều"),
  BANDOC(3, "Bạn đọc"),
  DUHOCSUKIEN(4, "Du học sự kiện"),
  THETHAOVANHOA(5, "Thể thao văn hoá"),
  PHAPLUAT(6, "Pháp luật"),
  KINHTE(7, "Kinh tế"),
  DOISONGXAHOI(8, "Đời sống xã hội"),
  DUONGTHUYNOIDIA(9, "Đường thuỷ nội địa"),
  ANTOANGIAOTHONG(10, "An toàn giao thông"),
  GIAOTHONGVANTAI(11, "Giao thông vận tải");
  private Integer value;
  private String name;
}