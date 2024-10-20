package calculator;

import static calculator.Constant.INPUT_GUIDE;
import static calculator.Constant.OUTPUT_RESULT;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // 입력
        System.out.println(INPUT_GUIDE);
        String input = Console.readLine();

        // 입력 문자열을 올바른 형태로 교정한다.
        input = Validator.makeCorrectInput(input);

        // 문자열로부터 숫자 추출
        String[] strNumArray = Extractor.extractStrNumArray(input);

        // 결과 추출
        int result = Calculator.calculateSum(strNumArray);

        // 출력
        System.out.println(OUTPUT_RESULT + result);

        // scanner 닫기
        Console.close();
    }
}
