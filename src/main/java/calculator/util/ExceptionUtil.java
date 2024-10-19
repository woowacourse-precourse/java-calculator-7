package calculator.util;

import calculator.dto.CalculatorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ExceptionUtil {

    public static void checkParameterIsLiteral(CalculatorDTO calculatorDTO) throws IllegalArgumentException{
        String str = calculatorDTO.getStr();
        String delim = calculatorDTO.getDelim();
        String[] checkList;

        if(calculatorDTO.hasCustomDelim()){
            String escapeCustomDelimiter = Pattern.quote(delim);
            checkList = str.split(escapeCustomDelimiter);
        }else{
            // Default Delimiter 처리 (StringTokenizer 사용)
            List<String> tokens = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(str, delim);

            // 각 토큰을 리스트에 저장
            while (st.hasMoreTokens()) {
                tokens.add(st.nextToken());
            }

            // 리스트를 배열로 변환
            checkList = tokens.toArray(new String[0]);
        }

        try{
            for (String s : checkList) {
                int num = Integer.parseInt(s);
                if(num < 0){
                    throw new IllegalArgumentException("ERR : 잘못된 인자값 입니다.");
                }
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("ERR : 잘못된 인자값 입니다.");
        }

    }

    public static void checkParamsIsNotEmpty(String str) throws IllegalArgumentException {
        if(str.startsWith("//")){ // 커스텀 구분자를 가지는 경우
            String[] strList = str.split("\\\\n");

            // 문자열이 비어있는지를 검사
            if(strList.length != 2 ){
                throw new IllegalArgumentException("ERR : 계산을 위한 대상이 존재하지 않습니다. ");
            }

            // 구분자가 비어있는지를 검사
            if(Objects.equals(strList[0], "//")){
                throw new IllegalArgumentException("ERR : 커스텀 구분자가 존재하지 않습니다. ");
            }


        }else{ // 커스텀 구분자를 가지지 않는 경우
            if(str.isEmpty()){ // 문자열이 비어있는지를 검사
                throw new IllegalArgumentException("ERR : 계산을 위한 대상이 존재하지 않습니다. ");
            }
        }
    }
}
