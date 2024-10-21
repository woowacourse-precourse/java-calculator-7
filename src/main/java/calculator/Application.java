package calculator;
public class Application {
    public static void main(String[] args) {
        try{
            Calculator calculator = new Calculator();
            calculator.setUserInputByCustomConsole();
            if(calculator.checkInputByRule()) {
                Integer calculateOutput = calculator.getSumByCalculate();
                System.out.println(calculateOutput);
            }
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
