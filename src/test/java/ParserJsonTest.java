import model.ParseJson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserJsonTest {

    @Test
    void test() {
        String sampleString = "{'name':'Huseyin','last':'Ergin','dob':1986}";
        var resultingArticle = ParseJson.parseJsonToArticleManual(sampleString);
        assertEquals("Soup", resultingArticle.getTitle());
        assertEquals("Revisions", resultingArticle.getRevisions());
    }
}
