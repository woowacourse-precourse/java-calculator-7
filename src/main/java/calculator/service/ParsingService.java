package calculator.service;

import calculator.dto.OperandDTO;
import java.util.ArrayList;

import static calculator.utils.Constants.*;
import static calculator.validators.InvalidInputStringFormatException.errorCheck;
import static calculator.validators.InvalidOperandFormatException.validateToken;

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
        String regex = createRegexFromDelimiters(delimiters);

        String[] tokens = operandStr.split(regex);
        for (String token : tokens) {
            operandList.add(validateToken(token));
        }
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
}
