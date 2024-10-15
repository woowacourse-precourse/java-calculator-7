package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {
        InputStringParser parser = new InputStringParser();
        String inputString = Console.readLine();

        try {
            List<Long> list = parser.parse(inputString);

        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }
}
