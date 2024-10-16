package calculator.service;

public class CalculatorService {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        System.out.println(calculatorService.customAdd("//;\n1;2;3;"));
    }

    public int calculator(String input) {
        if (defaultOrCustomDelimeter(input)) {
            return customAdd(input);
        }
        return defaultAdd(input);
    }

    // 더하기 메소드 구현
    public int defaultAdd(String input) {
        String[] str = input.split("[,:]");

        int sum = 0;
        for (String s : str) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    // 2) 커스텀 구분자를 포함하여 숫자를 구분하여 더함.
    public int customAdd(String input) {
        String prefix = input.substring(0, 2);
        String suffix = input.substring(3, 5);
        int sum = 0;

        if (prefix.equals("//") && suffix.equals("\\n")) {
            String customDelimeter = String.valueOf(input.charAt(2));
            String newInput = input.substring(5);
            String[] customSplit = newInput.split(customDelimeter);

            for (String s : customSplit) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    public boolean defaultOrCustomDelimeter(String input) {
        if (input.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    // 3) 예외 처리

}
