package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_START_VALUE = "//";
    private static final String CUSTOM_SEPARATOR_END_VALUE = "\\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        System.out.println("결과 : " + sumInputValue(input));
    }

    private static int sumInputValue(String input) {
        boolean isCustomSeparator = input.startsWith(CUSTOM_SEPARATOR_START_VALUE);
        String separator = DEFAULT_SEPARATOR;

        if(isCustomSeparator) {
            int i = input.indexOf(CUSTOM_SEPARATOR_END_VALUE);
            if(i == -1) {
                throw new IllegalArgumentException();
            }

            separator =  input.substring(CUSTOM_SEPARATOR_START_VALUE.length(), i);
            input = input.substring(i + CUSTOM_SEPARATOR_END_VALUE.length());
        }

        return sumStringNumbers(input, separator);
    }

    private static int sumStringNumbers(String input, String separator){
        String[] stringNumbers = input.split(separator);
        int sum = 0;

        for (String s : stringNumbers) {
            try {
                int num = Integer.parseInt(s);

                if(num < 0) {
                    throw new IllegalArgumentException();
                }

                sum += num;
            } catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }
}
