package calculator;

import Delimiter.BasicDelimiter;
import Delimiter.CustomDelimiter;
import Delimiter.DelimiterHandler;
import camp.nextstep.edu.missionutils.Console;
import util.Adder;
import util.Validator;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        Validator.isEmpty(input);
        String delimiterType = DelimiterHandler.detectDelimiterType(input);
        if (delimiterType.equals("Basic")) {
            int result = Adder.getSum(BasicDelimiter.getNumber(input));
            System.out.printf("결과 : %d", result);
            return;  // Basic 구분자가 처리되면 일찍 종료
        }

        // Custom 구분자 처리
        int result = Adder.getSum(CustomDelimiter.getNumber(input));
        System.out.printf("결과 : %d", result);
    }
}
