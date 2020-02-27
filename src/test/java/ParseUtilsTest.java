import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import exceptions.ParameterIsNotJsonStringException;
import model.Article;
import utils.ParseUtils;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseUtilsTest
{
    ParseUtils parser = new ParseUtils();

    @Test
    void testTitleParse() throws ParameterIsNotJsonStringException
    {
        Article results;
        results = parser.parseJsonToArticle("{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}");

        assertEquals("Soup", results.getTitle());
    }

    //testTimestampParse

    //testUsernameParse

    //testRedirectionFalse: use soup article (need to edit the if statement in ParseUtils) (maybe edit redirectionUsed in Article)

    //testRedirectionTrue: use obama/barack article (need to edit the if statement in ParseUtils) (redirectionUsed in Article)


}
