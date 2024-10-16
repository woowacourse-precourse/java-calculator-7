package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input= Console.readLine();
        String[] numbers;

        ExtractNumber en= new ExtractNumber(input);
        numbers=en.split();

        System.out.println(sum(numbers));
    }

    private static int sum(String[] numbers){
        try{
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .peek(num->{
                        if(num<0){
                            throw new IllegalArgumentException();
                        }
                    })
                    .sum();
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}
