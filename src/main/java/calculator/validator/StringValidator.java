package calculator.validator;

import java.util.ArrayList;
import java.util.List;

public class StringValidator {

    public String[] checkDelimiter(String input) {

        String basicDelimiter = ",|:";
        System.out.println(input.startsWith("//"));
        System.out.println(input.indexOf("\n"));

        if (input.startsWith("//")) {
            int deliEnd = input.indexOf("\n");
            if (deliEnd != -1) {
                String customDelimiter = input.substring(2, deliEnd);
                System.out.println(customDelimiter);

                if (customDelimiter.equals("-")) {
                    System.out.println("본 계산기는 양수 덧셈만을 지원합니다. 해당 값은 구분자로만 처리됩니다.");
                }

                String delimiters = basicDelimiter + "|" + customDelimiter;
                input = input.substring(deliEnd + 1);
                System.out.println(input);
                return input.split(delimiters);
            }
        }
        return input.split(basicDelimiter);
    }


    public List<Integer> checkNumber(String[] nums) {
        List<Integer> list = new ArrayList<>();
        for (String stringNumber : nums) {
            int intNum = Integer.parseInt(stringNumber);
            if (intNum < 0) {
                System.out.println();
                throw new IllegalArgumentException();
            }
            list.add(intNum);
        }
        return list;
    }

    public int sumNumber(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
