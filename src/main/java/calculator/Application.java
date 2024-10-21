package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringCalculator sc = new StringCalculator(input);
        sc.findCustomDelimiter();
        sc.splitByDelimiter();
        sc.calculateSum();
        int sum = sc.getSum();

        System.out.println("결과 : " + sum);
    }
}

class StringCalculator {
    private String input;
    private String delimiter;
    private String[] nums;
    private int sum;

    public StringCalculator(String input) {
        this.input = input;
        this.delimiter = ",|:";
        this.sum = 0;
    }

    // 커스텀 구분자
    public void findCustomDelimiter() {
        if (input.startsWith("//")) {
            nums = input.split("\\\\n", 2);
            if (nums.length == 1) {
                throw new IllegalArgumentException("Invalid custom delimiter format");
            } else {
                delimiter += "|" + nums[0].substring(2);
                input = nums[1];
            }
        }
    }

    // 구분자를 기준으로 분리
    public void splitByDelimiter() {
        nums = input.split(delimiter);
    }

    // 숫자들의 합 계산
    public void calculateSum() {
        for (String num : nums) {
            if (num.isEmpty()) {
                continue;
            }
            try {
                sum += Integer.parseInt(num);
                if (Integer.parseInt(num) < 0) {
                    throw new IllegalArgumentException("Negative number");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format");
            }
        }
    }

    // 숫자들의 합 반환
    public int getSum() {
        return sum;
    }
}
