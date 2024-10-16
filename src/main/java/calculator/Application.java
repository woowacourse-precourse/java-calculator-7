package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        calculate("1:2,34");

    }
    // 올바른 입력형태 (ex. 11:22,33)
    // 커스텀 구분자 입력 가능
    private static int calculate(String input, String... customSep) {
        String delimeters = ",|:";
        if (customSep.length > 0) {
            delimeters += "|" + customSep[0];
        }
        String[] arr = input.split(delimeters);
        int sum = 0;
        for (String s : arr){
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
        return sum;
    }

}
