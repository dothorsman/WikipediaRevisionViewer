package model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Article
{
    private String title;
    private Map<String, String> timestampsAndUsernames;

    private String redirectionString;
    private boolean redirectionBoolean;

    //add another map?


    public Article(String title, Map timestampsAndUsernames, String redirectionString)
    {
        this.title = title;
        this.timestampsAndUsernames = timestampsAndUsernames;
        this.redirectionString = redirectionString;
        //map?
    }

    public String getTitle() { return title; }

    public String getTimestamps()
    {
        String result = "";
        for (Map.Entry<String, String> entry : timestampsAndUsernames.entrySet())
        {
            result += (entry.getKey()) + ", ";

        }
        return(result);
    }

    public String getUsernames()
    {
        String result = "";
        for (Map.Entry<String, String> entry : timestampsAndUsernames.entrySet())
        {
            result += (entry.getValue()) + ", ";

        }
        return(result);
    }

    public boolean redirectionUsed() { return redirectionBoolean; }
}
