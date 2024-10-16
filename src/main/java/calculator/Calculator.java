package calculator;

public class Calculator {

    /**
     * 숫자의 합 계산
     */
    public int add(String input) {
        int sum = 0;

        // 빈 입력 처리 (빈 문자열, 엔터, 탭, null)
        if (input.isBlank() || input == null) {
            return sum;
        }

        // 단일 숫자 입력 처리
        if (isInteger(input)) {
            return Integer.parseInt(input);
        }

        // 음수 입력 예외 처리
        if (input.contains("-")) {
            throw new IllegalArgumentException();
        }

        // 쉼표 및 클론 구분자 처리
        if (input.contains(",") || input.contains(":")) {
            return defaultSeparators(input);
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            return customSeparators(input);
        }

        throw new IllegalArgumentException();

    }

    /**
     * 입력이 정수인지 확인
     */
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 기본 구분자(쉼표, 콜론) 처리
     */
    private int defaultSeparators(String input) {
        int sum = 0;

        String[] commaSplit = input.split(",");
        for (String part : commaSplit) {
            String[] colonSplit = part.split(":");
            for (String number : colonSplit) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }

    /**
     * 커스텀 구분자 처리
     */
    private int customSeparators(String input) {
        int sum = 0;

        int start = input.lastIndexOf("/");
        int end = input.indexOf("\\n");
        String separator = input.substring(start + 1, end);
        System.out.println("separator = " + separator);

        // 파이프(|) 문자 처리
        if ("|".equals(separator)) {
            separator = "\\|";
        }

        String part = input.split("n")[1];
        System.out.println("part = " + part);
        String[] numbers = part.split(separator);
        for (String number : numbers) {
            System.out.println("number = " + number);
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
