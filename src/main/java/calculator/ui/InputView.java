package calculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private static final String ERROR_MESSAGE = "잘못 입력하였습니다.";
    private final BufferedReader bufferedReader;

    public InputView(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String inputView()  {
        System.out.println(INPUT_SENTENCE);
        String str = null;
        try{
            str = bufferedReader.readLine();
        } catch(Exception e) {
            System.out.println(ERROR_MESSAGE);
        }

        return str;
    }
}
