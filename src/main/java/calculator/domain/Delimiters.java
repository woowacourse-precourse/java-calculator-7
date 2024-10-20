package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {
    private final String CUSTOM_DELIMITER_START_SEPARATOR = "//";
    private final String NO_CUSTOM_DELIMITER = "";
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
            String regex = "^//(.*)\\\\n(.*)";

            Pattern pattern = Pattern.compile(regex);
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

    public void validateDelimiter(String delimiter){
        if(!isSingleCharacterDelimiter(delimiter)){
            throw new IllegalArgumentException("구분자는 길이가 1인 문자여야 합니다.");
        }

        if(isNumeric(delimiter)){
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다.");
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
