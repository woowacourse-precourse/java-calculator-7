package calculator;

public class AddingNum {
    // 숫자 배열을 합산하는 메서드
    static int sum(String[] numbers) {
        int result = 0;

        for (String num : numbers) {
            if (num.trim().isEmpty()) {
                continue;
            }
            // 숫자로 변환하고 예외 처리
            CheckValid.isValidNum(num.trim());

            result += Integer.parseInt(num.trim());
        }
        return result;
    }
}
