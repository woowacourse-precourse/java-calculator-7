package calculator;

public class StringAddCalculator {
    public double splitAndSum(String exp) {
        if(exp==null || exp.trim().isEmpty()) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
        }
        String[] numbers = exp.split(",|:");
        double result = 0.0;

        for(String number : numbers) {
            double strToNum = 0.0;
            try {
                //result += Integer.parseInt(num);
                strToNum = Double.parseDouble(number);
                result += strToNum;
                if(strToNum <= 0)
                    throw new IllegalArgumentException("양수만 입력 가능합니다: " + strToNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식의 입력값입니다: " + number);
            }
        }
        return result;
    }
}
