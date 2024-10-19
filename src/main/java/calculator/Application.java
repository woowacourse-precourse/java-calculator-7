package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private List<Character> delimiters = new ArrayList<>(Arrays.asList(',', ':'));
    private boolean isCustomDelimiter = false;

    private void extractCustomDelimiter(String input, List<Character> delimiters) {
        if(input.startsWith("//") && input.substring(3,5).equals("\\n")){
            delimiters.add(input.charAt(2));
            isCustomDelimiter = true;
        }
    }

    public void startApplication() {
        List<Long> numbers = new ArrayList<>();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        extractCustomDelimiter(input, delimiters);

       long sum = 0;

        System.out.println("결과 : " + sum);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.startApplication();
    }

}
