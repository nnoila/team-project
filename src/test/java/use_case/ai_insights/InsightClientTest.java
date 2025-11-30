package use_case.ai_insights;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
