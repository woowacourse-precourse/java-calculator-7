package calculator.model;


public class Calculator {
    private String formula;

    public Calculator(String formula){
        this.formula = formula;
    }

    public String getFormula(){
        return this.formula;
    }

    public String plus(String[] splitedNumbers){
        int sumOfNumbers = 0;
        for (int i = 0; i < splitedNumbers.length; i++) {
            int intNumber = Integer.parseInt(splitedNumbers[i]);
            sumOfNumbers = sumOfNumbers + intNumber;
        }
        return String.valueOf(sumOfNumbers);
    }  
}
