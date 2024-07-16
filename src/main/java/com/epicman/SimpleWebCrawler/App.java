package com.epicman.SimpleWebCrawler;

import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    Request req = new Request("https://ojasmaheshwari.github.io");
    URL url = req.getUrl();
    System.out.println("Getting " + url.toString());
    String response = req.get();
    try {
      // Write response to file for debugging purposes
      String filename = "./response.html";
      FileWriter fileWriter = new FileWriter(filename);
      fileWriter.write(response);
      fileWriter.close();

      // Search for anchor tags
      Extractor extractor = new Extractor(response);
      ArrayList<String> anchorTags = extractor.getAnchorTags();
      System.out.println("From App.java");
      FileWriter anchorFileWriter = new FileWriter("./anchor_query.html");
      for (int i=0; i<anchorTags.size(); i++) {
      anchorFileWriter.write(anchorTags.get(i));
      }
      anchorFileWriter.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
