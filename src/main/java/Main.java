import model.CustomWikiDisplay;
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



        //CustomWikiDisplay Customdisplay = new CustomWikiDisplay();
        //Customdisplay.display();
    }
}
