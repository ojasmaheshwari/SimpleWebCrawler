package com.epicman.SimpleWebCrawler;

import java.io.FileWriter;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

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

      Document doc = Extractor.create(response);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
