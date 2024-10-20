package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionOperatorTest {
    @Test
    void run_ShouldProcessInput_CalculateAndDisplayResult() {
        // 기존 IO 설정
        InputView inputView = new InputView() {
            @Override
            public String askInput() {
                return "1:2:3"; // 테스트 입력값
            }
        };
        OutputView outputView = new OutputView();
        Preprocessing preprocessing = new Preprocessing();
        Calculation calculation = new Calculation();
        IOProcessor ioProcessor = new IOProcessor(inputView, outputView, preprocessing);
        FunctionOperator functionOperator = new FunctionOperator(ioProcessor, calculation);

        // System.out 출력 캡처
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // 원래의 System.out 저장
        System.setOut(new PrintStream(outputStream)); // System.out을 ByteArrayOutputStream으로 변경

        // 테스트 실행
        functionOperator.run();

        // System.out 출력 복원
        System.setOut(originalOut);

        // 캡처된 출력 확인
        String expectedOutput = "덧셈할 문자열을 입력해 주세요.\n결과 : 6"; // TODO: 이건 아니다..
        String actualOutput = outputStream.toString(); // 캡처된 내용

        assertEquals(expectedOutput, actualOutput); // 출력 비교
    }
}
