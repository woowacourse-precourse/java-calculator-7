package calculator;

import calculator.controller.Deform;
import calculator.controller.Input;
import calculator.controller.Validate;
import calculator.model.Calculate;
import calculator.model.Separator;
import calculator.view.Out;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Out.printInputRequestMessage();

        //사용자 입력을 받음
        Input input = new Input();
        String userInput = input.getUserInput();

        //사용자 입력값이 커스텀 구분자를 가지고 있는지 확인
        if (userInput.startsWith("//") && userInput.length() > 5) {
            String customeSeparatorSetString = userInput.substring(0, 5);
            if (customeSeparatorSetString.endsWith("\\n")) {
                Separator.addSeparator(customeSeparatorSetString.charAt(2));
                userInput = userInput.substring(5);
            } else {
                separatorInit();
                throw (new IllegalArgumentException("잘못된 값을 입력하셨습니다."));
            }
        }

        //사용자 입력값이 유효한지 확인
        StringBuilder totalSeparator = new StringBuilder();
        Separator.getSeparators().forEach(separator -> {
            totalSeparator.append(separator);
        });

        final Pattern PATTERN = Pattern.compile("\\d+([" + totalSeparator + "]\\d+)*$");
        int validationResult = Validate.isValidForm(userInput, PATTERN);

        //사용자 입력값이 유효하면 계산기 실행
        if (validationResult == 0) {
            separatorInit();
            throw (new IllegalArgumentException("잘못된 값을 입력하셨습니다."));
        } else if (validationResult == 2) {
            Out.printResult(0);
        } else {
            StringBuilder onlyNumbersAndSeparators = new StringBuilder();
            if (userInput.startsWith("//") && userInput.length() > 5) {
                onlyNumbersAndSeparators.append(userInput.substring(5));
            } else {
                onlyNumbersAndSeparators.append(userInput);
            }

            Deform deform = new Deform();
            //사용자 입력값에서 숫자만 추출
            List<Integer> numbers = deform.extractNumbers(onlyNumbersAndSeparators.toString());

            //계산기 실행
            Calculate calculate = new Calculate();
            int result = calculate.sumOfNumbers(numbers);

            //최종 결과 출력
            Out.printResult(result);
            separatorInit();
        }

    }

    static void separatorInit() {
        Separator.getSeparators().clear();
        Separator.addSeparator(',');
        Separator.addSeparator(':');
    }
}
