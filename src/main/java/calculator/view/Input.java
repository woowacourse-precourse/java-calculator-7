package calculator.view;

import calculator.entity.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.config.CalcConfig.INPUT_STRING;

public class Input {
    private final Validator validator;

    public Input() {
        this.validator = new Validator();
    }

    public String[] inputCalcNum() {
        System.out.println(INPUT_STRING);
        String inputNum = Console.readLine();

        if (inputNum.isBlank())
            return new String[]{"0"};
        String[] splitNum = splitInputNum(inputNum);

        validator.validateInputNum((splitNum));

        return splitNum;
    }

    private String[] splitInputNum(String input) {
        String divisionNum = ",|:";  // 기본 구분자는 콤마(,)와 콜론(:)
        String numsPart = input; // 입력값을 numsPart 변수에 저장

        // 입력값이 "//"로 시작하는지 확인
        if (input.startsWith("//")) {
            // 정규 표현식: "//" 뒤에 구분자 1개, 그 후에 \n과 그 뒤에 숫자들
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);

            // 정규식이 일치하면
            if (matcher.matches()) {
                // 첫 번째 그룹: 사용자 지정 구분자
                divisionNum = Pattern.quote(matcher.group(1));
                // 두 번째 그룹: 실제 숫자들
                numsPart = matcher.group(2);
            }
        }

        // 구분자로 숫자들 분리하여 반환
        return numsPart.split(divisionNum);
    }
}
