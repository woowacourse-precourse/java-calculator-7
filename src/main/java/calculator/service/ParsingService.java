package calculator.service;

import calculator.dto.OperandDTO;
import java.util.ArrayList;

import static calculator.utils.Constants.*;
import static calculator.utils.InvalidInputStringFormatException.errorCheck;

public class ParsingService {
    private ArrayList<Character> delimiters = new ArrayList<>();
    private ArrayList<Integer> operandList = new ArrayList<>();

    public ParsingService() {
        delimiters.add(DEFAULT_DELIMITER1);
        delimiters.add(DEFAULT_DELIMITER2);
    }

    public OperandDTO parseOperandStr(String operandStr) {
        if(checkIFStringEmpty(operandStr)){
            operandList.add(0);
            return new OperandDTO(operandList);
        }
        errorCheck(operandStr);
        parse(operandStr);

        return new OperandDTO(operandList);
    }

    //입력받은 문자열이 없을 때 true return
    private static Boolean checkIFStringEmpty(String operandStr){
        if(operandStr.isEmpty()) return true;
        return false;
    }

    private void parse(String operandStr){
        //custom 구분자 추출
        if(operandStr.startsWith("//")){
            delimiters.add(operandStr.charAt(CUSTOM_DELIMITER_INDEX));
            operandStr = operandStr.substring(EXCEPT_CUSTOM_DELIMITER_INDEX);
        }

        StringBuilder sb = new StringBuilder();
        //구분자로 구분
        for(char ch : operandStr.toCharArray()){
            if(delimiters.contains(ch) && !sb.isEmpty()){  //구분자 바로 다음에 또 구분자 나온다면 error
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

    private static void checkInteger(char ch){
        if(!Character.isDigit(ch))
            throw new IllegalArgumentException();
    }
}
