package use_case.ai_insights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.net.http.HttpClient.*;

class InsightClientTest {

    @Test
    void generateInsightThrowsIfNoApiKey() {
        // temporarily remove env var for test safety
        System.clearProperty("GEMINI_API_KEY");

        InsightClient client = new InsightClient();

        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                () -> client.generateInsight("test")
        );

        assertEquals("Missing GEMINI_API_KEY environment variable.", ex.getMessage());
    }
    @Test
    void generateInsightThrowsWhenKeyMissing() {
        // ensure environment variable isn't set
        System.clearProperty("GEMINI_API_KEY");

        InsightClient client = new InsightClient();

        assertThrows(IllegalStateException.class, () -> client.generateInsight("Hello"));
    }

    @Test
    void throwsExceptionWhenApiKeyMissing() {
        InsightClient client = new InsightClient();

        // simulate missing API key
        assertThrows(IllegalStateException.class, () -> client.generateInsight("test"));
    }
}
