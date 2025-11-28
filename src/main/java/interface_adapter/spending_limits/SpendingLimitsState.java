package interface_adapter.spending_limits;

import java.util.HashMap;
import java.util.Map;

public class SpendingLimitsState {
    private Map<String, Double> limits;
    private String message;

    public SpendingLimitsState() {
        this.limits = new HashMap<>();
        this.message = "";
    }

    public Map<String, Double> getLimits() {
        return limits;
    }

    public void setLimits(Map<String, Double> limits) {
        this.limits = limits;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
