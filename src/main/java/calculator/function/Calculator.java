package calculator.function;

import java.util.List;

public class Calculator {
    private List<String> inputStrings;

    public Calculator(List<String> inputStrings) {
        this.inputStrings = inputStrings;
    }

    public String execute(){
        String result = "";
        int carriage = 0;
        for (String inputString : inputStrings) {
            int minLength = Math.min(inputString.length(), result.length());
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < minLength; i++) {
                int resultIndex = result.length() - 1 - i;
                int nowIndex = inputString.length() - 1 - i;
                ResultCalc resultCalc = add(result.charAt(resultIndex), inputString.charAt(nowIndex));
                int digit = resultCalc.getDigit() + carriage;
                builder.append((char)('0' + digit % 10));
                carriage = digit / 10 + resultCalc.getCarriage();
            }
            if(result.length() > inputString.length()){
                for (int i = minLength; i < result.length(); i++) {
                    int resultIndex = result.length() - 1 - i;
                    ResultCalc resultCalc = add(result.charAt(resultIndex), (char) ('0' + carriage));
                    carriage = resultCalc.getCarriage();
                    builder.append((char)('0' + resultCalc.getDigit()));

                }
            }
            if(result.length() < inputString.length()){
                for (int i = minLength; i < inputString.length(); i++) {
                    int nowIndex = inputString.length() - 1 - i;
                    ResultCalc resultCalc = add(inputString.charAt(nowIndex), (char) ('0' + carriage));
                    carriage = resultCalc.getCarriage();
                    builder.append((char)('0' + resultCalc.getDigit()));
                }
            }
            if(carriage > 0){
                builder.append("1");
                carriage = 0;
            }

            result = builder.reverse().toString();
        }
        return result;
    }

    private ResultCalc add(char a, char b){
        int sum = Character.getNumericValue(a) + Character.getNumericValue(b);
        int carry = sum / 10;
        int digit = sum % 10;
        return new ResultCalc(digit, carry);
    }
    private static class ResultCalc {
        private final int digit;
        private final int carriage;

        public ResultCalc(int digit, int carriage) {
            this.digit = digit;
            this.carriage = carriage;
        }

        public int getDigit() {
            return digit;
        }

        public int getCarriage() {
            return carriage;
        }
    }
}
