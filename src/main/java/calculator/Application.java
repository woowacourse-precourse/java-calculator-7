package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        String userInput = Console.readLine();
        Calculator calculator = new Calculator();
        try{
            if(calculator.checkInput(userInput)) {
                Integer calculateOutput = calculator.getSum(userInput);
                System.out.println(calculateOutput);
            }
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
