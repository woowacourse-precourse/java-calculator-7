package calculator.Service;

import calculator.Interface.Parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser implements Parser {

    private String input;
    private final List<String> customSeparator = new ArrayList<>();
    private static final String END_OF_SEPARATOR = "\\n";
    private static final String SEPARATOR_PREFIX = "//";
    private static final String DEFAULT_SEPARATORS = ",|:";

    @Override
    public void setInput(String input){
        this.input = input;
    }

    @Override
    public void parseCustomSeparator(){

        if(input.startsWith(SEPARATOR_PREFIX)){
            int customEndIdx = input.indexOf(END_OF_SEPARATOR);

            String separatorPart = input.substring(2,customEndIdx);

            for(char ch : separatorPart.toCharArray()){
                customSeparator.add(escapeSpecialCharacter(String.valueOf(ch)));
            }

            input = input.substring(customEndIdx + 2);
        }
    }

    @Override
    public String[] getTokens(){

        if(input == null || input.trim().isEmpty()){
            return new String[0];
        }

        String tokenSeparator = createTokenSeparator();

        return input.split(tokenSeparator);
    }

    @Override
    public String createTokenSeparator(){
        StringBuilder separatorPattern = new StringBuilder();

        separatorPattern.append(DEFAULT_SEPARATORS);

        for(String custom: customSeparator){
            separatorPattern.append("|").append(custom);
        }

        return separatorPattern.toString();
    }

    private String escapeSpecialCharacter(String separator){

        if (separator.matches("\\d+")) {
            throw new IllegalArgumentException("구분자는 숫자가 될 수 없습니다: ");
        }

        if("\\.[]{}()^$?*+|".contains(separator)){
            return "\\"+separator;
        }
        return separator;
    }


}
