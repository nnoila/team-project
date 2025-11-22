package ai_insights;

public class TestGeminiClient {
    public static void main(String[] args) {
        GeminiClient g = new GeminiClient();
        System.out.println(g.generateInsight("Say hello"));
    }

}
