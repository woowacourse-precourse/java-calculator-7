package calculator;

import calculator.dto.InputDTO;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("please insert text");
        String input = Console.readLine();

        try {
            InputDTO inputDTO = new InputDTO(input);
            int result = Calculator.add(inputDTO);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) { // 모든 예외를 잡아주는 추가적인 catch 블록
            System.err.println("error: " + e.getMessage());
        }
    }
}
