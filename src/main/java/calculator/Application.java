package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<String> splitByCommaOrColon(String input) {
        // 정규식을 사용하여 , 혹은 : 로 문자열을 분리
        String[] parts = input.split("[,:]");
        return Arrays.asList(parts);
    }

    public static void main(String[] args) {
        String string;

        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요");
        string= sc.nextLine();;

        List<String> result = splitByCommaOrColon(string);
        System.out.println(result);
    }
}
