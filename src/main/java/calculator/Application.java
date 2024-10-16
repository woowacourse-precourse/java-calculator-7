package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private static final CalculatorService calculatorService = new CalculatorService();

    public static void main(String[] args) {
        String inputString = readLine();

        extractDelimiter(inputString).forEach(
                calculatorService::addSeparator);
    }

    private static List<String> extractDelimiter(String inputString) {
        // "//"로 시작하지 않거나 "\n"가 존재하지 않으면 커스텀 구분자가 없는거라 판단해 빈 배열을 보냄
        if (!inputString.startsWith(CUSTOM_DELIMITER_PREFIX) || !inputString.contains(CUSTOM_DELIMITER_SUFFIX)) {
            return new ArrayList<>();
        }

        //구분자 목록들을 한 문자열로 가져옴("//" 이후 부터 "\n" 전까지)
        String separatorsString = inputString.substring(
                CUSTOM_DELIMITER_PREFIX.length(),
                inputString.indexOf(CUSTOM_DELIMITER_SUFFIX));

        return Arrays.stream(
                separatorsString.split(""))
                .toList();
    }
}
