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
        return sentence == null ||sentence.isBlank();
    }

    public static boolean isCustomLetter(String str){
        //:와 ,로 구분되는 경우
        if(str.startsWith(":") || str.startsWith(",") || Character.isDigit(str.charAt(0))){
            return false;
        }
        //커스텀 구분자를 쓰는 경우
        else if(str.startsWith("//") && str.length() > 4) {
            return true;
        }
        //잘못된 입력
        throw new IllegalArgumentException();
    }

    public static String extractLetter(String str){
        boolean isCustomLetter = isCustomLetter(str);
        if(isCustomLetter){
            // 구분자 다음에 반드시 \n이 있는지 확인
            String a = str.substring(3, 5); // 여기서 \n을 포함한 부분 추출
            if (!a.equals("\\n")) {
                throw new IllegalArgumentException("구분자 뒤에 줄바꿈 문자가 없습니다.");
            }
            // 구분자는 "//" 뒤에 있는 한 글자
            return str.substring(2, 3);
        }
        return ":|,";
    }

    public static List<Integer> extractNum(String str){
        String letter = extractLetter(str);
        List<Integer> nums = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(str, letter);

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
