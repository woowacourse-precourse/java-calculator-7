package calculator.service;

import calculator.domain.Separator;
import calculator.domain.StringValue;

public class StringValueService {

    public static StringValue saveOriginalString(String userInput){
        return new StringValue(userInput);
    }

    public static boolean isEmpty(StringValue stringValue){
        if(stringValue.getOriginalValue().isBlank() || stringValue.getOriginalValue() == null){
            return true;
        }else{
            return false;
        }
    }

    public static String[] separateInputString(StringValue stringValue, Separator separator){
        String separators = separator.getSeparators();
        String originalValue = stringValue.getOriginalValue();

        String[] separatedValue = originalValue.split(separators);

        saveSeparatedValue(stringValue, separatedValue);
        return stringValue.getSeparatedValue();
    }

    public static void removeMarking(StringValue stringValue){
        stringValue.removeMarking();
    }

    private static void saveSeparatedValue(StringValue stringValue, String[] separatedValue){
        stringValue.saveSeparatedValue(separatedValue);
    }
}
