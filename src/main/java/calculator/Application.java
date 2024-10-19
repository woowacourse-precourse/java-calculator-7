package calculator;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int[] arrayUserInput;
        String userInput;
        String numberLine;

        userInput = readLine(); // userInput 입력

        numberLine = userInput;
        arrayUserInput = splitDelimiters(numberLine);
        System.out.println(Arrays.toString(arrayUserInput));//쉼표 또는 콜론 구분자로 분리 된 리스트

    }


    public static int[] splitDelimiters(String numberLine) {
        //빈 문자열이 입력 되었을 경우
        if (numberLine.isEmpty()) {
            return new int[]{};
        }

        String[] stringNumbers = numberLine.split("[,:]");
        int[] numbers = new int[stringNumbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i].trim());
        }
        return numbers;
    }
}



