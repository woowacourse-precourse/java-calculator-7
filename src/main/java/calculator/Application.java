package calculator;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int result = 0;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        if(!isEmpty(input)){
            ArrayList<String> str = splitToArrayList(input);
            checkForInvalidInput(str);
            result = sumOfNumbers(str);
            System.out.println("결과 : " + result);
        } else {
            System.out.println("결과 : " + result);
        }
    }

    public static boolean isEmpty(String str){
        return str.length() == 0;
    }

    public static ArrayList<String> splitToArrayList(String input) {
        StringBuilder delimiter = new StringBuilder(",|;"); // 기본 구분자: 쉼표와 세미콜론
        String numbers = input;

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            // "//"와 "\n" 사이의 문자열을 구분자로 사용
            int delimiterEndIndex = input.indexOf("\\n");
            numbers = input.substring(delimiterEndIndex + 2);

            for(int i = 2; i<delimiterEndIndex; i++){
                delimiter.append("|").append(input.charAt(i));
            }
        }

        String[] splitValues = numbers.split(delimiter.toString());
        return new ArrayList<>(Arrays.asList(splitValues));
    }

    public static void checkForInvalidInput(ArrayList<String> values) {
        ArrayList<String> negativeNumbers = new ArrayList<>();
        for (String value : values) {
            try {
                int number = Integer.parseInt(value);
                if (number < 0) {
                    negativeNumbers.add(value);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: "+ value);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }
    }

    public static int sumOfNumbers(ArrayList<String> values){
        int sum = 0;
        for (String value: values){
            sum += Integer.parseInt(value);
        }
        return sum;
    }

}
