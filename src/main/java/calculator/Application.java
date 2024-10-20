package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int[] arrayUserInput;
        String numberLine;

        String userInput = readLine();

        if(userInput.contains("//") && userInput.contains("\\n")) { //커스텀 구분자 or 기본 구분자 구분
            int start = 2;
            int end = userInput.indexOf("\\n");
            String customDelimiter = userInput.substring(start,end);//커스컴 구분자
            numberLine = userInput.substring(end+2);
            arrayUserInput = splitDelimiters(numberLine,customDelimiter);
        }else {
            numberLine = userInput;
            arrayUserInput = splitDelimiters(numberLine);
        }

        System.out.println(arrSum(arrayUserInput));

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
        String escapedDelimiter = Pattern.quote(delimiter);

        String[] stringNumbers = numberLine.split(escapedDelimiter);
        int[] numbers = new int[stringNumbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i].trim());
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
            sum += number;
        }

        return sum;
    }
}


