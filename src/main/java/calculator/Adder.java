package calculator;

import java.util.ArrayList;

public class Adder {

    long output=0;

    public Adder(AdderScanner adderScanner) {

        ArrayList<Integer> TokenArray=adderScanner.getOutput();

        for(int num:TokenArray) {
            if (willOverflow(output,num)) {
                throw new OverflowException("정수 범위를 초과했습니다");
            }
            output +=num;
        }

        //System.out.println("result:" +output);

    }

    class OverflowException extends RuntimeException {
        public OverflowException(String message) {
            super(message);
        }
    }

    // 두 정수의 합이 long 범위를 초과하는지 확인하는 메서드
    private static boolean willOverflow(long a, long b) {
        if (a > 0 && b > 0 && a > Long.MAX_VALUE - b) {
            return true; // 오버플로우 발생 가능성 있음
        }
        if (a < 0 && b < 0 && a < Long.MIN_VALUE - b) {
            return true; // 언더플로우 발생 가능성 있음
        }
        return false;
    }

    public long getOutput() {
        return output;
    }
}
