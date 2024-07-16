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
      String filename = "./response.html";
      FileWriter fileWriter = new FileWriter(filename);
      fileWriter.write(response);
      fileWriter.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
