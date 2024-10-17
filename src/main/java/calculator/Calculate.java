package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculate {

    void run() {
        int sum = 0;
        String input = Console.readLine();
        String[] tokens = validateCustomSeparator(input);
        int[] newTokens = validateNumber(tokens);

        for (int newToken : newTokens) {
            sum += newToken;
        }
        
        System.out.println("결과 : " + sum);
    }

    private String[] validateCustomSeparator(String input) {
        String separator = ",|;";
        String numbersPart = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("구분자 정의가 잘못됐습니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 정의되지 않았습니다.");
            }
            separator = separator + "|" + "\\" + customDelimiter;
            numbersPart = input.substring(newlineIndex + 2);
        }

        return numbersPart.split(separator);
    }


    private int[] validateNumber(String[] tokens) {
        int[] newTokens = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].isEmpty()) {
                tokens[i] = "0";
            }
            newTokens[i] = Integer.parseInt(tokens[i]);

            if (newTokens[i] < 0) {
                throw new IllegalArgumentException("음수 값이 포함되어 있습니다.");
            }
        }
        return newTokens;
    }
}
