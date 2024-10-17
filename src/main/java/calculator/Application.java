package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int idx = -1;
        int end = -1;
        boolean custom = false;
        ArrayList<Character> separate = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        String substr = str;

        //입력이 비어있는 경우
        if (str == null || str.isEmpty()) {
            number.add(0);
        } else {
            //커스텀 구분자라면
            if(str.contains("//")){
                idx = str.indexOf("//") + 2;
                for(int i = idx; i<str.length() - 1; i++){
                    if(str.charAt(i) == '\\' && str.charAt(i+1) == 'n'){
                        end = i;
                        custom = true;
                        break;
                    }
                }

                // "//"로 시작하지만 "\n"이 없음
                if(!custom){
                    throw new IllegalArgumentException("잘못된 입력: '//'로 시작하지만 '\n'으로 끝나지 않습니다.");
                }

                else if(custom && idx == end){
                    throw new IllegalArgumentException("잘못된 입력: 커스텀 구분자가 존재하지 않습니다.");
                }

                //커스텀구분자 넣기
                separate.add(str.charAt(idx));
            }
        }

        //구분자 제외하고 숫자만 추출
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[,:");
        for(Character c : separate){
            stringBuilder.append(c);
        }
        stringBuilder.append("]");

        //커스텀구분자
        if(custom){
            //커스텀구분자 지정 구문 제외하고 새로 String 구성
            substr = str.substring(end+2);
        }
        String[] token = substr.split(stringBuilder.toString());


        for (String s : token) {
            if (!s.isEmpty()) {
                try {
                    int num = Integer.parseInt(s);

                    if(num < 0){
                        throw new IllegalArgumentException("잘못된 입력: 음수가 포함되었습니다.");
                    }

                    number.add(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력: 숫자가 아닙니다.");
                }
            }
        }

        int sum = number.stream().mapToInt(Integer::intValue).sum();
        System.out.println("결과 : " + sum);
    }
}