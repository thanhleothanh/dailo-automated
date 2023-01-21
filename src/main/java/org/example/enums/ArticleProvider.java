package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ArticleProvider {
  VIETNAMPLUS("Vietnamplus"),
  PHAPLUATPLUS("Phapluatplus"),
  TAPCHIGIAOTHONG("Tapchigiaothong"),
  OPENSKY("Opensky");
  private final String name;
}
