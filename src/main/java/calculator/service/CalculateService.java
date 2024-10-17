package calculator.service;

import calculator.domain.StringAddCalculator;
import calculator.util.CommonConstant;

public class CalculateService {

    private StringAddCalculator stringAddCalculator;

    public CalculateService(StringAddCalculator stringAddCalculator) {
        this.stringAddCalculator = stringAddCalculator;
    }

    public int calculate() throws IllegalArgumentException {
        String str = stringAddCalculator.getFormula();
        String delimeter = stringAddCalculator.getDelimeter();
        if(str == null || str.isEmpty()) {
            return 0;
        }

        if(str.startsWith("/")) {
            if(str.length() >= CommonConstant.MINIMUM_LENGTH
                    && str.charAt(1) == '/'
                    && str.charAt(3) == '\\'
                    && str.charAt(4) == 'n') {
                //추가 구분자 구성이 잘된 경우
                char del = str.charAt(2);
                delimeter += "|" + del;

                String cutFormula = str.substring(5);

                int sum = sumAll(cutFormula, delimeter);

                return sum;
            }
            else {
                //추가 구분자 구성이 잘못된 경우
                throw new IllegalArgumentException();
            }
        }
        else {
            int sum = sumAll(str, delimeter);

            return sum;
        }
    }

    private int sumAll(String str, String delimeter) {
        String[] number = str.split(delimeter);

        int sum = 0;
        for(String num : number) {
            int part = Integer.parseInt(num);
            if (part < 0) {
                throw new IllegalArgumentException();
            }
            sum += part;
        }
        return sum;
    }
}
