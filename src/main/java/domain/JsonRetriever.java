package domain;

import java.io.IOException;
import java.io.InputStream;
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
                + title + "&rvprop=timestamp|user&rvlimit=4&redirects";
    }

    public String search() throws IOException //add connection error message/exception somewhere (maybe not here)
    {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "Revision Tracker/0.1 (http://www.cs.bsu.edu/; yourusername@bsu.edu)");
        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);
        String result = scanner.nextLine();

        return(result);
    }
}
