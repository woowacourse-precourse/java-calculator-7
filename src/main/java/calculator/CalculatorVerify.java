package calculator;

public class CalculatorVerify {

    void isVerifySuccess(int[] intArray) {
        if (intArray == null) {
            throw new IllegalArgumentException("계산할 수 있는 값이 없습니다.");
        }

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 0) {
                throw new IllegalArgumentException("계산 가능한 값이 아닙니다.");
            }
        }

    }
}
