package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    //문자열이 비었거나 null인 경우 0을 반환하고 프로그램을 끝내기 위해 생성
    public static boolean isBlankOrNull(String sentence){
        return sentence.isBlank() || sentence == null;
    }

    public static boolean isCustomLetter(String str){
        char firstLetter = str.charAt(0);
        //:와 ,로 구분되는 경우
        if(firstLetter == ':' || firstLetter == ',' || Character.isDigit(firstLetter)){
            return false;
        }
        //커스텀 구분자를 쓰는 경우
        else if(firstLetter == '/') {
            return true;
        }
        //잘못된 입력
        throw new IllegalArgumentException("[extractLetter] 잘못된 입력");
    }

    public static String extractCustomLetter(String str){
        if(str.length() > 2){
            return str.substring(2);
        }

        throw new IllegalArgumentException("[extractCustomLetter] 잘못된 입력");
    }

    public static List<Integer> extractNum(String str){
        String letter = ":|,";
        String numStr = str;
        List<Integer> nums = new ArrayList<>();

        if(isCustomLetter(str)){
            letter = extractCustomLetter(str);
            numStr = Console.readLine();
        }
        StringTokenizer st = new StringTokenizer(numStr, letter);

        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }

        return nums;
    }

    public static long plusNums(List<Integer> nums){
        long result = 0;

        for(int i = 0; i<nums.size(); i++){
            result += nums.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        long result = 0;
        List<Integer> nums;

        if(!isBlankOrNull(str)){
            nums = extractNum(str);
            result = plusNums(nums);
        }

        System.out.println("결과 : " + result);


    }
}
