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

    private void extractNumbers(String input, List<Long> numbers) {
        if(isCustomDelimiter) {
            input = input.substring(5);
        }
        StringBuilder regex = new StringBuilder("[");
        for (char delimiter : delimiters) {
            regex.append("\\").append(delimiter);
        }
        regex.append("]");

        // 구분자를 기준으로 문자열을 숫자들로 분리
        String[] tokens = input.split(regex.toString());
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    numbers.add(Long.parseLong(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
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
