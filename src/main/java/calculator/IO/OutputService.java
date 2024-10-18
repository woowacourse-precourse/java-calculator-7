package calculator.IO;

import static calculator.Message.Message.OUTPUT_MESSAGE;

public class OutputService {
    public void printSum(int sum) {
        // 덧셈 연산 결과 출력
        System.out.println(OUTPUT_MESSAGE + sum);
    }
}
