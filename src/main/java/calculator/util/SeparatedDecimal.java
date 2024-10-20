package calculator.util;

public class SeparatedDecimal {
    private long integerPart;
    private long decimalPart;

    public SeparatedDecimal(String str) {
        this.init(str);
    }

    private SeparatedDecimal(long integerPart, long decimalPart) {
        this.integerPart = integerPart;
        this.decimalPart = decimalPart;
    }

    private void init(String str) {
        try {
            String[] s = str.split("\\.");
            if (s.length == 2) {
                integerPart = Integer.parseInt(s[0]);
                decimalPart = Integer.parseInt(s[1]);
            } else if (s.length == 1 && !s[0].isEmpty()) {
                integerPart = Integer.parseInt(s[0]);
                decimalPart = 0L;
            } else {
                throw new NumberFormatException("String이 비었거나 소수의 형식이 아님");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나 형식을 위반함(.1 혹은 0. 등의 표현 불가)");
        }
    }

    public long getIntegerPart() {
        return integerPart;
    }

    public long getDecimalPart() {
        return decimalPart;
    }

    public SeparatedDecimal add(SeparatedDecimal other) {
        long integer, decimal;
        boolean carry;

        integer = this.integerPart + other.integerPart;

        if (this.decimalPart == 0 || other.decimalPart == 0) {
            return new SeparatedDecimal(integer, this.decimalPart + other.decimalPart);
        }

        String thisDecimal = Long.toString(this.decimalPart);
        String otherDecimal = Long.toString(other.decimalPart);

        StringBuilder sb = new StringBuilder();
        if (thisDecimal.length() > otherDecimal.length()) {
            int paddingResult = padRightWithZero(otherDecimal, thisDecimal.length());
            decimal = paddingResult + this.decimalPart;
            carry = Long.toString(decimal).length() != thisDecimal.length();
        } else if (thisDecimal.length() < otherDecimal.length()) {
            int paddingResult = padRightWithZero(thisDecimal, otherDecimal.length());
            decimal = paddingResult + other.decimalPart;
            carry = Long.toString(decimal).length() != otherDecimal.length();
        } else {
            decimal = this.decimalPart + other.decimalPart;
            carry = Long.toString(decimal).length() != thisDecimal.length();
        }

        if (carry) {
            integer++;
            String decimalString = Long.toString(decimal).substring(1);
            decimal = Integer.parseInt(decimalString);
        }

        return new SeparatedDecimal(integer, decimal);
    }

    private int padRightWithZero(String str, int length) {
        StringBuilder sb = new StringBuilder(str);
        sb.append("0".repeat(length-str.length()));
        return Integer.parseInt(sb.toString());
    }

    @Override
    public String toString() {
        if (decimalPart == 0) {
            return Long.toString(integerPart);
        }
        return integerPart + "." + decimalPart;
    }
}
