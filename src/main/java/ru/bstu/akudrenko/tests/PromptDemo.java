package ru.bstu.akudrenko.tests;

import org.apache.logging.log4j.Logger;
import ru.bstu.akudrenko.auth.Prompt;

public class PromptDemo extends Demo {
    private final Prompt prompt = new Prompt();
    private final String correctPassword = "prompt1+2";

    public PromptDemo(Logger logger) {
        super(logger);
    }

    @Override
    public void demo() {
        var verifier = prompt.getVerifier();

        verifier.setCorrectPassword(correctPassword);
        prompt.promptWithWhileLoop();

        System.out.println("\n\nAnd then `for` loop!\n\n");
        prompt.setPrelude("With `For` Loop Password::>");
        verifier.setIncorrectAttemptsLimit(2);
        prompt.promptWithForLoop();
    }
}
