package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterGenerator {

    public static DelimiterInputDTO generateDelimiter(String input) {

        DelimiterInputDTO delimiterInputDTO = new DelimiterInputDTO(input);

        List<Character> delimiter = new ArrayList<>(List.of(',', ':'));

        Pattern delimiterFormatPattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher delimiterFormat = delimiterFormatPattern.matcher(input);

        if (delimiterFormat.matches()) {
            delimiterInputDTO.setInput(delimiterFormat.group(2));

            delimiter.add(delimiterFormat.group(1).charAt(0));
        }

        delimiterInputDTO.setDelimiter(delimiter);

        return delimiterInputDTO;

    }
}
