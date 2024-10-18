package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        if(input.startsWith("//")){

            String[] split = input.split("\\\\n");

            String delimiter = split[0].replace("//", "");
            String numbers = split[1];

            input = numbers.replace(delimiter, ",");

        }

    }
}
