package calculator.model;

public class Calculator {
    private String str;
    private int answer;

    public Calculator(String str){
        this.str = str;
        this.answer = 0;
    }

    public boolean validateNull(){
        return this.str.isEmpty();
    }

    public int getAnswer(){
        return this.answer;
    }
}
