package model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParseJson
{
    public static Article parseJsonToArticleDirect(String jsonString)
    {
        Article article = null;
        if (jsonString.startsWith("{")) {
            Gson gson = new Gson();
            article = gson.fromJson(jsonString, Article.class);
        }
        return article;
    }

    public static Article parseJsonToArticleManual(String jsonString)
    {
        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(jsonString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        var articleTitle = rootObject.getAsJsonPrimitive("title").getAsString();
        var revisions = rootObject.getAsJsonPrimitive("revisions").getAsString();


        return new Article(articleTitle, revisions);
    }

}
