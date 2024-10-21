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

    public Boolean textValidation(String text) {
        return text != null && !text.isEmpty();  // 빈 문자열일 경우 0 반환
    }

    public String[] parsing(String text) {
        if (text.startsWith("//")) {
            int startIndex = text.indexOf("\\n");
            String customDelimiter = checkCustomDelimiter(text.substring(2, startIndex));
            String numbersPart = text.substring(startIndex + 2);
            return numbersPart.split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private String checkCustomDelimiter(String customDelimiter) {
        if (customDelimiter.contains("\\")) {
            customDelimiter = customDelimiter.replace("\\","\\" + "\\");
        }
        return customDelimiter;
    }

    public int sum(String[] parsinged){
        int result = 0;
        for (String s : parsinged) {
            result += Integer.parseInt(s);
        }
        return result;
    }
    public void parseValidation(String[] parsinged){
        for (String s : parsinged) {
            checkMinus(s);
            checkInteger(s);
        }
    }

    public void checkMinus(String parsinged){
        if (Integer.parseInt(parsinged) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void checkInteger(String parsinged){
        try{
            Integer.parseInt(parsinged);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
