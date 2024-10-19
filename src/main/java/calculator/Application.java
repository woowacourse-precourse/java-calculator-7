package calculator;
import calculator.option.Calculator;
import calculator.option.Custom;
import calculator.option.Default;
import calculator.optionchecker.Optionchecker;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        Optionchecker op = new Optionchecker(input);

        op.optioncheck();

        if(op.getoption() == 1){
            Calculator def_cal = new Default(input);
            result = def_cal.getSum();
        }
        else if(op.getoption() == 2){
            Calculator custom_cal = new Custom(input);
            result = custom_cal.getSum();
        }

        System.out.println("결과 : " + result);
    }
}