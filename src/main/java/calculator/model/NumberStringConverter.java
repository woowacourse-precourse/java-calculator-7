package calculator.model;

public interface NumberStringConverter {

    long[] convert(String[] numberStrings);

    boolean canConvertToBigInteger(String numberString);
}
