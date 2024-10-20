package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static calculator.constant.DelimiterConstants.*;
import static calculator.constant.ErrorMessages.DELIMITER_CANNOT_BE_NUMBER;
import static calculator.constant.ErrorMessages.INVALID_DELIMITER_LENGTH;

public class Delimiters {
    private final List<String> delimiters = new ArrayList<>();

    public Delimiters(){
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters(){
        delimiters.add(",");
        delimiters.add(":");
    }

    public List<String> getDelimiters(){
        return delimiters;
    }

    public String getDelimiterRegex(String input){
        return getAllDelimiters(input)
                .stream()
                .collect(Collectors.joining("|"));
    }

    public List<String> getAllDelimiters(String input){
        String customDelimiter = findCustomDelimiter(input);

        if(!isDefaultDelimiter(customDelimiter)){
            validateDelimiter(customDelimiter);
            delimiters.add(customDelimiter);
        }
        return delimiters;
    }

    public String findCustomDelimiter(String input) {
        if(hasCustomDelimiter(input)){
            Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return NO_CUSTOM_DELIMITER;
    }

    private boolean hasCustomDelimiter(String input){
        return input.startsWith(CUSTOM_DELIMITER_START_SEPARATOR);
    }

    private void validateDelimiter(String delimiter){
        if(!isSingleCharacterDelimiter(delimiter)){
            throw new IllegalArgumentException(INVALID_DELIMITER_LENGTH);
        }

        if(isNumeric(delimiter)){
            throw new IllegalArgumentException(DELIMITER_CANNOT_BE_NUMBER);
        }
    }

    private boolean isDefaultDelimiter(String delimiter){
        return delimiter.equals(NO_CUSTOM_DELIMITER) || delimiters.contains(delimiter);
    }

    private boolean isSingleCharacterDelimiter(String delimiter){
        return delimiter.length() == 1;
    }

    private boolean isNumeric(String delimiter){
        try{
            Double.parseDouble(delimiter);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
