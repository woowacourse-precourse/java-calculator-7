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

        char[] charArray = input.toCharArray();
        for(int i = 0; i< charArray.length; i=i+2){
            if(!Character.isDigit(charArray[i])){
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }

            if(Character.getNumericValue(charArray[i]) < 0 ){
                throw new IllegalArgumentException("양수를 입력하세요.");
            }
        }

        for(int i =1; i<charArray.length; i=i+2){
            if(charArray[i] != '|' || charArray[i] != ','){
                throw new IllegalArgumentException("구분자 입력이 올바르지 않습니다.");
            }
        }


        String[] split1 = input.split(",|:");

        int resultSum = Stream.of(split1).mapToInt(Integer::parseInt).sum();

        System.out.println("결과 : " + resultSum);

        Console.close();
    }
}
