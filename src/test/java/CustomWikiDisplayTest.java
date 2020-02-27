import domain.Article;
import domain.CustomWikiDisplay;
import domain.JsonRetriever;
import exceptions.ParameterIsNotJsonStringException;
import org.junit.jupiter.api.Test;
import utils.ParseUtils;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomWikiDisplayTest
{
    @Test
    void toStringTestEmpty() throws ParameterIsNotJsonStringException, MalformedURLException
    {
        String title = "";

        JsonRetriever retriever = new JsonRetriever(title);
        String jsonString = retriever.search();
        ParseUtils parser = new ParseUtils();
        Article article = parser.parseJsonToArticle(jsonString);
        CustomWikiDisplay wikiDisplay = new CustomWikiDisplay(article);

        assertEquals("Empty title was entered. Please try again.",
                wikiDisplay.toString());
    }


    @Test
    void toStringTestWithSpaces() throws ParameterIsNotJsonStringException, MalformedURLException
    {
        String title = "Barack Obama";

        JsonRetriever retriever = new JsonRetriever(title);
        String jsonString = retriever.search();
        ParseUtils parser = new ParseUtils();
        Article article = parser.parseJsonToArticle(jsonString);
        CustomWikiDisplay wikiDisplay = new CustomWikiDisplay(article);

        assertEquals("User 'Kiwi128' edited the Wikipedia article at 2020-02-24T09:27:13Z\n" +
                        "User 'Smurrayinchester' edited the Wikipedia article at 2020-02-26T15:00:49Z\n" +
                        "User 'SunCrow' edited the Wikipedia article at 2020-02-23T23:36:12Z\n" +
                        "User 'Ich' edited the Wikipedia article at 2020-02-23T15:20:59Z\n" +
                        "User 'Love of Corey' edited the Wikipedia article at 2020-02-10T08:57:24Z\n" +
                        "User 'Alanscottwalker' edited the Wikipedia article at 2020-02-13T15:14:43Z\n" +
                        "User 'Alanscottwalker' edited the Wikipedia article at 2020-02-13T15:12:54Z\n" +
                        "User 'Alanscottwalker' edited the Wikipedia article at 2020-02-13T15:06:11Z\n" +
                        "User 'Theoptimalhawk' edited the Wikipedia article at 2020-02-17T20:33:09Z\n" +
                        "User 'SunCrow' edited the Wikipedia article at 2020-02-23T23:37:56Z\n" +
                        "User 'SunCrow' edited the Wikipedia article at 2020-02-23T22:41:35Z\n" +
                        "User 'Md320' edited the Wikipedia article at 2020-02-19T17:21:33Z\n" +
                        "User 'SunCrow' edited the Wikipedia article at 2020-02-23T22:43:08Z\n" +
                        "User 'TheMightyDuckmen' edited the Wikipedia article at 2020-02-21T19:07:59Z\n" +
                        "User 'DemonDays64 Bot' edited the Wikipedia article at 2020-02-18T02:57:00Z\n" +
                        "User 'TrailBlzr' edited the Wikipedia article at 2020-02-27T23:15:50Z\n" +
                        "User 'Coffeeandcrumbs' edited the Wikipedia article at 2020-02-13T05:47:59Z\n" +
                        "User 'Brett12212' edited the Wikipedia article at 2020-02-24T09:26:29Z\n" +
                        "User 'TrailBlzr' edited the Wikipedia article at 2020-02-27T23:15:28Z\n" +
                        "User 'DocWatson42' edited the Wikipedia article at 2020-02-13T10:57:56Z\n" +
                        "User 'Sundayclose' edited the Wikipedia article at 2020-02-10T03:00:52Z\n" +
                        "User 'Eyer' edited the Wikipedia article at 2020-02-19T17:31:49Z\n" +
                        "User 'SunCrow' edited the Wikipedia article at 2020-02-23T23:42:56Z\n" +
                        "User 'Alanscottwalker' edited the Wikipedia article at 2020-02-13T15:16:23Z\n" +
                        "User 'SunCrow' edited the Wikipedia article at 2020-02-23T23:44:03Z\n" +
                        "User 'Alanscottwalker' edited the Wikipedia article at 2020-02-13T15:19:06Z\n" +
                        "User 'Alanscottwalker' edited the Wikipedia article at 2020-02-13T15:09:05Z\n" +
                        "User 'Joppa Chong' edited the Wikipedia article at 2020-02-12T00:25:03Z\n" +
                        "User 'Tymon.r' edited the Wikipedia article at 2020-02-21T19:09:29Z\n" +
                        "User 'DemonDays64 Bot' edited the Wikipedia article at 2020-02-19T05:40:38Z\n" +
                        "'BarackObama' redirected to 'Barack Obama'",
                wikiDisplay.toString());
    }
}
