package calculator.Model;

import calculator.DTO.ParsedInputDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorModel {

    private String input;
    public String createTokenSeparator(String customSeparator){
        return customSeparator == null ? ",|:" : ",|:|" + Pattern.quote(customSeparator);
    }

    private ArrayList<String> createSeparatorList(){

        ArrayList<String> separators = new ArrayList<>();
        String customSeparator = getCustomSeparator();

        separators.add(",");
        separators.add(";");

        if(customSeparator != null){
            separators.add(customSeparator);
        }

        return separators;
    }

    private ArrayList<Integer> createNumberList(){

        ArrayList<Integer> numbers = new ArrayList<>();

        String tokenSeparator = createTokenSeparator(getCustomSeparator());

        String[] tokens = this.input.split(tokenSeparator);

        for(String token : tokens){
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    private String getCustomSeparator(){

        String customSeparator = null;

        if(input.startsWith("//")){
            int customEndIdx = input.indexOf("\n");
            int separatorLength = 1;

            if(customEndIdx == -1){
                customEndIdx = input.indexOf("\\n");
                separatorLength = 2;
            }

            customSeparator = input.substring(2, customEndIdx);
            input = input.substring(customEndIdx + separatorLength);

        }

        return customSeparator;
    }

    public ParsedInputDTO parseInput(String input){

        this.input = input;

        ArrayList<String> separators = createSeparatorList();
        ArrayList<Integer> numbers = createNumberList();

        return new ParsedInputDTO(separators, numbers);
    }

    public int addNumbers(ArrayList<Integer> numbers){
        int sum = 0;
        for(int num : numbers) sum += num;
        return sum;
    }


}
