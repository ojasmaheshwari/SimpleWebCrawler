package com.epicman.SimpleWebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

class Request {
  private URL url;
  private URI uri;
  private HttpURLConnection conn;
  private BufferedReader reader;
  private StringBuffer response = new StringBuffer();

  public Request(String url) {
    this.setUrl(url);
  }

  public void setUrl (String url) {
    try {
      this.uri = new URI(url);
      this.url = this.uri.toURL();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String get() {
    try {
      conn = (HttpURLConnection) this.url.openConnection();
      conn.setRequestMethod("GET");
      setGeneralConnProps();

      // Instantiate the reader with input stream of conn
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ( (line = reader.readLine()) != null ) {
        response.append(line);
      }
      reader.close();
      return response.toString();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (conn != null) {
        conn.disconnect();
      }
    }

    return null;
  }

  private void setGeneralConnProps() {
    conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/svg+xml");
    conn.setUseCaches(false);
    conn.setDoOutput(true);
  }

  public URL getUrl () {
    return this.url;
  }
}

