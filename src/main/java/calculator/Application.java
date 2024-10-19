package calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String str = br.readLine();

            String customSeparator = null;
            String expression = null;


            if (str.contains("//") && str.contains("\\n")) {
                int slashIndex = str.indexOf("//");
                int enterIndex = str.indexOf("\\n");

                customSeparator = str.substring(slashIndex + 2, enterIndex);
                expression = str.substring(enterIndex + 2);
            }

            if (Objects.isNull(customSeparator)) {
                customSeparator = ",";
                expression = str;
            }


            int result = calc(expression, customSeparator);
            System.out.println("결과: " + result);

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static int calc(String expression, String customSeparator) throws Exception {
        int sum = 0;
        String[] numbers = expression.split(customSeparator);
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new Exception();
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}