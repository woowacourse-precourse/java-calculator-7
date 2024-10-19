package calculator.exception;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.service.ExtractService;

import java.util.LinkedList;

public class InputStringException {
    private static final ExtractService extractService = new ExtractService();
    public Numbers validateInputPattern(String inputString, Numbers numbers, Delimiters delimiters){
        if(inputString.contains("//") || inputString.contains("\\n")) {
            isCustomDelimiterDeclaredInStandardFormat(inputString);
            extractService.extractDelimeter(inputString, delimiters);
        }
        validateInputInStandardFormat(delimiters, inputString);

        return checkIfNumeric(inputString, numbers);
    }

    public static void isCustomDelimiterDeclaredInStandardFormat(String inputString){
        int startIdx = inputString.indexOf("//");
        int endIdx = inputString.lastIndexOf("\\n");
        if(startIdx == -1 || endIdx == -1){
            throw new IllegalArgumentException();
        }
        String checkInputString = inputString.substring(startIdx+2, endIdx);
        if(!(startIdx ==0 && endIdx == 3 && checkInputString.length()==1 && !Character.isDigit(checkInputString.charAt(0)))){
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputInStandardFormat(Delimiters delimiters, String inputString){
        if(inputString.contains("//") && inputString.contains("\\n")){
            inputString = inputString.substring(5);
        }
        LinkedList<Character> delimitersList = delimiters.getDelimeterCollections();
        for(int i=0;i<inputString.length();i++){
            if(Character.isDigit(inputString.charAt(i))) continue;
            if(!delimitersList.contains(inputString.charAt(i))){
                throw new IllegalArgumentException("");
            }
            if(!(i>0 && i<inputString.length()-1)){
                throw new IllegalArgumentException("");
            }
            if(!(Character.isDigit(inputString.charAt(i-1)) && Character.isDigit(inputString.charAt(i+1)))){
                throw new IllegalArgumentException("");
            }
        }
    }

    public static Numbers checkIfNumeric(String inputString, Numbers numbers){
        LinkedList<String> stringNumber = extractService.extractNumbers(inputString);
        for(String s : stringNumber){
            if(s.isEmpty()) continue;
            if(s.length() !=1 && s.charAt(0)=='0'){
                throw new IllegalArgumentException();
            }
            if(Integer.parseInt(s) <=0){
                throw new IllegalArgumentException();
            }
        }
        for(int i=0;i<stringNumber.size();i++){
            if(stringNumber.get(i).isEmpty()) continue;
            numbers.getNumbersList().add(Integer.parseInt(stringNumber.get(i)));
        }
        return numbers;
    }
}
