package calculator;

import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(input.startsWith("//")){
            input = normalizeDelimiter(input);
        }

        char[] charArray = input.toCharArray();
        isPositiveNumber(charArray);
        isDelimiter(charArray);

        String[] split1 = input.split(",|:");

        int resultSum = Stream.of(split1).mapToInt(Integer::parseInt).sum();

        System.out.println("결과 : " + resultSum);

        Console.close();
    }

    private static String normalizeDelimiter(String input) {
        String[] split = input.split("\\\\n");

        String delimiter = split[0].replace("//", "");
        String numbers = split[1];

        input = numbers.replace(delimiter, ",");
        return input;
    }

    private static void isDelimiter(char[] charArray) {
        for(int i = 1; i< charArray.length; i=i+2){
            char delimiter = charArray[i];
            if(delimiter != '|' || delimiter != ','){
                throw new IllegalArgumentException("구분자 입력이 올바르지 않습니다.");
            }
        }
    }

    private static void isPositiveNumber(char[] charArray) {
        for(int i = 0; i< charArray.length; i=i+2){
            char number = charArray[i];
            if(!Character.isDigit(number)){
                throw new IllegalArgumentException("숫자를 입력하세요.");
            }

            if(Character.getNumericValue(number) < 0 ){
                throw new IllegalArgumentException("양수를 입력하세요.");
            }
        }
    }

}
