package com.epicman.SimpleWebCrawler;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class Extractor {
  private String htmlContent;
  private HashMap<String, String> rules = new HashMap<>();
    
  public Extractor(String htmlContent) {
    this.htmlContent = htmlContent;

    // Add regex rules
    rules.put("anchor_rule", "<a[\\s]+[^>]+>(|((?:.(?!\\<\\/a\\>))*.))<\\/a>");
  }

  public ArrayList<String> getAnchorTags() {
    if (htmlContent.isEmpty()) {
      throw new RuntimeException("HTML Content is empty!");
    }
    String anchorRule = rules.get("anchor_rule"); 
    Pattern anchorPattern = Pattern.compile(anchorRule, Pattern.MULTILINE);
    Matcher anchorMatcher = anchorPattern.matcher(htmlContent);
    ArrayList<String> result = new ArrayList<>();

    while (anchorMatcher.find()) {
      for (int i=0; i<anchorMatcher.groupCount(); i++) {
        result.add(anchorMatcher.group(i));
      }
    }

    return result;
  }
}
