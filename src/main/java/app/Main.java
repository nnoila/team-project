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
                .addSpendingReportView()
                .addSpendingReportUseCase()
                .addCategorizerView() // <-- Added the transaction categorizer GUI
                .addCategorizerUseCase()
                .addSignupUseCase()
                .addSpendingLimitsUseCase()
                .addUploadStatementView()
                .addLoginUseCase()
                .addChangePasswordUseCase()
                .addUploadStatementUseCase()
                .build();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
