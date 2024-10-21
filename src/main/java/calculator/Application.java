package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Calculator calculator = new Calculator(input);
        if(input.length()>0){
            System.out.println(calculator.inputList());
        } else {
            System.out.println("결과 : 0");
        }
    }
}
