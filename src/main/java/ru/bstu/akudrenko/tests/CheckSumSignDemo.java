package ru.bstu.akudrenko.tests;

import org.apache.logging.log4j.Logger;
import ru.bstu.akudrenko.sumcheck.CheckSumSign;

import java.util.Scanner;

public class CheckSumSignDemo extends Demo {
    private final Scanner scanner = new Scanner(System.in);
    private final CheckSumSign checkSumSign = new CheckSumSign();

    public CheckSumSignDemo(Logger logger) {
        super(logger);
    }

    @Override
    public void demo() {
        System.out.println("Is numbers sequence sum positive?\n");

        int count = getNumbersCount();

        if (count > 0) {
            checkSumSign.setValues(getNumbers(count));
            String answer = checkSumSign.hasPositiveSum() ? "Yes" : "No";

            System.out.printf("Answer is \"%s\"\n", answer);
        } else {
            String message = "Sequence numbers count should be greater than zero.";
            logger.warn(message);
            System.out.println(message);
        }
    }

    private int getNumbersCount() {
        System.out.println("Please enter numbers count");
        System.out.print("> ");

        return scanner.nextInt();
    }

    private int[] getNumbers(int count) {
        int numbers[] = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.printf("\t ~ %d > ", i + 1);

            try {
                numbers[i] = scanner.nextInt();
            } catch (Exception exception) {
                logIncorrectNumberInputWarn();
                numbers[i] = 0;
            }
        }

        return numbers;
    }
}
