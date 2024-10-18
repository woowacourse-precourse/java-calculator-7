package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();

        List<Integer> arr = new ArrayList<>();
        List<Character> std = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int sum = 0;
        std.add(',');
        std.add(':');


        if(str.startsWith("//")) {
            if(str.charAt(3) == '\\' && str.charAt(4) == 'n') {
                std.add(str.charAt(2));
                str = str.substring(5);
            }
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                temp.append(str.charAt(i));
            } else if(std.contains(str.charAt(i))) {
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