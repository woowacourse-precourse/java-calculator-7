package calculator.service;

import calculator.dto.OperandDTO;
import java.util.ArrayList;

import static calculator.utils.Constants.*;
import static calculator.validators.InvalidInputStringFormatException.errorCheck;

public class ParsingService {
    public static OperandDTO parseOperandStr(String operandStr) {
        ArrayList<Character> delimiters = new ArrayList<>();
        ArrayList<Integer> operandList = new ArrayList<>();

        addDefaultDelimiters(delimiters);

        if(checkIFStringEmpty(operandStr)){
            operandList.add(0);
            return new OperandDTO(operandList);
        }
        errorCheck(operandStr);
        operandStr = parseCustomDelimiter(operandStr, delimiters);

        parse(operandStr, delimiters, operandList);

        return new OperandDTO(operandList);
    }

    public static void addDefaultDelimiters(ArrayList<Character> delimiters) {
        delimiters.add(DEFAULT_DELIMITER1);
        delimiters.add(DEFAULT_DELIMITER2);
    }

    //입력받은 문자열이 없을 때 true return
    private static Boolean checkIFStringEmpty(String operandStr){
        if(operandStr.isEmpty()) return true;
        return false;
    }

    //구분자에 따라 문자열을 분리하는 기능
    private static void parse(String operandStr, ArrayList<Character> delimiters, ArrayList<Integer> operandList){
        StringBuilder sb = new StringBuilder();
        //구분자로 구분
        for(char ch : operandStr.toCharArray()){
            if(delimiters.contains(ch) && !sb.isEmpty()){
                operandList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
            else if(delimiters.contains(ch) && sb.isEmpty()){
                throw new IllegalArgumentException();
            }
            else {
                checkInteger(ch);
                sb.append(ch);
            }
        }
        operandList.add(Integer.parseInt(sb.toString()));
    }

    private static String parseCustomDelimiter(String operandStr, ArrayList<Character> delimiters){
        //custom 구분자 추출
        if(operandStr.startsWith("//")){
            delimiters.add(operandStr.charAt(CUSTOM_DELIMITER_INDEX));
            operandStr = operandStr.substring(EXCEPT_CUSTOM_DELIMITER_INDEX);
        }
        return operandStr;
    }

    private static String createRegexFromDelimiters(ArrayList<Character> delimiters){
        StringBuilder regexBuilder = new StringBuilder("[");
        for(char ch : delimiters){
            regexBuilder.append(ch);
        }
        regexBuilder.append("]");
        return regexBuilder.toString();
    }

    private static void checkInteger(char ch){
        if(!Character.isDigit(ch))
            throw new IllegalArgumentException();
    }
}
