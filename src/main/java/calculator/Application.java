package calculator;

import calculator.cal.Calculator;
import calculator.cal.CalculatorImpl;
import calculator.cal.numberadder.string.StringNumberAdder;
import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new CalculatorImpl(new StringNumberAdder());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //문자열 받기
        writer.write("덧셈할 문자열을 입력해 주세요.\n");
        writer.flush();
        String inputString;
        try {
            inputString = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("문자열을 입력하지 않았습니다.");
        }

        //결과 처리
        int result = calculator.add(inputString);
        writer.write("결과 : " + result);
        writer.flush();
    }
}
