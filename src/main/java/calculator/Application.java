package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        List<String> operators = new ArrayList<>();
        operators.add(".");
        operators.add(";");
        Integer sum = 0;

        if (input.startsWith("//")) {
            OperatorParser opParser = new OperatorParser();
            String[] result = opParser.parseOperator(input);
            operators.add(result[0]);
            input = result[1];
        }

        String[] digits = input.split(String.valueOf(operators));
        for (String digit : digits) {
            int num = Integer.parseInt(digit);
            if(num < 0){
                throw new IllegalArgumentException();
            }
            sum += num;
        }
        System.out.println("결과 : " + sum);
    }
}
