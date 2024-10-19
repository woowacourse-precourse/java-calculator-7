package calculator.domain;

public class Calculator {

    int result;

    public int calculatorLogic(InputText inputText){
        String[] numberArray = makeNumberArray(inputText);
        for (String sn : numberArray) {
            checkCondition(sn);
            int number = checkBlank(sn);
            result += number;
        }
        return result;
    }

    String[] makeNumberArray(InputText inputText){
        String separators = String.join("|",inputText.getSeparatorList());
        return inputText.getText().split(separators);
    }

    void checkCondition(String number){
        String regex = "^[1-9]\\d*$|";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

   int checkBlank(String number){
        return !number.isEmpty() ? Integer.parseInt(number) : 0;
    }

}
