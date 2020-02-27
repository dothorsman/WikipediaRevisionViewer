import exceptions.ParameterIsNotJsonStringException;
import domain.Article;
import utils.ParseUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseUtilsTest
{
    ParseUtils parser;
    Article results;

    @Test
    void getTitleParse() throws ParameterIsNotJsonStringException
    {
        Article results;
        results = parser.parseJsonToArticle("{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}");

        assertEquals("Soup", results.getTitle());
    }

    @Test
    void getTimestampsParse() throws ParameterIsNotJsonStringException
    {
        results = parser.parseJsonToArticle("{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}");

        assertEquals("2019-11-28T06:58:48Z, 2019-11-28T04:58:37Z, 2019-11-28T04:50:07Z, 2019-11-04T17:21:04Z, ", results.getTimestamps());
    }


    @Test
    void getUsernamesParse() throws ParameterIsNotJsonStringException
    {
        results = parser.parseJsonToArticle("{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}");

        assertEquals("AnomieBOT, Esoteric bearcat, Esoteric bearcat, Rmhermen, ", results.getUsernames());
    }



    @Test
    void getTimestampsAndUsernamesParse() throws ParameterIsNotJsonStringException
    {
        results = parser.parseJsonToArticle("{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}");

        assertEquals("User 'AnomieBOT' edited the Wikipedia article at 2019-11-28T06:58:48Z\n" +
                        "User 'Esoteric bearcat' edited the Wikipedia article at 2019-11-28T04:58:37Z\n" +
                        "User 'Esoteric bearcat' edited the Wikipedia article at 2019-11-28T04:50:07Z\n" +
                        "User 'Rmhermen' edited the Wikipedia article at 2019-11-04T17:21:04Z\n",
                results.getChanges());
    }

    @Test
    void redirectionFalse() throws ParameterIsNotJsonStringException
    {
        results = parser.parseJsonToArticle("{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}");
        assertEquals("No redirection required", results.getRedirection());
    }


    @Test
    void testRedirectionTrue() throws ParameterIsNotJsonStringException
    {
        results = parser.parseJsonToArticle("{\"continue\":{\"rvcontinue\":\"20200223234256|942318369\",\"continue\":\"||\"},\"query\":{\"normalized\":[{\"from\":\"obama\",\"to\":\"Obama\"}],\"redirects\":[{\"from\":\"Obama\",\"to\":\"Barack Obama\"}],\"pages\":{\"534366\":{\"pageid\":534366,\"ns\":0,\"title\":\"Barack Obama\",\"revisions\":[{\"user\":\"Smurrayinchester\",\"timestamp\":\"2020-02-26T15:00:49Z\"},{\"user\":\"Kiwi128\",\"timestamp\":\"2020-02-24T09:27:13Z\"},{\"user\":\"Brett12212\",\"timestamp\":\"2020-02-24T09:26:29Z\"},{\"user\":\"SunCrow\",\"timestamp\":\"2020-02-23T23:44:03Z\"}]}}}}");
        assertEquals("'Obama' redirected to 'Barack Obama'", results.getRedirection());
    }
}
