package calculator.Model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class GenernalInput extends Input{

    public GenernalInput(String input) {
        super(input);
    }

    @Override
    void getNumbersFromInput(String userInput){
        String[] userInputArray =splitByDelimiter(userInput);

        inputNumbers =Arrays.stream(userInputArray)
                .mapToDouble(this::convertToDouble)
                .toArray();

    }
    @Override
    String[] splitByDelimiter(String userInput){
        String delimiterPattern = String.join("|", delim.stream()
                .map(delimiter -> Pattern.quote(delimiter))
                .toArray(size -> new String[size]));
        // 결합된 패턴을 사용해 문자열을 구분자로 나눔
        return userInput.split(delimiterPattern);
    }
}
