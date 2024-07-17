package com.epicman.SimpleWebCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Extractor {

  public static Document create(String htmlContent) {
    Document document = Jsoup.parse(htmlContent);
    return document;
  }
}
