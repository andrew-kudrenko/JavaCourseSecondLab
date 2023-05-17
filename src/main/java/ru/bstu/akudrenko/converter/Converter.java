package ru.bstu.akudrenko.converter;

public class Converter {
    private LengthUnit from = LengthUnit.Metre;
    private LengthUnit to = LengthUnit.Metre;

    public double convert(double value) {
        return fromMeters(to, toMeters(from, value));
    }

    public void setUnits(LengthUnit from, LengthUnit to) {
        setFrom(from);
        setTo(to);
    }

    public void setFrom(LengthUnit unit) {
        from = unit;
    }

    public void setTo(LengthUnit unit) {
        to = unit;
    }

    private double fromMeters(LengthUnit unit, double value) {
        return value / getToMetreRateByUnit(unit);
    }

    private double toMeters(LengthUnit unit, double value) {
        return value * getToMetreRateByUnit(unit);
    }

    private double getToMetreRateByUnit(LengthUnit unit) {
        return switch (unit) {
            case Millimeter -> 0.001;
            case Centimetre -> 0.01;
            case Decimeter -> 0.1;
            case Metre -> 1.0;
            case Kilometer -> 1000.0;
            case Inch -> 0.0254;
            default -> throw new RuntimeException("Unknown unit: " + unit);
        };
    }
}
