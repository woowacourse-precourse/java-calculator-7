package calculator;

import exception.ExceptionMessage;
import separator.Separator;

import java.math.BigInteger;


public class Calculator {

    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public BigInteger run() {
        String[] strings = separator.splitInputDataBySeparator();
        return getSum(strings);
    }

    public BigInteger getSum(String[] strings) {
        BigInteger result = BigInteger.valueOf(0);
        for (String number : strings) {
            number = isEmptyString(number);
            BigInteger bigInteger = convertStringToNumber(number);
            result = result.add(bigInteger);
        }
        return result;
    }

    public String isEmptyString(String number) {
        if (number.equals(" ") || number.equals("")) number = "0";
        return number;
    }

    public BigInteger convertStringToNumber(String number) {
        try {
            BigInteger bigInteger = new BigInteger(number);
            validateNegativeValue(bigInteger);
            return bigInteger;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_NUMBERS_ALLOWED_EXCEPT_SEPARATOR.getMessage());

        } catch (NullPointerException e) {
            return new BigInteger("0");
        }
    }

    public boolean validateNegativeValue(BigInteger bigInteger) {
        if(bigInteger.compareTo(BigInteger.ZERO)<=-1){
            throw new IllegalArgumentException(ExceptionMessage.ONLY_POSITIVE_NUMBERS.getMessage());
        }
        return false;
    }


}
