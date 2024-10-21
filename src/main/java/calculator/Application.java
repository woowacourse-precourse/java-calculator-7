package calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자에게서 입력값 받기
        String inputValue = Console.readLine();
        System.out.println("inputValue: "+ inputValue);

        // 2. 입력값에서 기본 구분자(쉼표, 콜론)를 통해 숫자를 추출하는 기능
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] nums={};


        if (inputValue.length()>1) {
            // 2-2. 커스텀 구분자를 지정한 경우를 판단하는 기능
            if (inputValue.startsWith("//")) {
                if (inputValue.contains("\\n")){
                    inputValue=inputValue.substring(2);
                    String[] parts = inputValue.split("\\\\n");
//
//                    parts[0]
                }else{
                    System.out.println("??2");
                    nums = inputValue.split(",|:");
                }
            }else{
                nums = inputValue.split(",|:");
            }
        }



//        // 2-1. 입력값이 비어있을 경우 0만 추출
//        if (nums.length==0){
//            result.add(0);
//        } else{
//            for (String num: nums) {
//                result.add(Integer.parseInt(num));
//            }
//        }



    }
}
