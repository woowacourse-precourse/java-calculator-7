package calculator;

public class Calculator {
    private int result;

    public void setResult(String[] separatedNumbers){
        for (String number : separatedNumbers) {
            try {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber <= 0) {
                    throw new IllegalArgumentException();
                }
                result += parsedNumber;
            }
            catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("결과 : " + result);
    }
}
