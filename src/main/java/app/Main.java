package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        JFrame application = appBuilder
                .addLoginView()
                .addSignupView()
                .addLoggedInView()
                .addLogoutUseCase()
                .addSpendingLimitsView()
                .addSpendingReportView()
                .addSpendingReportUseCase()
                .addCategorizerView() // <-- Added the transaction categorizer GUI
                .addCategorizerUseCase()
                .addSignupUseCase()
                .addUploadStatementView()
                .addUploadStatementUseCase()
                .addSpendingLimitsUseCase()
                .addLoginUseCase()
                .addChangePasswordUseCase()
                .build();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}
