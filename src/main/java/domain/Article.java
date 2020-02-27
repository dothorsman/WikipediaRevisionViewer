package domain;

import java.util.Map;

public class Article
{
    private String title;
    private Map<String, String> timestampsAndUsernames;
    private String redirectionString;

    public Article(String title, Map timestampsAndUsernames, String redirectionString)
    {
        this.title = title;
        this.timestampsAndUsernames = timestampsAndUsernames;
        this.redirectionString = redirectionString;
    }

    public String getTitle()
    {
        return title;
    }

    public String getChanges()
    {
        String result = "";
        for (Map.Entry<String, String> entry : timestampsAndUsernames.entrySet())
        {
            result += "User '" + (entry.getValue() + "' edited the Wikipedia article at " + entry.getKey() + "\n");
            //reformat timestamps?
        }
        return(result);
    }


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

    public String getRedirection()
    {
        return redirectionString;
    }
}
