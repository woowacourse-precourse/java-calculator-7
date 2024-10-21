package calculator;

public class PickNumberTotal {
    public static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number; // 각 숫자를 합산
        }
        return total; // 최종 합계 반환
    }
}
