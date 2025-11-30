package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        JFrame application = appBuilder
                .addLoginView()
                .addSignupView()
                .addLoggedInView()
                .addSpendingLimitsView()
                .addCategorizerView() // <-- Added the transaction categorizer GUI
                .addCategorizerUseCase()
                .addUploadStatementView()
                .addSpendingReportView()
                .addSignupUseCase()
                .addSpendingLimitsUseCase()
                .addSpendingReportUseCase()
                .addLoginUseCase()
                .addChangePasswordUseCase()
                .addUploadStatementUseCase()
                .build();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
