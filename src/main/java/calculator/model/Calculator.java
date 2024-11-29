package calculator.model;

import static calculator.util.Constants.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.ErrorMessages.ERROR_INPUT;
import static calculator.util.ErrorMessages.ERROR_NUMBER_TYPE;

public class Calculator {
    private final String str;
    private String[] strArr;
    private int answer;

    public Calculator(String str){
        this.str = str;
        this.answer = 0;
    }

    public int sum(){
        if(isNullOrEmpty())
            return 0;
        split();
        return sumNumbers();
    }

    public boolean isNullOrEmpty(){
        return this.str == null || this.str.isEmpty();
    }

    public void split(){
        Matcher matcher = Pattern.compile(PATTERN_TEXT).matcher(this.str);
        if(matcher.find())
            customSplit(matcher);
        else
            normalSplit();
    }

    public void customSplit(Matcher matcher){
        String customSeparator = matcher.group(1);
        String customText = matcher.group(2);
        this.strArr = customText.split(customSeparator);
    }

    public void normalSplit(){
        this.strArr = this.str.split("[,:]");
    }

    public int sumNumbers(){
        for(String a : this.strArr){
            int number = validatePositive(a);
            this.answer += number;
        }
        return answer;
    }

    public int validatePositive(String value){
        try{
        int number = Integer.parseInt(value);
        if(number < 0)
            throw new IllegalArgumentException(ERROR_NUMBER_TYPE);
        return number;}
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_INPUT);
        }
    }
}