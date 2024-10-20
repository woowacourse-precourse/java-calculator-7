package calculator.util;

import calculator.dto.CalculatorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class ExceptionUtil {

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

    public static int checkNextTargetIsLiteral(String str) throws IllegalArgumentException {
        try{
            int target = Integer.parseInt(str);
            if(target > 0){
                return target;
            }else{
                throw new IllegalArgumentException("ERR : 양수가 아닌 값이 포함되어 있습니다.");
            }
        }catch (NumberFormatException e) { // 정수가 아닌 경우  Integer.parseInt에서 발생하는 에러
            throw new IllegalArgumentException("ERR : 계산할수 없는 대상이 포함되어 있습니다.");
        }
    }

    public static void checkStringHasRightNumOfTarget(CalculatorDTO calculatorDTO) throws IllegalArgumentException{
        String str = calculatorDTO.getStr();
        String delim = calculatorDTO.getDelim();

        if(calculatorDTO.hasCustomDelim()){
            int numOfDelim = 0;

            Pattern p = compile(quote(delim));
            Matcher m = p.matcher(str);

            while (m.find()) {
                numOfDelim++;
            }

            int numOfTarget = str.split(quote(delim)).length;

            if(numOfTarget - numOfDelim != 1 )
                throw new IllegalArgumentException("ERR : 계산 대상의 개수가 이상합니다.");

        }else{
            int numOfDelim = 0;

            Pattern p = compile(quote(","));
            Matcher m = p.matcher(str);
            while (m.find()) {
                numOfDelim++;
            }

            p = compile(quote(":"));
            m = p.matcher(str);
            while (m.find()) {
                numOfDelim++;
            }

            StringTokenizer st = new StringTokenizer(str, delim);
            int numOfTarget = 0;
            while (st.hasMoreTokens()){
                st.nextToken();
                numOfTarget++;
            }

            if(numOfTarget - numOfDelim != 1 )
                throw new IllegalArgumentException("ERR : 계산 대상의 개수가 이상합니다.");
        }
    }
}
