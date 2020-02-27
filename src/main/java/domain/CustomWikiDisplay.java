package domain;

public class CustomWikiDisplay
{
    private Article article;
    private String displayString = "";

    public CustomWikiDisplay(Article article)
    {
        this.article = article;
    }

    public String toString()
    {
        if(article.getTitle() == "")
        {
            return("Empty title was entered. Please try again.");
        }

        displayString += article.getChanges() + article.getRedirection();

        return(displayString);
    }
}
