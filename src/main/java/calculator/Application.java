package calculator;

import camp.nextstep.edu.missionutils.Console;
import detector.CustomSeparatorDetector;
import separator.Separator;

public class Application {
    public static final AppConfig appConfig = new AppConfig();
    public static final Separator separator = appConfig.separator();
    public static final CustomSeparatorDetector customSeparatorDetector = appConfig.customSeparatorDetector();

    public static void main(String[] args) {
        //1. 입력 받기
        System.out.println(appConfig.getInputMessage());
        String input = Console.readLine();

        //2. 입력에 대해, 커스텀 구분자를 확인하여, 구분자에 추가해줌
        String customSeparator = customSeparatorDetector.detectSeparator(input);
        separator.addSeparator(customSeparator);

        //3. 기본 구분자와 커스텀 구분자를 통해, 숫자를 구분함

        //4. 숫자가 아닌 문자에 대한 예외 처리 진행

        //5. 각각의 숫자에 연산자를 통해, 결과값 얻기
//        int result = 0;
        //6. 결과 출력
//        System.out.println(appConfig.getOutputMessage() + result);
    }
}
