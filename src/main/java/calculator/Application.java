package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String inputLine(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static String[] separateString(String line){
        if(line.startsWith("//")){
            String[] parts = line.split("\\\\n"); //\n으로 구분

            String separator = parts[0].replace("//","");
            separator += ",:"; //기본 문자열 추가

            return new String[]{separator, parts[1]};
        } else if (line.equals("")) {
            line = "0";
        }
        return new String[]{",:", line};
    }

    public static void validateInput(String separators, String operation){
        for (char ch : operation.toCharArray()) {
            if (!Character.isDigit(ch) && !separators.contains(Character.toString(ch))) {
                throw new IllegalArgumentException("유효하지 않은 문자 '" + ch + "'가 포함되어 있습니다.");
            }
        }
    }

    public static int calculate(String separators, String operation){
        String[] numbers = operation.split("["+separators+"]");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public static void main(String[] args){
        String line= inputLine();

        String[] separatorAndOperation = separateString(line);
        String separators = separatorAndOperation[0];
        String operation = separatorAndOperation[1];

        validateInput(separators, operation);

        int result = calculate(separators, operation);

        System.out.println("결과 : " + result);
    }
}
