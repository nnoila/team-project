package view;

import interface_adapter.spending_limits.SpendingLimitsController;
import interface_adapter.spending_limits.SpendingLimitsViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.HashMap;

import static common.Constants.CATEGORIES;

public class SpendingLimitsView extends JPanel implements PropertyChangeListener {
    private final SpendingLimitsViewModel viewModel;
    private final HashMap<String, JFormattedTextField> userInputFields = new HashMap<>();
    private final String viewName = "spending limits";

    public SpendingLimitsView(SpendingLimitsViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        this.add(new JLabel("Set your spending limits for each category:"));
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(0);  // or 2 if you want exactly 2 decimals
        format.setGroupingUsed(false);
        for (String category: CATEGORIES) {
            this.add(new JLabel(category));
            this.add(new JFormattedTextField(format));
            this.userInputFields.put(category, new JFormattedTextField(format));
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }

}
