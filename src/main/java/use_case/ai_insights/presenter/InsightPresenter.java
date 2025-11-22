package use_case.ai_insights.presenter;
import entity.Insight;
import view.InsightViewModel;

import java.util.List;

public class InsightPresenter {
    private final InsightViewModel viewModel;

    public InsightPresenter(InsightViewModel vm) {
        this.viewModel = vm;
    }

    public void present(Insight insight) {
        viewModel.setSummary(insight.getSummaryText());

        String formatted = "• " + String.join("\n• ", insight.getRecommendations());

        viewModel.setRecommendations(formatted);
        viewModel.setDate("Generated at:" + insight.getGeneratedAt());
    }

}
