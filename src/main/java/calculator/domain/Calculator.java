package calculator.domain;

import java.util.List;

public class Calculator {

    int result;

    public int calculatorLogic(InputText inputText){
        String text = inputText.getText();
        List<String> separatorList = inputText.getSeparatorList();
        String separators = String.join("|",separatorList);
        String[] numberArray = text.split(separators);
        for (int i=0;i<numberArray.length;i++){
            checkCondition(numberArray[i]);
            int number = Integer.parseInt(numberArray[i]);
            result += number;
        }
        return result;
    }

    public void checkCondition(String number){
        String regex = "^[1-9]\\d*$";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
