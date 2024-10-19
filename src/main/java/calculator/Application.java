package calculator;

import calculator.cal.Calculator;
import calculator.cal.CalculatorImpl;
import calculator.cal.numberadder.string.StringNumberAdder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new CalculatorImpl(new StringNumberAdder());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //문자열 받기
        writer.write("덧셈할 문자열을 입력해 주세요.\n");
        writer.flush();
        String inputString = reader.readLine();

        //결과 처리
        int result = calculator.add(inputString);
        writer.write("결과 : " + result);
        writer.newLine();
        writer.flush();
    }
}
