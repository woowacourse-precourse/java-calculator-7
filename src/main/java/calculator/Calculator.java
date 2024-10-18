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

    private final Separator defaultSeparator;

    public Calculator(List<String> separatorData,String inputData) {
        this.defaultSeparator = new DefaultSeparator(inputData,separatorData);
    }

    public BigInteger run(){
        Separator separator = generateSeparators(defaultSeparator.getInputData());
        String[] strings = separator.splitInputDataBySeparator();
        return getSum(strings);
    }

    private BigInteger getSum(String[] strings) {
        BigInteger result = BigInteger.valueOf(0);
        for (String number:strings) {
            number = isEmptyString(number);
            BigInteger bigInteger = convertStringToNumber(number);
            result = bigInteger.add(bigInteger);
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

    public Separator generateSeparators(String inputData){
        if(validateStartChar(inputData)){
            return defaultSeparator;
        }else {
            //TODO customSeparatorFormat을 여기서 넣어주는게 맞나..?
            CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
            validateCustomSeparatorFormat(inputData,customSeparatorFormat.getPattern());
            return new CustomSeparator(inputData,customSeparatorFormat);
        }
    }

    public Boolean validateStartChar(String inputData) {
        if (inputData.equals(" ")) return true;
        try {
            Integer.parseInt(inputData.substring(0,1));
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean validateCustomSeparatorFormat(String inputData,Pattern customSeparatorFormat){
        Matcher matcher = customSeparatorFormat.matcher(inputData);
        if(!matcher.find()){
            throw new IllegalArgumentException("커스텀구분자 생성형식을 확인해주세요.");
        }else {
            return true;
        }

    }

}
