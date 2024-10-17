package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {

    // 1. 초기 세팅
    public static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    public static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String OUTPUT_MESSAGE = "결과 : ";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    public static final Long MAXIMUM_NUMBER = Long.MAX_VALUE;

    public static void main(String[] args) {

        // 2. 문자열 입력 받기
        System.out.println(INPUT_MESSAGE);
        String inputString = Console.readLine();

        List<String> customDelimiters = new ArrayList<>();

        // 3. 커스텀 구분자 저장
        while (inputString.startsWith(CUSTOM_DELIMITER_PREFIX)) { //  "//"로 시작하는지 확인 -> 무조건 뒤에 "\n"이 있어야함
            int i = inputString.indexOf(CUSTOM_DELIMITER_SUFFIX); //    "\n"이 있는 위치를 찾고 그 사이를 분리
            if (i == -1)
                throw new IllegalArgumentException("입력이 잘못되었습니다");

            String subString = inputString.substring(CUSTOM_DELIMITER_PREFIX.length(), i);
            inputString = inputString.substring(i + CUSTOM_DELIMITER_SUFFIX.length(), inputString.length());    //첫 번째 커스텀 구분자 지정 부분 삭제
            String defaultDelimiterPattern = DEFAULT_DELIMITER.stream()
                    .map(Pattern::quote)
                    .collect(Collectors.joining("|"));

            String[] splitByDefaultDelimiter = subString.split(defaultDelimiterPattern);
            for (String customDelimiter : splitByDefaultDelimiter) {
                if (customDelimiter.length() > 1)
                    throw new IllegalArgumentException();

                if (customDelimiter.length() == 1) {
                    if (Character.isLetterOrDigit(customDelimiter.charAt(0)))
                        throw new IllegalArgumentException();

                    if (!customDelimiters.contains(customDelimiter) && customDelimiter.charAt(0) != ',' && customDelimiter.charAt(0) != ':')
                        customDelimiters.add(customDelimiter);
                }
            }

        }

    }
}
