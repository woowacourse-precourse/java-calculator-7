package calculator.model;

import static calculator.validation.ErrorMessage.INVALID_DELIMITER;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    private String userInput;
    private final static String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER_SEPARATOR = "//(.)\n(.*)";
    private final static int CUSTOM_PATTERN_DELIMITER_INDEX = 1;
    private final static int CUSTOM_SPLIT_DELIMITER_INDEX = 2;


    public Model(String userInput){
        this.userInput = userInput;
    }
    public String getUserInput(){
        return userInput;
    }
    public  boolean isValidationCheckNullOrEmpty(String text){
        return text == null || text.trim().isEmpty();
    }

    public String[] userInputSplit(String text){
        text = text.replace("\\n","\n");
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_SEPARATOR).matcher(text);
        if(m.find()){
            String customDelimiter = m.group(CUSTOM_PATTERN_DELIMITER_INDEX);
            return m.group(CUSTOM_SPLIT_DELIMITER_INDEX).split("[" + customDelimiter + DEFAULT_DELIMITER + "]");
        }
        return text.split("[,:]");
    }

    public int calculateSum(String[] tokens) {
        // 모든 토큰을 숫자로 변환하고 합산
        return Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .mapToInt(Model::stringToInt)
                .sum();
    }
    public static int stringToInt(String token){
        try{
            return Integer.parseInt(token);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_DELIMITER.format());
        }
    }


}
