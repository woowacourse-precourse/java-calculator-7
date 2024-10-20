package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {


    }

    //1. 입력 받기
    private static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        //커스텀 구분자 사용 시 다음줄 입력받기.
        if (input.startsWith("//") && input.contains("\n")) {
            String nextLine = Console.readLine();
            input += "\n" + nextLine;
        }
        return input;
    }

    //2. 커스텀 구분자 추출
    private static String extraDelimiter(String input) {
        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
        }
        return delimiter;
    }
    //3.숫자와 문자열 분리
    private static String[] splitNumbers(String input,String delimiter)
    {
        return input.split(delimiter);// ex ) 1:2:3 을 구분자 기준으로 나눔
    }

}
