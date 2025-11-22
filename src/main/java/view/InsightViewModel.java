package view;

public class InsightViewModel {
    public String summary;
    public String recommendations;
    public String date;

    public String getSummary() {
        return this.summary;
    }

    public String getRecommendations() {
        return this.recommendations;
    }

    public String getDate() {
        return this.date;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
