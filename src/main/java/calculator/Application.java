package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AddCalculator {
    static Pattern customDelimiterRegex = Pattern.compile("//(.)\\\\n(.*)");
    String delimiterRegex = "[,:]";

    boolean isCustomDelimiterExisted(String input) {
        Matcher matcher = customDelimiterRegex.matcher(input);
        return matcher.matches();
    }

    String[] parseCustomDelimiterInput(String input) {
        Matcher matcher = customDelimiterRegex.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String customDelimiter = matcher.group(1);
        String formula = matcher.group(2);
        validateCustomDelimiter(customDelimiter);

        // 커스텀 구분자가 "." 이나 "+" 일 경우
        if (customDelimiter.equals(".") || customDelimiter.equals("+")) {
            customDelimiter = Pattern.quote(customDelimiter);
        }

        delimiterRegex = ",|:|" + customDelimiter;
        validateFormula(formula);

        return formula.split(delimiterRegex);
    }

    String[] parseDefaultInput(String input) {

        validateFormula(input);
        return input.split(delimiterRegex);
    }

    static int[] toIntArray(String[] parsedList) {
        int[] numbers = new int[parsedList.length];
        for (int i = 0; i < parsedList.length; i++) {
            numbers[i] = Integer.parseInt(parsedList[i]);
        }
        return numbers;
    }

    static int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private void validateCustomDelimiter(String customDelimiter) {
        // 예외 : 커스텀 구분자 = "-" 일 경우
        if (customDelimiter.equals("-")) {
            throw new IllegalArgumentException("커스텀 구분자로 -를 사용할 수 없습니다.");
        }
        // 예외 : 커스텀 구분자가 숫자일 경우
        if (customDelimiter.matches("[0-9]")) {
            throw new IllegalArgumentException("커스텀 구분자로 숫자를 사용할 수 없습니다.");
        }
    }

    private void validateFormula(String formula) {
        String formulaRegex = "^\\d+([" + Pattern.quote(delimiterRegex) + "]\\d+)*$";
        // 예외 : 덧셈식 형식이 잘못된 경우
        if (!formula.matches(formulaRegex)) {
            throw new IllegalArgumentException("덧셈식 형식이 잘못되었습니다.");
        }
    }

}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        result = calculateSum(input);
        System.out.println("결과 : " + result);
    }

    private static int calculateSum(String input) {
        // 빈 문자열 입력 시
        if (input.isEmpty()) {
            return 0;
        }

        AddCalculator calculator = new AddCalculator();
        String[] parsedList;

        if (calculator.isCustomDelimiterExisted(input)) {
            parsedList = calculator.parseCustomDelimiterInput(input);
        } else {
            parsedList = calculator.parseDefaultInput(input);
        }
        int[] numbers = AddCalculator.toIntArray(parsedList);
        return AddCalculator.add(numbers);
    }

}
