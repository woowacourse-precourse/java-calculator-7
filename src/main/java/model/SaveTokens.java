package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveTokens {
    private static final String ERROR_MESSAGE = "오류가 발생하였습니다.";
    private static final String UNEXPECTABLE_ERROR_MESSAGE = "예상치 못한 에러가 발생했습니다.";

    public String[] saveTokens(String input){
        input = input.replace("\\n", "\n");


        if (input.startsWith("//")) {
            String regex = "//(.)\n(.*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String distinguisher = Pattern.quote(matcher.group(1));
                String newInput = matcher.group(2);

                return newInput.split(distinguisher);
            }
        } else if(input.contains(",") || input.contains(":")){
            return input.split("[,:]");
        }else{
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        throw new IllegalArgumentException(UNEXPECTABLE_ERROR_MESSAGE);
    }
}
