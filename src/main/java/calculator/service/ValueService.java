package calculator.service;

import calculator.domain.Value;

public class ValueService {

    public static void saveUserInput(String userInput){
        Value.setOriginalValue(userInput);
    }

    public static void separateInputString(){
        String separators = SeparatorService.getSeparators();

        String originalValue = getOriginalInput();
        String[] parts = originalValue.split(separators);

        saveParts(parts);
    }

    public static String getOriginalInput(){
        return Value.getOriginalInput();
    }

    public static void saveParts(String[] parts){
        Value.saveParts(parts);
    }

    public static void removeMarking(){
        String originalInput = getOriginalInput();
        String changedInput = originalInput.substring(5);
        Value.setOriginalValue(changedInput);
    }

    public static String[] getSeparatedValue(){
        return Value.getSeparatedValue();
    }

    public static boolean isEmpty(){
        String originalValue = Value.getOriginalInput();
        if(originalValue.isBlank()||originalValue==null){
            return true;
        }else{
            return false;
        }
    }
}
