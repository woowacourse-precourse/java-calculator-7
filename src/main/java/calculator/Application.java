package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();

        int length = str.length();
        List<Integer> arr = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                temp.append(str.charAt(i));
            }

            if (str.charAt(i) == ',' || str.charAt(i) == ':') {
                arr.add(Integer.parseInt(temp.toString()));
                temp = new StringBuilder();
            }
        }
        arr.add(Integer.parseInt(temp.toString()));

        for (int a : arr) {
            sum += a;
        }
        System.out.println("결과 : " + sum);

    }
}