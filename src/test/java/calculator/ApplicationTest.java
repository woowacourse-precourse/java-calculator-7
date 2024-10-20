package calculator;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationFuzzTest {

    private static final char[] CHARACTERS_WITHOUT_NUMBERS = (
            "abcdefghijklmnopqrstuvwxyz" + // 소문자 알파벳
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + // 대문자 알파벳
                    " !@#$%^&*()-_=+[]{}|;:'\",.<>?/`~\\").toCharArray(); // 공백, 특수문자

    private static final char[] CHARACTERS_WITH_NUMBERS = (
            "abcdefghijklmnopqrstuvwxyz" + // 소문자 알파벳
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + // 대문자 알파벳
                    "0123456789" +                 // 숫자
                    " !@#$%^&*()-_=+[]{}|;:'\",.<>?/`~\\").toCharArray(); // 공백, 특수문자

    @RepeatedTest(100) // 이 테스트를 여러 번 반복하여 다양한 랜덤 입력을 시도
    void 랜덤_모든_문자_커스텀_구분자_테스트() {
        Random random = new Random();
        StringBuilder input = new StringBuilder();

        // 랜덤한 커스텀 구분자를 생성 (랜덤 문자 1글자)
        char customDelimiter = CHARACTERS_WITHOUT_NUMBERS[random.nextInt(CHARACTERS_WITHOUT_NUMBERS.length)];
        input.append("//").append(customDelimiter).append("\n");

        // 커스텀 구분자를 사용해 10개의 랜덤 숫자를 생성
        for (int i = 0; i < 10; i++) {
            input.append(random.nextInt(100)); // 0부터 99 사이의 랜덤 숫자
            if (i < 9) {
                input.append(customDelimiter);
            }
        }

        String randomInput = input.toString();
        System.out.println("랜덤 모든 문자 커스텀 구분자 입력: " + randomInput);

        // 랜덤 입력에 대해 프로그램이 예외 없이 실행되는지 확인
        assertDoesNotThrow(() -> {
            ParsingStrategy strategy = ParsingStrategyFactory.getStrategy(randomInput);
            int result = strategy.parse(randomInput);
            assertTrue(result >= 0); // 결과가 음수로 나오지 않는지 확인
        });
    }

    @RepeatedTest(100) // 랜덤한 여러 글자 커스텀 구분자를 테스트
    void 랜덤_모든_문자_여러_글자_커스텀_구분자_테스트() {
        Random random = new Random();
        StringBuilder input = new StringBuilder();
        StringBuilder customDelimiter = new StringBuilder();

        // 랜덤한 여러 글자 커스텀 구분자를 생성 (랜덤 문자 3~5글자)
        while (customDelimiter.length() < 3) {
            char possibleDelimiter = CHARACTERS_WITH_NUMBERS[random.nextInt(CHARACTERS_WITH_NUMBERS.length)];
            customDelimiter.append(possibleDelimiter);
            if (customDelimiter.toString().matches("^[0-9]+$")) {
                // 모두 숫자인 경우, 다시 생성
                customDelimiter.setLength(0);
            }
        }

        input.append("//").append(customDelimiter).append("\n");

        // 커스텀 구분자를 사용해 10개의 랜덤 숫자를 생성
        for (int i = 0; i < 10; i++) {
            input.append(random.nextInt(100)); // 0부터 99 사이의 랜덤 숫자
            if (i < 9) {
                input.append(customDelimiter);
            }
        }

        String randomInput = input.toString();
        System.out.println("랜덤 모든 문자 여러 글자 커스텀 구분자 입력: " + randomInput);

        // 랜덤 입력에 대해 프로그램이 예외 없이 실행되는지 확인
        assertDoesNotThrow(() -> {
            ParsingStrategy strategy = ParsingStrategyFactory.getStrategy(randomInput);
            int result = strategy.parse(randomInput);
            assertTrue(result >= 0); // 결과가 음수로 나오지 않는지 확인
        });
    }
}
