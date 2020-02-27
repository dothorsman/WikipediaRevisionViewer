import domain.JsonRetriever;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonRetrieverTest
{
    JsonRetriever jsonRetriever;
    String jsonString;

    @Test
    void getJsonString() throws IOException
    {
        jsonRetriever = new JsonRetriever("Soup");
        jsonString = jsonRetriever.search();
        assertEquals("{\"continue\":{\"rvcontinue\":\"20200208164736|939771163\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"InternetArchiveBot\",\"timestamp\":\"2020-02-24T17:26:22Z\"},{\"user\":\"Yunshui\",\"timestamp\":\"2020-02-09T12:48:23Z\"},{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:49:19Z\"},{\"user\":\"Otuo-Akyampong Boakye\",\"timestamp\":\"2020-02-08T16:48:49Z\"}]}}}}",
                jsonString);
    }

    @Test
    void getJsonStringwithEmptyTitle() throws IOException
    {
        jsonRetriever = new JsonRetriever("");
        jsonString = jsonRetriever.search();
        assertEquals("{\"batchcomplete\":\"\"}", jsonString);
    }

    @Test
    void getJsonStringwithFullUppercaseTitle() throws IOException
    {
        jsonRetriever = new JsonRetriever("SOUP");
        jsonString = jsonRetriever.search();
        assertEquals("{\"continue\":{\"rvcontinue\":\"20180222011307|826971040\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"SOUP\",\"to\":\"Soup (disambiguation)\"}],\"pages\":{\"1331425\":{\"pageid\":1331425,\"ns\":0,\"title\":\"Soup (disambiguation)\",\"revisions\":[{\"user\":\"Froid\",\"timestamp\":\"2019-04-14T15:56:11Z\"},{\"user\":\"Flooded with them hundreds\",\"timestamp\":\"2018-12-19T14:51:34Z\"},{\"user\":\"2600:1017:B428:FB2F:B440:1390:C3AD:A202\",\"anon\":\"\",\"timestamp\":\"2018-12-19T14:50:50Z\"},{\"user\":\"Intgr\",\"timestamp\":\"2018-02-22T09:41:21Z\"}]}}}}",
                jsonString);
    }

    @Test
    void getJsonStringwithFullLowercaseTitle() throws IOException
    {
        jsonRetriever = new JsonRetriever("tree");
        jsonString = jsonRetriever.search();
        assertEquals("{\"continue\":{\"rvcontinue\":\"20200109181308|934979391\",\"continue\":\"||\"},\"query\":{\"normalized\":[{\"from\":\"tree\",\"to\":\"Tree\"}],\"pages\":{\"18955875\":{\"pageid\":18955875,\"ns\":0,\"title\":\"Tree\",\"revisions\":[{\"user\":\"Chiswick Chap\",\"timestamp\":\"2020-02-22T08:16:13Z\"},{\"user\":\"Velella\",\"timestamp\":\"2020-02-22T01:25:22Z\"},{\"user\":\"EdMcCorduck\",\"timestamp\":\"2020-02-19T13:08:52Z\"},{\"user\":\"Rodw\",\"timestamp\":\"2020-01-10T11:57:38Z\"}]}}}}",
                jsonString);
    }

    @Test
    void getJsonStringwithLongWordTitle() throws IOException
    {
        jsonRetriever = new JsonRetriever("Pseudopseudohypoparathyroidism");
        jsonString = jsonRetriever.search();
        assertEquals("{\"continue\":{\"rvcontinue\":\"20190307210710|886685107\",\"continue\":\"||\"},\"query\":{\"pages\":{\"5882252\":{\"pageid\":5882252,\"ns\":0,\"title\":\"Pseudopseudohypoparathyroidism\",\"revisions\":[{\"user\":\"GreenC bot\",\"timestamp\":\"2019-11-23T15:04:14Z\"},{\"user\":\"InternetArchiveBot\",\"timestamp\":\"2019-10-23T14:09:04Z\"},{\"user\":\"TylerDurden8823\",\"timestamp\":\"2019-09-16T06:56:19Z\"},{\"user\":\"Bigboyisawesome\",\"timestamp\":\"2019-05-06T05:44:36Z\"}]}}}}",
                jsonString);
    }

    @Test
    void getJsonStringwithOneLetterTitle() throws IOException
    {
        jsonRetriever = new JsonRetriever("S");
        jsonString = jsonRetriever.search();
        assertEquals("{\"continue\":{\"rvcontinue\":\"20200111163718|935269113\",\"continue\":\"||\"},\"query\":{\"pages\":{\"27173\":{\"pageid\":27173,\"ns\":0,\"title\":\"S\",\"revisions\":[{\"user\":\"Deacon Vorbis\",\"timestamp\":\"2020-01-21T13:49:05Z\"},{\"user\":\"Lunder Boy\",\"timestamp\":\"2020-01-20T04:10:20Z\"},{\"user\":\"Alexandru81\",\"timestamp\":\"2020-01-16T00:28:00Z\"},{\"user\":\"Alexandru81\",\"timestamp\":\"2020-01-11T16:39:31Z\"}]}}}}",
                jsonString);
    }



}
