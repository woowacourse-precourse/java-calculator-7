package calculator;

import binaryOperator.BinaryOperator;
import camp.nextstep.edu.missionutils.Console;
import detector.CustomSeparatorDetector;
import separator.Separator;
import separator.SeparatorParser;
import java.util.List;

public class Application {
    private static final AppConfig appConfig = new AppConfig();

    private static final Separator separator = appConfig.separator();
    private static final CustomSeparatorDetector customSeparatorDetector = appConfig.customSeparatorDetector();
    public static final SeparatorParser separatorParser = appConfig.separatorParser();
    public static final BinaryOperator binaryOperator = appConfig.operator();

    public static void main(String[] args) {
        //1. 입력 받기
        System.out.println(appConfig.getInputMessage());
        String input = Console.readLine();

        //2. 입력에 대해, 커스텀 구분자를 확인하여, 구분자에 추가해줌
        String customSeparator = customSeparatorDetector.detectSeparator(input);
        input = customSeparatorDetector.removeCustomFormat(input, customSeparator);
        separator.addSeparator(customSeparator);

        //3. 기본 구분자와 커스텀 구분자를 통해, 숫자를 구분
        separatorParser.setSeparator(separator);
        List<String> splitInput = separatorParser.split(input);
        Integer numbers;

        try {
            //4. 구분한 원소가 숫자가 아닌 문자에 대한 예외 처리 진행
            //5. 각각의 숫자에 연산자를 통해, 결과값 얻기
            numbers = splitInput.stream().map(Integer::parseInt).reduce(0, binaryOperator::operate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        //6. 결과 출력
        System.out.println(appConfig.getOutputMessage() + numbers);
    }
}
