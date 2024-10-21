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
        }catch (NoSuchElementException ex){ // 빈문자열의 경우 NoSuchElementException 발생 => catch 하여 결과 출력
            System.out.println("결과 : 0");
            return;
        }catch (Exception ex){
            throw new IllegalArgumentException();
        }

        // 커스텀 구분자를 감싸는 정규식
        String customKeywordRegex = "^//(.*)\\\\n";
        String separator = determineSeparator(customKeywordRegex, input);

        // 입력문자열 앞부분의 커스텀 지정 부분 제거
        input = input.replaceFirst(customKeywordRegex, "");

        // 숫자와 구분자 외의 숫자가 존재하는 경우 예외
        if (!input.matches("[0-9" + separator + "]*")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CHARACTER_IN_INPUT);
        }

        String[] str = input.split(separator);

        IntStream numbers = Arrays.stream(str).mapToInt(Application::parseStringToInt);

        System.out.println("결과 : "+ numbers.sum());
    }

    /**
     * 문자열을 정수로 변환한다.
     * @param s 정수로 변환할 문자열
     * @return 변환된 정수 값
     * @throws IllegalArgumentException 문자열이 숫자가 아닐 경우 예외
     */
    private static int parseStringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.NON_NUMERIC_VALUE);
        }
    }

    /**
     * 커스텀 구분자를 추출하고 반환한다.
     * 주어진 정규식(customKeywordRegex)을 사용하여 입력 문자열(input)에서 커스텀 구분자를 찾는다.
     * 만약 커스텀 구분자가 존재하면 기본 구분자(DEFAULT_SEPARATOR)에 추가하여 반환한다.
     * @param customKeywordRegex 커스텀 구분자를 찾기 위한 정규 표현식.
     * @param input 사용자 입력 문자열
     * @return 기본 구분자와 커스텀 구분자가 포함된 문자열
     * @throws IllegalArgumentException 커스텀 구분자가 숫자이거나 1바이트 문자가 아닐 경우 예외
     */
    private static String determineSeparator(String customKeywordRegex, String input) {
        String separator = DEFAULT_SEPARATOR;
        Matcher customKeywordMatcher = getMatcher(customKeywordRegex, input);

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

            // 커스텀 구분자 추가 지정
            separator = DEFAULT_SEPARATOR + OR + separator;
        }
        return separator;
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