package calculator;

import utils.ExceptionMessages;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import camp.nextstep.edu.missionutils.*;


public class Application {
    private final static String OR = "|";
    private final static String DEFAULT_SEPARATOR = ",|:";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input;
        try {
            input = Console.readLine();
        }catch (NoSuchElementException ex){
            System.out.println("결과 : 0");
            return;
        }catch (Exception ex){
            throw new IllegalArgumentException();
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
                throw new IllegalArgumentException(ExceptionMessages.CUSTOM_SEPARATOR_CANNOT_BE_NUMBER);
            }
            if(separator.length() != 1) {
                throw new IllegalArgumentException(ExceptionMessages.CUSTOM_SEPARATOR_ONE_BYTE_REQUIRED);
            }
            // 입력문자열 앞부분의 커스텀 지정 부분 제거
            input = input.replaceFirst(customKeywordRegex, "");
            // 커스텀 구분자 추가 지정
            separator = DEFAULT_SEPARATOR + OR + separator;
        }

        if (!input.matches("[0-9" + separator + "]*")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CHARACTER_IN_INPUT);
        }

        String[] str = input.split(separator);

        IntStream numbers = Arrays.stream(str).mapToInt(
                s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ExceptionMessages.NON_NUMERIC_VALUE);
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
