package calculator.model;

public class Calculator {

    private String result;

    public void calculate(String input) {
        if (input == "") {
            result = "0";
            return;
        }


    }

    public String getResult() {
        return result;
    }
}
