package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Separator separator = new Separator(',',':');

        String input = userInput();


    }

    public static String userInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        return Console.readLine();
    }



}
