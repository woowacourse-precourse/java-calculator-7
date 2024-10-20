package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String userInput;
        int[] arrayUserInput;
        String numberLine;
        
        //입력 값이 없을 경우 예외 처리
        try {
            userInput = readLine();
        }catch (java.util.NoSuchElementException e){
            System.out.printf("결과 : %d",0);
            return;
        }

        //여는 커스텀 구분자만 있을 경우
        if(userInput.contains("//") && !userInput.contains("\\n")){
            throw new IllegalArgumentException("There is only a custom delimiter : " + userInput);
        }
        //커스텀 구분자 or 기본 구분자 구분
        if(userInput.contains("//") && userInput.contains("\\n")) {
            int start = 2;
            int end = userInput.indexOf("\\n");

            //커스컴 구분자
            String customDelimiter = userInput.substring(start,end);

            //커스텀 구분자가 없을 경우 예외 처리
            if (customDelimiter.isEmpty()){
                throw new IllegalArgumentException("Custom delimiter cannot be empty.");
            }

            numberLine = userInput.substring(end+2);
            arrayUserInput = splitDelimiters(numberLine,customDelimiter);
        }else {
            numberLine = userInput;
            arrayUserInput = splitDelimiters(numberLine);
        }

        System.out.printf("결과 : %d",arrSum(arrayUserInput));

    }


    public static int[] splitDelimiters(String numberLine) {
        return splitDelimiters(numberLine, "[,:]");
    }

    public static int[] splitDelimiters(String numberLine, String delimiter){

        //빈 문자열이 입력 되었을 경우 처리
        if (numberLine.isEmpty()){
            return new int[]{};
        }

        // 정규식 메타문자를 구분자를 처리하기 위해 delimiter를 이스케이프 처리
        String escapedDelimiter = delimiter.equals("[,:]") ? "[,:]" : Pattern.quote(delimiter);

        String[] stringNumbers = numberLine.split(escapedDelimiter);
        int[] numbers = new int[stringNumbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            String trimmedNumber = stringNumbers[i].trim();
            if (trimmedNumber.matches("\\d+")) {
                numbers[i] = Integer.parseInt(trimmedNumber);
            } else {
                throw new IllegalArgumentException("The input contains invalid characters. Only numbers can be added: " + stringNumbers[i]);
            }

        }
        return numbers;
    }
    public static int arrSum(int[] numbers){
        int sum = 0;

        //빈 배열을 입력 되었을 경우 처리
        if(numbers.length == 0){
            return 0;
        }

        for(int number:numbers){
            // 양수가 아닌 경우 예외 발생
            if (number <= 0){
                throw new IllegalArgumentException("Negative numbers or zero are not allowed : " + number);
            }
            sum += number;
        }

        return sum;
    }
}


