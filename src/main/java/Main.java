import model.CustomWikiDisplay;
import model.JsonParser;
import model.JsonRetriever;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Wikipedia Revision Viewer. Please type the title of a Wikipedia article title");
        String title = input.nextLine();

        JsonRetriever retriever = new JsonRetriever(title);

        JsonParser parser = new JsonParser(retriever.search());
        //having a method call inside the creation of an object might be against the clean coding rules. Change it if you think so too
        //parser.parse();
        //return something (maybe JSON objects or Strings) for CustomWikiDisplay

        CustomWikiDisplay Customdisplay = new CustomWikiDisplay();
        //Customdisplay.display();
    }
}
