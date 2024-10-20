package calculator;

import java.io.IOException;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final InputParser inputParser;
    private final Validator validator;

    public Application(InputParser inputParser, Validator validator) {
        this.inputParser = inputParser;
        this.validator = validator;
    }

    public int add(String input) {
        int sum = 0;
        /*1. 빈 문자열 입력 시 0 반환*/
        if (validator.isNull(input)) {
            return sum;
        }
        /*2. 구분자 기준으로 파싱*/
        String[] parse = inputParser.parse(input);
        /*3. 문자열에 음수 혹은 문자열이 포함되어있는지 유효성 검사*/
        validator.validation(parse);

        for (String num : parse) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }


    public static void main(String[] args){
        // TODO: 프로그램 구현
        InputParser inputParser = new InputParser();
        Validator validator = new Validator();

        Application application = new Application(inputParser, validator);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        int result = application.add(Console.readLine());
        System.out.println("결과 : " + result);

    }
}

