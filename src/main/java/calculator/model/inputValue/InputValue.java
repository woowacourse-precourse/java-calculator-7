package calculator.model.inputValue;

import java.util.ArrayList;

public class InputValue {
    ArrayList<Integer> positiveIntegers;
    String delimiter = ",|:";
    String customDelimiter;

    String uncheckedInput;

    public InputValue(String inputValue){
        uncheckedInput = inputValue;
        isValidInput();
        checkCustomSeparator();
        extractNumber();
    }

    private void isValidInput() {
        if(uncheckedInput.isEmpty() || uncheckedInput == null){
            throw new IllegalArgumentException("입력값이 null이거나 비었습니다!");
        }

        if(Character.isLetter(uncheckedInput.charAt(0))){
            throw new IllegalArgumentException("알파벳으로 시작했습니다!");
        }
    }

    private void checkCustomSeparator(){
        if (uncheckedInput.startsWith("//")){
            int indexOfDelimiter = uncheckedInput.indexOf("n");
            if (indexOfDelimiter == -1) {
                throw new IllegalArgumentException("잘못된 형식으로 커스텀 구분자를 지정했습니다!");
            }
            customDelimiter = uncheckedInput.substring(2,indexOfDelimiter-1);
            delimiter = delimiter.concat("|").concat(customDelimiter);
            uncheckedInput = uncheckedInput.substring(indexOfDelimiter+1);
        }
    }

    private void extractNumber(){
        positiveIntegers = new ArrayList<>();
        String[] numbers = uncheckedInput.split(delimiter);

        int operand;

        for(String number : numbers) {
            try{
                operand = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바르지 않은 구분자를 사용하거나 숫자가 아닌 피연산자가 있습니다!");
            }

            if (operand < 0) {
                throw new IllegalArgumentException("입력값 중에 음수가 있습니다!");
            }
        }

        try{
            for(String number : numbers) {
                positiveIntegers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 구분자를 사용했습니다!");
        }
    }

    public String calculateSum() {
        int sum = 0;
        for (int number : positiveIntegers){
            sum += number;
        }
        return Integer.toString(sum);
    }
}
