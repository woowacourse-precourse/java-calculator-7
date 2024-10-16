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


    }

    private static String parseCustomDelimiter(String str){
        if(str.startsWith("//")){
            delimContainer.add(str.charAt(2));
            return str.substring(5);
        }
        return str;
    }

}
