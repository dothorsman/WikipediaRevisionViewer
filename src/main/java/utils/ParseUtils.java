package utils;

import com.google.gson.*;
import exceptions.ParameterIsNotJsonStringException;
import domain.Article;

import java.util.HashMap;
import java.util.Map;

public class ParseUtils
{
    public static Article parseJsonToArticle(String jsonString) throws ParameterIsNotJsonStringException
    {
        if(!jsonString.startsWith("{"))
        {
            throw new ParameterIsNotJsonStringException();
        }

        String title = null;
        HashMap<String, String> timestampsAndUsernames = new HashMap<>();
            String time;
            String username;
        String redirectionString = "No redirection required";

        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(jsonString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array;
        for (Map.Entry<String, JsonElement> entry : pages.entrySet())
        {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            title = entryObject.getAsJsonPrimitive("title").getAsString();
            array = entryObject.getAsJsonArray("revisions");
            for (int i = 0; i < array.size(); i++)
            {
                JsonObject individualRevisionObject = array.get(i).getAsJsonObject();
                username = individualRevisionObject.getAsJsonPrimitive("user").getAsString();
                time = individualRevisionObject.getAsJsonPrimitive("timestamp").getAsString();
                timestampsAndUsernames.put(time, username);
            }
        }

        if(jsonString.contains("redirects"))
        {
            redirectionString = "'"+ rootObject.getAsJsonObject("query").getAsJsonArray("redirects").get(0).getAsJsonObject().getAsJsonPrimitive("from").getAsString()
                    + "' redirected to '" + title + "'";
        }

        Article article = new Article(title, timestampsAndUsernames, redirectionString);
        return article;
    }
}


