package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args){
        String input = readLine();

        int sum = 0;

        if (input.contains(":") || input.contains(";")) {
            String[] splitNumbers = input.split("\\D");

            for (int i = 0; i < splitNumbers.length; i++) {
                if(splitNumbers[i].equals("")) {
                    splitNumbers[i] = "0";
                }
            }

            for (String numberString : splitNumbers) {
                int parsedInt = Integer.parseInt(numberString);
                sum += parsedInt;
            }

            System.out.println("결과 : " + sum);

        } else if (input.contains("//") && input.contains("\\n")) {
            String[] splitNumbers = input.split("\\D");

            for (int i = 0; i < splitNumbers.length; i++) {
                if(splitNumbers[i].equals("")) {
                    splitNumbers[i] = "0";
                }
            }

            for (String s : splitNumbers) {
                int integer = Integer.parseInt(s);
                sum += integer;
            }

            System.out.println("결과 : " + sum);

        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}