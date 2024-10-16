package calculator;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final List<Character> delimContainer = new ArrayList<>(Arrays.asList(',', '.'));
    public static void main(String[] args){
        // TODO: 프로그램 구현
        String input = Console.readLine();

        input = parseCustomDelimiter(input);

        if(validateInput(input)) throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private static String parseCustomDelimiter(String str){
        if(str.startsWith("//")){
            delimContainer.add(str.charAt(2));
            return str.substring(5);
        }
        return str;
    }

    private static boolean validateInput(String input){
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(!isDigit(ch) && !delimContainer.contains(ch)) return true;
        }

        return false;
    }

    private static boolean isDigit(char ch){
        int chValue = ch - '0';
        return chValue >= 0 && chValue <= 9;
    }
}
