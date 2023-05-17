package ru.bstu.akudrenko.tests;

import org.apache.logging.log4j.Logger;
import ru.bstu.akudrenko.converter.Converter;
import ru.bstu.akudrenko.converter.LengthUnit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterDemo extends Demo {
    private final String prelude = ">";
    private final Scanner scanner = new Scanner(System.in);
    private final Converter converter = new Converter();

    public ConverterDemo(Logger logger) {
        super(logger);
    }

    @Override
    public void demo() {
        printPrelude();
        convertToAllAvailableUnits(getValue());
    }

    private void convertToAllAvailableUnits(double value) {
        var unitValues = LengthUnit.values();

        for (var fromUnit : unitValues) {
            for (var toUnit : unitValues) {
                if (fromUnit != toUnit) {
                    converter.setUnits(fromUnit, toUnit);
                    printConvertedValue(fromUnit, toUnit, value);
                }
            }
        }
    }

    private double getValue() {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException exception) {
            logIncorrectNumberInputWarn();
            return 0;
        }
    }

    private void printPrelude() {
        System.out.println("Please input a value to convert it. Incorrect input will be interpreted as zero (0.0).");
        System.out.print(prelude + " ");
    }

    private void printConvertedValue(LengthUnit from, LengthUnit to, double value) {
        System.out.println(String.format("%s | %f -> %s | %f", from, value, to, converter.convert(value)));
    }
}
