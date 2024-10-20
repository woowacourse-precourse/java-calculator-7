package calculator;

//입력한 문자열에서 숫자를 추출해서 더하는 계산기
import java.util.*;
public class TextNumber {

        int sum=0;
        public String calculatingNumberPlus(String inputStr){
            try {
                String insertText= inputStr.replaceAll("[^0-9]", "");
                for (char reverseNum : insertText.toCharArray()) {
                    if(Character.isDigit(reverseNum))
                        sum += Character.getNumericValue(reverseNum);
                }
                //      System.out.println();
            }catch(IllegalArgumentException e){
                System.out.println("잘못된 값을 입력하였습니다.");
            }
            return "결과 : "+sum;
        }
}

