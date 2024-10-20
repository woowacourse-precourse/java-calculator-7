package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing implements StringControl{
    private String[] numberTokens;
    private String delimiter = ",|:";
    private String intPatternString = "[\\d]";
    private String delimiterString =  "//(.)\\\\n(.*)";
    //private String delimiterString =  "//(.)\n(.*)";// \n Escape sequence


    Pattern intPattern = Pattern.compile(intPatternString);
    Pattern delimiterPattern = Pattern.compile(delimiterString);

    @Override
    public String[] StringParsing(String inputData) {

        return this.numberTokens = inputData.split(this.delimiter);

    }

    @Override
    public String[] CustomDelimiterCheck(String inputData){
        Matcher matcher = delimiterPattern.matcher(inputData);
        //
        if(matcher.find()) {
            this.delimiter = matcher.group(1); //Delimiter Char

            return StringParsing(matcher.group(2)); //Next String
        }
        else{
            return StringParsing(inputData);
        }

    }

    @Override
    public int ExceptionCheck(String[] splitData){
        Matcher matcher;
        int cmpData = 0;
        int sum = 0;

        for (int i = 0; i < splitData.length; i++) {
            System.out.println("in Exception");
            matcher = intPattern.matcher(splitData[i]);
            //if(!Character.isDigit(splitData[i].charAt(0))) {
            if(splitData[i].isEmpty()){
                cmpData = 0;
            }
            else if (!matcher.find()){
                throw new IllegalArgumentException("Type Error"); //입력값이 정수가 아니면
            }
            else if (Integer.parseInt(splitData[i]) <= 0){
                throw new IllegalArgumentException("Negative Error"); //입력값이 음수면
            }else{
                cmpData = Integer.parseInt(splitData[i]);
            }
            sum += cmpData;

        }
        return sum;

    }


}
