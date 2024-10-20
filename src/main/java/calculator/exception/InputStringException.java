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
            throw new IllegalArgumentException("커스텀 지정방식이 잘못됐습니다.");
        }
        String checkInputString = inputString.substring(startIdx+2, endIdx);
        if(!(startIdx ==0 && endIdx == 3 && checkInputString.length()==1 && !Character.isDigit(checkInputString.charAt(0)))){
            throw new IllegalArgumentException("커스텀 지정방식이 잘못됐습니다.");
        }
    }

    public static void validateInputInStandardFormat(Delimiters delimiters, String inputString){
        if(inputString.contains("//") && inputString.contains("\\n")){
            inputString = inputString.substring(5);
        }
        LinkedList<Character> delimitersList = delimiters.getDelimeterCollections();
        for(int i=0;i<inputString.length();i++){
            if(Character.isDigit(inputString.charAt(i))) continue;
            validateIfCharIncludedInCollections(delimitersList, inputString, i);
            validateCharInBetweenStartAndEnd(inputString, i);
            validateIfDelimitersInBetweenNumbers(inputString, i);
        }
    }
    public static void validateIfCharIncludedInCollections(LinkedList<Character> delimitersList, String inputString, int index){
        if(!delimitersList.contains(inputString.charAt(index))){
            throw new IllegalArgumentException("구분자와 숫자 이외의 문자가 있습니다.");
        }
    }
    public static void validateCharInBetweenStartAndEnd(String inputString, int index){
        if(!(index>0 && index<inputString.length()-1)){
            throw new IllegalArgumentException("구분자는 맨 앞과 맨 끝에 존재할 수 없습니다.");
        }
    }
    public static void validateIfDelimitersInBetweenNumbers(String inputString, int index){
        if(!(Character.isDigit(inputString.charAt(index-1)) && Character.isDigit(inputString.charAt(index+1)))){
            throw new IllegalArgumentException("구분자가 숫자와 숫자 사이에 존재하지 않습니다.");
        }
    }


    public static Numbers checkIfNumeric(String inputString, Numbers numbers){
        LinkedList<String> stringNumbers = extractService.extractStringNumbers(inputString);
        for(String s : stringNumbers){
            if(s.isEmpty()) continue;
            checkNumberFormat(s);
            checkIfNumberIsInteger(s);
            checkIfPositiveNumber(s);
        }
        return extractService.addStringNumberToNumbers(stringNumbers, numbers);
    }

    public static void checkNumberFormat(String stringNumber){
        if(stringNumber.length() !=1 && stringNumber.charAt(0)=='0'){
            throw new IllegalArgumentException("숫자의 형태가 아닙니다.");
        }
    }

    public static void checkIfNumberIsInteger(String stringNumber){
        try{
            int tmpNumber = Integer.parseInt(stringNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("입력된 숫자는 2,147,483,647보다 작아야 합니다.");
        }
    }

    public static void checkIfPositiveNumber(String stringNumber){
        if(Integer.parseInt(stringNumber) <=0){
                throw new IllegalArgumentException("숫자가 양수가 아닙니다.");
        }
    }
}
