package app;

import javax.swing.JFrame;

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
                .addCategorizerView()
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
