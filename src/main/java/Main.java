import exceptions.ParameterIsNotJsonStringException;
import domain.Article;
import domain.CustomWikiDisplay;
import domain.JsonRetriever;
import utils.ParseUtils;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException, ParameterIsNotJsonStringException
    {
        //add while loop ?

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Wikipedia Revision Viewer. Please type the title of a Wikipedia article title. ");
        String title = input.nextLine();

        JsonRetriever retriever = new JsonRetriever(title);
        String jsonString = retriever.search();

        ParseUtils parser = new ParseUtils();

        Article article = parser.parseJsonToArticle(jsonString);

        CustomWikiDisplay wikiDisplay = new CustomWikiDisplay(article);
        System.out.println(wikiDisplay.toString());
    }
}
