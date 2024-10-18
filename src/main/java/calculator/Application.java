package calculator;
import java.util.stream.Stream;

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

        String[] split1 = input.split(",|:");

        int resultSum = Stream.of(split1).mapToInt(s ->{

            for(Character c : s.toCharArray()){
                if(!Character.isDigit(c)) throw new IllegalArgumentException("숫자를 입력해주세요.");
            }

            int num = Integer.parseInt(s);
            if(num < 0) throw new IllegalArgumentException("양수값을 입력해주세요.");

            return num;

        }).sum();

        System.out.println("결과 : " + resultSum);

        Console.close();
    }
}
