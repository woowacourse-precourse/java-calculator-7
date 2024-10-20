package calculator.domain;

import java.util.List;

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
        List<String> separatorList = inputText.getSeparatorList();
        String text = customSeparatorLogic(inputText.getText(),separatorList);
        return text.split(separatorList.get(0) +"|"+separatorList.get(1));
    }

    String customSeparatorLogic(String text, List<String> separatorList){
        if (separatorList.size()==3){
            String cs = separatorList.get(2);
            while (text.contains(cs)) text = text.replace(cs, ",");
        }
        return text;
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
