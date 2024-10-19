package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.ErrorMessages.ERROR_NUMBER_TYPE;

public class Calculator {
    private String str;
    private String[] strArr;
    private int answer;

    public Calculator(String str){
        this.str = str;
        this.answer = 0;
    }

    public int getAnswer(){
        return this.answer;
    }

    public boolean isNullOrEmpty(){
        return this.str == null || this.str.isEmpty();
    }

    public void split(){
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(this.str);
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
        if(isNullOrEmpty())
            return 0;

        for(String a : this.strArr){
            int number = Integer.parseInt(a);
            if(number < 0) throw new IllegalArgumentException(ERROR_NUMBER_TYPE);
            this.answer += number;
        }
        return answer;
    }

    public void validateNumbers(){

    }
}