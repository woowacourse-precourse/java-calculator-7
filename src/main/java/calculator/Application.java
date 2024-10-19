package calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Application {
    private final static String OR = "|";
    private final static String DEFAULT_SEPARATOR = ",|:";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = "";
        if (scanner.hasNextLine()) { // 입력 문자열이 null이 아니라면, 버퍼로부터 입력값을 가져온다.
            input = scanner.nextLine();
        }else{ // 빈 문자열의 경우 0 출력 후 바로 종료한다.
            System.out.println("결과 : 0");
            return;
        }

        // 커스텀 구분자를 감싸는 정규식
        String customKeywordRegex = "^//(.*)\\\\n";
        Matcher customKeywordMatcher = getMatcher(customKeywordRegex, input);

        String separator = DEFAULT_SEPARATOR;
        if (customKeywordMatcher.find()) {
            separator = customKeywordMatcher.group(1);
            // 숫자인지 판별
            Matcher numberMatcher = getMatcher("[0-9]", separator);
            if(numberMatcher.find()) {
                throw new IllegalArgumentException("숫자는 커스텀 구분자로 사용할 수 없습니다.");
            }
            if(separator.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 1개의 1Byte 문자만 지정할 수 있습니다. (추출한 구분자:"+separator+")");
            }
            // 입력문자열 앞부분의 커스텀 지정 부분 제거
            input = input.replaceFirst(customKeywordRegex, "");
            // 커스텀 구분자 추가 지정
            separator = DEFAULT_SEPARATOR + OR + separator;
        }

        if (!input.matches("[0-9" + separator + "]*")) {
            throw new IllegalArgumentException("문자열에 지정된 구분자 이외의 문자가 포함되어 있습니다.");
        }

        String[] str = input.split(separator);

        IntStream numbers = Arrays.stream(str).mapToInt(
                s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("숫자가 아닌 값이 존재합니다.");
                    }
                });

        System.out.println("결과 : "+ numbers.sum());

    }

    /**
     * 주어진 정규 표현식과 입력 문자열에 대해 Matcher 객체를 반환한다.<br/>
     * 제공된 정규 표현식을 Pattern으로 컴파일하고, 그 Pattern을 기반으로 입력 문자열에 대한 Matcher를 생성한다.
     * @param regex 컴파일할 정규 표현식
     * @param input 정규 표현식에 대해 매칭할 입력 문자열
     * @return 입력 문자열에 대한 매칭 작업을 수행할 수 있는 Matcher 객체
     */
    private static Matcher getMatcher(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
}
