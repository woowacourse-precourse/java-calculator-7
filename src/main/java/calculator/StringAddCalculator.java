package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] tokens = input.split(",|:");
        // 이후 단계에서 숫자로 변환 및 합산 예정
        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        // 임시로 0 반환
        return 0;
    }

}
