package calculator.Service;

import java.util.regex.Pattern;

public class InputParser {

    private String input;
    private String customSeparator;

    public InputParser(String input){
        this.input = input;
        parseCustomSeparator();
    }

    private void parseCustomSeparator(){
        if(input.startsWith("//")){
            int customEndIdx = input.indexOf("\\n");
            if(customEndIdx == -1){
                throw new IllegalArgumentException("잘못된 입력");
            }

            customSeparator = input.substring(2,customEndIdx);
            input = input.substring(customEndIdx + 2);
        }
    }

    public String[] getTokens(){

        if(input == null || input.trim().isEmpty()){
            return new String[0];
        }

        String tokenSeparator = createTokenSeparator();
        return input.split(tokenSeparator);
    }

    public String createTokenSeparator(){

        String defaultSeparator = ",|:";

        if(customSeparator != null){
            return defaultSeparator + "|" + Pattern.quote(customSeparator);
        }

        return defaultSeparator;
    }
}
