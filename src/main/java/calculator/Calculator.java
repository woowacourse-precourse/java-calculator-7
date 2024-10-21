package calculator;

public class Calculator {

    public double sum(String[] inputs) {

        double result = 0;

        if (isEmptyArray(inputs)) {
            return result;
        }

        for (String operand : inputs) {
            double parseDouble = Double.parseDouble(operand);
            if (parseDouble < 0) {
                throw new IllegalArgumentException("음수를 포함할 수 없습니다. 애플리케이션을 종료합니다.");
            }

            result += parseDouble;
        }

        return result;
    }

    private boolean isEmptyArray(String[] inputs) {
        return inputs.length == 0;
    }

}
