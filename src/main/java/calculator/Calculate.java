package calculator;

public class Calculate {
    // 문자열로 숫자 합 계산
    public static Number sumString(String input) {

        double sum = 0;
        String[] inputToArr = input.trim().split(Application.separator);

        for (String i : inputToArr) {
            if (!i.isEmpty()) {
                try {
                    double num = Double.parseDouble(i);
                    if (num <= 0) {
                        throw new IllegalArgumentException("양수가 아닌 값이 있습니다: " + i);
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 있습니다: " + i);
                }
            }
        }

        if (sum == (int) sum) {
            return (int) sum;
        } else {
            return sum;
        }

    }
}
