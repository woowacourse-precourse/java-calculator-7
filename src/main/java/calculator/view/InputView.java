package calculator.view;
import calculator.calculate.Calculate;
import calculator.exception.Exception;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    Calculate calculate = new Calculate();
     public InputView(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Exception.IsEmptyInput(input);
        calculate.CalStringNum(input);
    }
}
