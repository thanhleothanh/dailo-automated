package org.example.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

  public static ArticleProvider of(String name) {
    return
        Stream.of(ArticleProvider.values())
            .filter(c -> c.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Cant seem to find this provider!"));
  }


  public static List<String> getArticleProviderNames() {
    return Arrays.stream(ArticleProvider.values()).map(ArticleProvider::getName).collect(Collectors.toList());
  }
}
