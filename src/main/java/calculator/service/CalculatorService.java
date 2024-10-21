package calculator.service;

import calculator.controller.CalculatorController;

public class CalculatorService {
    private static CalculatorService calculatorService;

    public static CalculatorService getInstance() {
        if (calculatorService == null) {
            calculatorService = new CalculatorService();
        }
        return calculatorService;
    }

    public Integer textValidation(String text) {
        if (text == null || text.isEmpty()) {
            return 0;  // 빈 문자열일 경우 0 반환
        }
        return 1;
    }

    public String[] parsing(String text) {
        if (text.startsWith("//")) {
            int startIndex = text.indexOf('\n');
            String customDelimiter = text.substring(2, startIndex);
            String numbersPart = text.substring(startIndex + 1);
            return numbersPart.split(customDelimiter);
        }
        return text.split("[,:]");
    }

    public int sum(String[] parsinged){
        int result = 0;
        for (String s : parsinged) {
            result += Integer.parseInt(s);
        }
        return result;
    }

}
