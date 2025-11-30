package interface_adapter.categorizer;

import use_case.transaction_categorizer.CategorizerOutputBoundary;

public class CategorizerPresenter implements CategorizerOutputBoundary {
    private CategorizerViewModel categorizerViewModel;

    public CategorizerPresenter(CategorizerViewModel categorizerViewModel) {
        this.categorizerViewModel = categorizerViewModel;
    }

    @Override
    public void displayCategorizationResults() {
        System.out.println("IN DISPLAY CATEGORIZATION RESULTS");
        this.categorizerViewModel.setState(categorizerViewModel.getState());
        this.categorizerViewModel.firePropertyChange("state");
    }

}
