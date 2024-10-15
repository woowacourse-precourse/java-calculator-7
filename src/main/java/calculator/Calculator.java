package calculator;

public class Calculator {

    private Regex regex;

    public void calculate(){
        regex = new Regex();
        regex.inputExpression();
        regex.setNumbers();
    }


}
