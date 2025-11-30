package use_case.change_password;

import entity.User;
import entity.UserFactory;

/**
 * The Change Password Interactor.
 */
public class ChangePasswordInteractor implements ChangePasswordInputBoundary {
    private final ChangePasswordUserDataAccessInterface userDataAccessObject;
    private final ChangePasswordOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public ChangePasswordInteractor(ChangePasswordUserDataAccessInterface changePasswordDataAccessInterface,
                                    ChangePasswordOutputBoundary changePasswordOutputBoundary,
                                    UserFactory userFactory) {
        this.userDataAccessObject = changePasswordDataAccessInterface;
        this.userPresenter = changePasswordOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(ChangePasswordInputData changePasswordInputData) {
        if ("".equals(changePasswordInputData.getPassword())) {
            userPresenter.prepareFailView("New password cannot be empty");
        }
        else {
            // Retrieve the existing user to get their userId
            final User existingUser = userDataAccessObject.get(changePasswordInputData.getUsername());

            // Hash the new password
            final String newPasswordHash = UserFactory.hashPasswordSHA256(changePasswordInputData.getPassword());

            // Create a new User object with the same userId but new password hash
            final User updatedUser = userFactory.loadUser(
                    existingUser.getUserId(),
                    existingUser.getUsername(),
                    newPasswordHash
            );

            // Save the updated user
            userDataAccessObject.changePassword(updatedUser);

            // Prepare success response
            final ChangePasswordOutputData changePasswordOutputData = new ChangePasswordOutputData(updatedUser.getUsername());
            userPresenter.prepareSuccessView(changePasswordOutputData);
        }
    }
}
