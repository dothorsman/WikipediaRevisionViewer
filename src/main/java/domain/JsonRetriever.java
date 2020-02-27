package domain;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class JsonRetriever
{
    private String urlString; 
    private String JsonString;

    public JsonRetriever(String title)
    {
        this.urlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                + title.replaceAll("\\s", "") + "&rvprop=timestamp|user&rvlimit=30&redirects";
    }

    public String search() throws MalformedURLException
    {
        URL url = new URL(urlString);
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.setRequestProperty("User-Agent",
                "Revision Tracker/0.1 (http://www.cs.bsu.edu/; yourusername@bsu.edu)");
        InputStream in = null;
        try {
            in = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(in);
        String result = scanner.nextLine();

        return(result);
    }
}
