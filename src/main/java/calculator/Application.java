package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine().replace("\"", "").trim();
    }
}

class StringCalculator {
    private final String input;
    private String delim = ",|:";

    public StringCalculator(String input){
        this.input = input;
    }

    public int addAll(){
        String numbers = getNumsPart();
        String[] pieces = splitNums(numbers);
        return 0;
    }

    private String getNumsPart(){
        return input;
    }
    private String[] splitNums(String numbers) {
        return numbers.split("[" + delim + "]");
    }
}
