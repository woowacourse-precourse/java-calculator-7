//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package calculator.domain;

public class Calculator {
    public Calculator() {
    }

    public int add(String[] numbers) {
        int sum = 0;
        String[] var3 = numbers;
        int var4 = numbers.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String number = var3[var5];
            sum += this.toPositiveInt(number);
        }

        return sum;
    }

    private int toPositiveInt(String number) {
        int num = this.parseInt(number);
        this.validateNonNegative(num);
        return num;
    }

    private int parseInt(String number) {
        if (number != null && !number.trim().isEmpty()) {
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException var3) {
                throw new IllegalArgumentException("유효한 숫자가 아닙니다: " + number);
            }
        } else {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다: 빈 문자열");
        }
    }

    private void validateNonNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
    }
}
