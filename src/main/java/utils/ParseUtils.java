package utils;

import com.google.gson.*;
import exceptions.ParameterIsNotJsonStringException;
import model.Article;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class ParseUtils
{
    public static Article parseJsonToArticle(String JsonString) throws ParameterIsNotJsonStringException
    {
        if(!JsonString.startsWith("{"))
        {
            throw new ParameterIsNotJsonStringException();
        }

        //Article parts
            String title = null;
            HashMap<String, String> timestampsAndUsernames = new HashMap<>();
                String time;
                String username;
            String redirectionString = "";
            Boolean redirectionBoolean = false;

        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(JsonString);
        JsonObject rootObject = rootElement.getAsJsonObject();

        //if(redirected)
        //{
        //    redirected = rootObject.getAsJsonObject("query").getAsJsonArray("redirects").get(0).getAsJsonObject().getAsJsonPrimitive("from").getAsString();
        //}

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
        Article article = new Article(title, timestampsAndUsernames, redirectionString);
        return article;
    }
}


