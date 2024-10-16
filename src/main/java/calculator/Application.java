package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    // 1. 초기 세팅
    public static final List<String> DEFAULT_SEPARATORS = Arrays.asList(",", ":");
    public static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String OUTPUT_MESSAGE = "결과 : ";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    public static final Long MAXIMUM_NUMBER = Long.MAX_VALUE;

    public static void main(String[] args) {
        // 2. 문자열 입력 받기
        System.out.println(INPUT_MESSAGE);
        String inputString = Console.readLine();





    }
}
