package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * StringCalculator 클래스는 Calculator 클래스를 상속받아 문자열 기반의 계산 기능을 제공합니다. 이 클래스는 싱글톤 패턴을 사용하여 단 하나의 인스턴스만 생성할 수 있습니다.
 *
 * <p>
 * 사용자는 문자열 형태의 입력을 통해 다양한 구분자로 숫자를 계산할 수 있으며, 커스텀 구분자도 지원합니다.
 * </p>
 *
 * @author JBumLee
 * @version 2024/10/21
 */
public class StringCalculator extends Calculator {
    private static StringCalculator instance;
    private static List<String> separators = new ArrayList<>(List.of(",", ":"));

    /**
     * StringCalculator의 생성자.(싱글톤 적용을 위한 private)
     */
    private StringCalculator() {
    }

    /**
     * 주어진 문자열에서 새로운 구분자를 찾아 새로운 구분자를 추가합니다.
     *
     * @param line 입력 문자열
     * @return 구분자 이후의 문자열
     */
    private String parseSeparator(String line) {
        // 커스텀 구분자 가져오기
        String customSeparator = getCustomSeparator(line);
        if (customSeparator != null) {
            separators.add(customSeparator);
            line = line.substring(line.indexOf("\\n") + 2); // 커스텀 구분자 이후의 부분을 반환
        }
        return line;
    }

    /**
     * 정의되지 않은 값이 입력되었는지 확인하고 예외를 발생시킵니다.
     *
     * @param value 입력 값
     * @throws IllegalArgumentException 구분자가 아닌 값이 포함되어 있을 때
     */
    private void validateInput(String value) {
        validateInvalidCharacters(value);
        validateConsecutiveSeparators(value);
        validateTrailingSeparator(value);
    }

    /**
     * 구분자가 아닌 값이 포함되어 있을 때 예외를 발생시킵니다.
     *
     * @param value 입력 값
     * @throws IllegalArgumentException 구분자가 아닌 값이 포함되어 있을 때
     */
    private void validateInvalidCharacters(String value) {
        for (char ch : value.toCharArray()) {
            boolean isValid = false;
            for (String separator : separators) {
                if (separator.indexOf(ch) != -1) {
                    isValid = true;
                    break;
                }
            }
            // 구분자, 숫자가 아닌 값 예외 처리
            if (!isValid && !Character.isDigit(ch)) {
                throw new IllegalArgumentException("구분자가 아닌 값이 포함되어 있습니다: " + ch);
            }
        }
    }

    /**
     * 구분자가 연속으로 두 번 이상 나올 때 예외를 발생시킵니다.
     *
     * @param value 입력 값
     * @throws IllegalArgumentException 구분자가 연속으로 두 번 이상 나올 때
     */
    private void validateConsecutiveSeparators(String value) {
        for (int i = 0; i < value.length() - 1; i++) {
            String currentChar = String.valueOf(value.charAt(i));
            String nextChar = String.valueOf(value.charAt(i + 1));

            // 현재와 다음 문자가 모두 구분자일 경우 예외 발생
            if (separators.contains(currentChar) && separators.contains(nextChar)) {
                throw new IllegalArgumentException("구분자가 연속으로 두 번 이상 나왔습니다.");
            }
        }
    }

    /**
     * 마지막 글자가 구분자일 때 예외를 발생시킵니다.
     *
     * @param value 입력 값
     * @throws IllegalArgumentException 마지막 글자가 구분자일 때
     */
    private void validateTrailingSeparator(String value) {
        String lastChar = String.valueOf(value.charAt(value.length() - 1));
        for (String separator : separators) {
            if (separator.equals(lastChar)) {
                throw new IllegalArgumentException("마지막 글자가 구분자입니다: " + lastChar);
            }
        }
    }

    /**
     * 입력 문자열에서 커스텀 구분자를 찾아 반환합니다.
     *
     * @param line 입력 문자열
     * @return 커스텀 구분자 또는 null
     */
    private String getCustomSeparator(String line) {
        if (line.startsWith("//")) {
            int lastIndex = line.indexOf("\\n");
            if (lastIndex != -1) {
                return line.substring(2, lastIndex);
            }
        }
        return null;
    }

    /**
     * 주어진 문자열을 기준으로 숫자의 합을 계산합니다.
     *
     * @param line 입력 문자열
     * @return 주어진 숫자의 합
     */
    public long sum(String line) {
        line = parseSeparator(line);
        validateInput(line);
        int[] numbers = parseNumbers(line);
        return super.sum(numbers);
    }

    /**
     * 주어진 문자열을 구분자에 따라 분리합니다.
     *
     * @param line 입력 문자열
     * @return 분리된 숫자 배열
     */
    private int[] parseNumbers(String line) {
        String regex = String.join("|", separators);
        return Arrays.stream(line.split(regex))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * 싱글톤 인스턴스를 생성하여 반환합니다.
     *
     * @return StringCalculator 인스턴스
     */
    public static StringCalculator getInstance() {
        if (instance == null) {
            instance = new StringCalculator();
        }
        return instance;
    }
}