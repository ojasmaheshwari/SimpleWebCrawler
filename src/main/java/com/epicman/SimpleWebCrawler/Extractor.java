package com.epicman.SimpleWebCrawler;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class Extractor {
  private String htmlContent;
  private HashMap<String, String> rules = new HashMap<>();
    
  public Extractor(String htmlContent) {
    this.htmlContent = htmlContent;

    // Add regex rules
    rules.put("anchor_rule", "<a[\\s]+[^>]+>(|((?:.(?!\\<\\/a\\>))*.))<\\/a>");
  }

  public String getAnchorTags() {
    if (htmlContent.isEmpty()) {
      throw new RuntimeException("HTML Content is empty!");
    }
    String anchorRule = rules.get("anchor_rule"); 
    Pattern anchorPattern = Pattern.compile(anchorRule, Pattern.MULTILINE);
    Matcher anchorMatcher = anchorPattern.matcher(htmlContent);

    if (anchorMatcher.find()) {
      return anchorMatcher.group(0);
    }
    else {
      return "MATCH_NOT_FOUND";
    }
  }
}
