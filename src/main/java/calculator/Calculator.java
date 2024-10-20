package calculator;

import separator.CustomSeparator;
import separator.CustomSeparatorFormat;
import separator.DefaultSeparator;
import separator.Separator;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public BigInteger run(){
        String[] strings = separator.splitInputDataBySeparator();
        return getSum(strings);
    }

    private BigInteger getSum(String[] strings) {
        BigInteger result = BigInteger.valueOf(0);
        for (String number:strings) {
            number = isEmptyString(number);
            BigInteger bigInteger = convertStringToNumber(number);
            result = result.add(bigInteger);
        }
        return result;
    }

    private static String isEmptyString(String number) {
        if (number.equals(" ")||number.equals("")) number = "0";
        return number;
    }

    private BigInteger convertStringToNumber(String number) {
        try{
            return new BigInteger(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자 외에 숫자만 입력할 수 있습니다.");

        }catch (NullPointerException e){
            return new BigInteger("0");
        }
    }

}
