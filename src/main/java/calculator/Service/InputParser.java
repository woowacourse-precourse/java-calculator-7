package calculator.Service;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private String input;
    private List<String> customSeparator = new ArrayList<>();

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

            String separatorPart = input.substring(2,customEndIdx);

            for(char ch : separatorPart.toCharArray()){
                customSeparator.add(escapeSpecialCharacter(String.valueOf(ch)));
            }

            input = input.substring(customEndIdx + 2);
        }
    }

    private String escapeSpecialCharacter(String separator){
        if("\\.[]{}()^$?*+|".contains(separator)){
            return "\\"+separator;
        }
        return separator;
    }

    public String[] getTokens(){

        if(input == null || input.trim().isEmpty()){
            return new String[0];
        }

        String tokenSeparator = createTokenSeparator();

        return input.split(tokenSeparator);
    }

    public String createTokenSeparator(){
        StringBuilder separatorPattern = new StringBuilder();

        String defaultSeparator = ",|:";

        separatorPattern.append(defaultSeparator);

        for(String custom: customSeparator){
            separatorPattern.append("|").append(custom);
        }


        return separatorPattern.toString();
    }
}
