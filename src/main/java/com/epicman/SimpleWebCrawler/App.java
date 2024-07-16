package com.epicman.SimpleWebCrawler;

import java.io.FileWriter;
import java.net.URL;

public class App {
  public static void main(String[] args) {
    Request req = new Request("https://ojasmaheshwari.netlify.app");
    URL url = req.getUrl();
    System.out.println("Getting " + url.toString());
    String response = req.get();
    try {
      // Write response to file for debugging purposes
      String filename = "./response.html";
      FileWriter fileWriter = new FileWriter(filename);
      fileWriter.write(response);
      fileWriter.close();

      System.out.println("TEST");

      // Search for anchor tags
      Extractor extractor = new Extractor(response);
      System.out.println(extractor.getAnchorTags());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
