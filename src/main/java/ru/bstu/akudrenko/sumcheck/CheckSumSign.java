package ru.bstu.akudrenko.sumcheck;

public class CheckSumSign {
    private int[] values;

    public CheckSumSign() {
        setValues(new int[] {});
    }

    public CheckSumSign(int[] initialValues) {
        setValues(initialValues);
    }

    public void setValues(int[] updates) {
        values = updates;
    }

    public boolean hasPositiveSum() {
        for (int start = 0; start < values.length; start++) {
            for (int current = start + 1; current < values.length; current++) {
                if (values[start] + values[current] > 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
