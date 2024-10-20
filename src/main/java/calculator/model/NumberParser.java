package calculator.model;

import calculator.validator.NumberValidator;
import java.util.ArrayList;
import java.util.HashMap;

public class NumberParser {
    private final NumberValidator numberValidator = new NumberValidator();

    public ArrayList<String> parseNumberString(HashMap<String, String> separatorAndNumbersMap) {

        String numberString = separatorAndNumbersMap.get("numberString");
        String separatorRegex = String.valueOf(separatorAndNumbersMap.get("separator").charAt(0));

        for (int separatorIndex = 1; separatorIndex < separatorAndNumbersMap.get("separator").length();
             separatorIndex++) {
            String separator = String.valueOf(separatorAndNumbersMap.get("separator").charAt(separatorIndex));

            int separatorAsciiValue = (int) separator.charAt(0);
            if ((separatorAsciiValue >= 65 && separatorAsciiValue <= 90) || (separatorAsciiValue >= 97
                    && separatorAsciiValue <= 122)) {
                separatorRegex += ("|" + separator);
            } else if ((separatorAsciiValue >= 33 && separatorAsciiValue <= 47) || separatorAsciiValue >= 58) {
                separatorRegex += ("|\\" + separatorAsciiValue);
            }
        }

        ArrayList<String> parsedNumberList = new ArrayList<>();

        String[] numbers = numberString.split(separatorRegex);

        for (String number : numbers) {
            String trimmedNumber = number.trim();
            parsedNumberList.add(trimmedNumber);
        }

        return parsedNumberList;
    }
}
