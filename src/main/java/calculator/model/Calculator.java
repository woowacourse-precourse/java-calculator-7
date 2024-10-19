package calculator.model;

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
        if(isCustomSeparator())
            customSplit();
        else
            normalSplit();
    }

    public boolean isCustomSeparator(){
        return str.startsWith("//");
    }

    public void customSplit(){
        String separator = String.valueOf(this.str.charAt(2));
        this.str = this.str.substring(5);
        this.strArr = this.str.split(separator);
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