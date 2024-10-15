package calculator;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    /** 구분자 목록 */
    public static List<String> separators = new ArrayList<>();

    public static void main(String[] args) {
        Application app = new Application();
        app.initSeparator();

        String input = Console.readLine();
        app.getCustomSeparator(input);
    }

    private void initSeparator(){
        separators.add(",");
        separators.add(":");
    }

    private void getCustomSeparator(String input){
        System.out.println(input);
    }
}