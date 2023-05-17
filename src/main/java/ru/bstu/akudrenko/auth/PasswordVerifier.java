package ru.bstu.akudrenko.auth;

public class PasswordVerifier {
    private int incorrectAttemptsLimit;
    private int attempts = 0;
    private String correctPassword = "";
    private boolean isVerified;

    public PasswordVerifier(int limit) {
        incorrectAttemptsLimit = limit;
    }

    public boolean verify(String password) {
        if (!isAttemptsLimitReached() && correctPassword.equals(password)) {
            isVerified = true;
        }

        attempts++;

        return isVerified;
    }

    public void reset() {
        attempts = 0;
        isVerified = false;
    }

    public boolean isAttemptsLimitReached() {
        return attempts >= incorrectAttemptsLimit;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

    public void setCorrectPassword(String password) {
        correctPassword = password;
    }

    public void setIncorrectAttemptsLimit(int limit) {
        incorrectAttemptsLimit = limit;
    }
}
