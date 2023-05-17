package ru.bstu.akudrenko;
import ru.bstu.akudrenko.tests.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    private final static Scanner scanner = new Scanner(System.in);
    private static final Map<String, Demo> demos = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>("convert", new ConverterDemo(logger)),
            new AbstractMap.SimpleImmutableEntry<>("prompt", new PromptDemo(logger)),
            new AbstractMap.SimpleImmutableEntry<>("counting-array", new CountingArrayDemo(logger)),
            new AbstractMap.SimpleImmutableEntry<>("sum-sign", new CheckSumSignDemo(logger))
    );

    public static void main(String[] args) {
        try {
            logger.info("Application successfully started");
            System.out.println("Press `Ctrl + D` to terminate the program.\n");

            while (true) {
                printDemoList();
                runDemoByKey(getDemoKey());
                System.out.println("\n");
            }
        } catch (Exception e) {
            logger.fatal(String.format("Uncaught application exception. Message: %s", e.getMessage()));
        }
    }

    private static void printDemoList() {
        System.out.println("To select a demo enter its key");
        demos.forEach((k, v) -> System.out.printf("\t~ \"%s\"\n", k));
    }

    private static String getDemoKey() {
        System.out.print("?> ");
        return scanner.next().trim();
    }

    private static void runDemoByKey(String key) {
        if (demos.containsKey(key)) {
            demos.get(key).run();
        } else {
            String message = String.format("Demo runner by key \"%s\" does not exist\n", key);
            logger.warn(message);
            System.out.print(message);
        }
    }
}