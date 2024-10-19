package calculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 구분자와 관련된 유틸리티 클레스
 */
public class NumberUtils {

    /**
     * 구분자가 포함된 숫자열을 구분자 리스트를 이용하여 제거하고 반환한다
     *
     * @throws IllegalArgumentException
     * 구분자를 기준으로 쪼갠 문자열이 숫자의 형식이 아니라면 반환
     *
     * @param numbers 구분자가 포함된 숫자열
     * @param separators 구분자 모음
     *
     * @return 숫자들의 리스트
     */
    public static List<Integer> parseNumbers(final String numbers, final List<Character> separators) {
        final List<Integer> numbersList = new ArrayList<>();
        final StringBuilder sb = new StringBuilder();

        //numbers가 빈 문자열이면 0을 리턴
        if(numbers.isEmpty()) {
            return List.of(0);
        }

        for(int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);

            //구분자인가?
            if(separators.contains(c)) {
                numbersList.add(stringToNumber(sb));
                //StringBuilder초기화
                sb.setLength(0);
                continue;
            }
            //구분자가 아니라면 StringBuilder에 넣기
            sb.append(c);
        }

        //sb에 남은 문자처리
        numbersList.add(stringToNumber(sb));

        return numbersList;
    }

    /**
     * 문자열을 숫자로 변환한다
     *
     * @param sb 문자열을 stringbuilder로 받는다
     * @return 변환된 숫자
     */
    private static int stringToNumber(final StringBuilder sb) {
        String num = sb.toString();

        //숫자의 형식이 올바른지 체크 후 numbersList에 넣기
        try {
            //우테코 기능 요구 사항에 따르면 빈 문자열은 0으로 취급
            if(num.equals("")) {
                return 0;
            } else {
                //검증코드
                return Integer.parseInt(num);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자의 형식이 잘못되었습니다");
        }
    }
}
