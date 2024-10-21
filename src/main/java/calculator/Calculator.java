package calculator;

public class Calculator {
    public int run(String input) {
        return cal(input);
    }

    public int cal(String str) {
        // 2. 빈 문자열 입력 처리
        if (str.isEmpty()) return 0;

        // 3. 기본 구분자(쉼표, 콜론)로 문자열 분리
        String delimiter = ",|:";
        String input = str;

        //4. 커스텀 구분자로 문장 분리
        int customIndex = isCustom(str);
        if (customIndex != -1) {
            String customDelimiter = input.substring(2, customIndex);
            delimiter += "|" + customDelimiter;
            input = input.substring(customIndex + 2);
        }
        String[] numbers = input.split(delimiter);
        return sum(numbers);
    }

    // 4. 커스텀 구분자로 문장 분리
    private int isCustom(String str) {
        if (str.startsWith("//")) {
            return str.indexOf("\\n");
        }
        return -1;
    }

    // 5. 음수,문자열 예외 처리
    private void checkExclusive(String token) {
        try {
            int num = Integer.parseInt(token);
            if (num < 0) throw new IllegalArgumentException("음수 오류");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자 오류");
        }
    }

    // 6. 숫자 합산 로직 구현
    private int sum(String[] numbers) {
        int total = 0;
        for (String num : numbers) {
            checkExclusive(num);
            total += Integer.parseInt(num);
        }
        return total;
    }
}
