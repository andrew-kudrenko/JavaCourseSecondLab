package ru.bstu.akudrenko.arraytools;

public class CountingArray {
    private double[] values;

    public CountingArray(double[] initialValues) {
        setValues(initialValues);
    }

    public void setValues(double[] updates) {
        values = updates;
    }

    public ComparisonResult compare(double x) {
        ComparisonResult result = new ComparisonResult();

        for (int idx = 0; idx < values.length; idx++) {
            if (values[idx] > x) {
                result.greaterThan++;
            } else if (values[idx] < x) {
                result.lessThan++;
            } else {
                result.equals++;
            }
        }

        return result;
    }
}
