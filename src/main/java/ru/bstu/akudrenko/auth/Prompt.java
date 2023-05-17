package ru.bstu.akudrenko.auth;

import java.util.Scanner;

public class Prompt {
    private final PasswordVerifier verifier = new PasswordVerifier(3);
    private final Scanner scanner = new Scanner(System.in);
    private String prelude = "Password::>";

    public void promptWithWhileLoop() {
        verifier.reset();

        while (!verifier.getIsVerified() && !verifier.isAttemptsLimitReached()) {
            printPrelude();

            if (!verifier.verify(getPassword())) {
                printIncorrectPasswordMessage();
            } else {
                break;
            }
        }

        if (verifier.getIsVerified()) {
            printSuccessMessage();
        } else {
            printLimitIsReachedMessage();
        }
    }

    public void promptWithForLoop() {
        verifier.reset();

        for (;!verifier.getIsVerified() && !verifier.isAttemptsLimitReached();) {
            printPrelude();

            String password = getPassword();
            boolean isVerified = verifier.verify(password);

            if (!isVerified) {
                printIncorrectPasswordMessage();
            } else {
                break;
            }
        }

        if (verifier.getIsVerified()) {
            printSuccessMessage();
        } else {
            printLimitIsReachedMessage();
        }
    }

    public PasswordVerifier getVerifier() {
        return verifier;
    }

    public String getPassword() {
        return scanner.nextLine();
    }

    public void printPrelude() {
        System.out.print(prelude + " ");
    }

    public void setPrelude(String prelude) {
        this.prelude = prelude;
    }

    private void printSuccessMessage() {
        System.out.println("OK");
    }

    private void printLimitIsReachedMessage() {
        System.out.println("Limit of attempts is reached. Exiting...");
    }

    private void printIncorrectPasswordMessage() {
        System.out.println("Incorrect password. Please try again");
    }
}
