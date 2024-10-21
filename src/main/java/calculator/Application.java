package calculator;


import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
//        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String s = Console.readLine(); // Input \n

        if(s.isEmpty()){
            System.out.println("결과 : 0");
            return;
        }

//         ; ,가 구분자 그리고 //과 \n 사이에 있는 문자열이 커스텀 구분자
//         정규식 패턴 설정
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(s);

        // 패턴 매칭 확인
        if (matcher.find()) { // 빈 문자열
//            // 매칭된 그룹(사이의 문자열) 추출
            String delimeter = matcher.group(1);
            String[] delimeters = delimeter.split(",");
            s = s.replace(matcher.group(0), ""); // delete custom
            s = s.trim();

            for(String delime : delimeters){
                s = s.replaceAll(delime,","); // custum
            }

            String[] nums = s.split("[:," + "]");

            if(!areAllDigit(nums)){
                throw new IllegalArgumentException();
            }


            int sum = 0;
            for(String num : nums) {
                int tmp = Integer.parseInt(num);
                if(tmp<0){
                    throw new IllegalArgumentException();
                }
                sum += tmp;
            }
            // //ab\n1ab2ab3:4,5
            // 커스텀 문자가 2개 이상이라면
            //
            System.out.println("결과 : " + sum);
        } else { // custom delimeter가 없을 떄

            s = s.trim();
            String[] nums = s.split("[" + ":,"+ "]");

            if(!areAllDigit(nums)){
                throw new IllegalArgumentException();
            }

            int sum = 0;
            for(String num : nums) {
                int tmp = Integer.parseInt(num);
                if(tmp<0){
                    throw new IllegalArgumentException();
                }
                sum += tmp;
            }
            System.out.printf("결과 : %d", sum);
        }
    }

        // 1. parsing : 주어진 s에 대해서 커스텀 delimiter가 있는지 확인한다. -> YES
                     // -> No -> , 과 ;에 대해서만 split을 진행한다.
        // 2. sum

    static boolean areAllDigit(String[] nums) {
        for (int i = 0; i < nums.length; i++) {
            char[] charArray = nums[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                if (!Character.isDigit(charArray[j])) {
                    return false; // 숫자가 아닌 문자가 발견되면 false 반환
                }
            }
        }
        return true; // 모든 문자가 숫자일 경우 true 반환
    }
//        throw new IllegalArgumentException();
}
