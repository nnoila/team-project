package interface_adapter.spending_limits;

import interface_adapter.ViewModel;

public class SpendingLimitsViewModel extends ViewModel<SpendingLimitsState> {

    public SpendingLimitsViewModel() {
        super("spending limits");
        setState(new SpendingLimitsState());
    }


}
