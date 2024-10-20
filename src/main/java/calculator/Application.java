package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();


        // 공백이 입력된 경우(입력값이 없는 경우)
        if (input.isBlank()){
            System.out.println("결과 : "+result);
            return;
        }

        // 단일 숫자가 입력된 경우
        if (input.matches("[0-9]+")){
            System.out.println("결과 : "+Integer.parseInt(input));
            return;
        }

        // 커스텀 구분자 확인 및 저장
        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            if (index == -1) {
                throw new IllegalArgumentException("입력 문자열에 \\n 문자가 포함돼있지 않습니다.");
            }
            String new_delimiter = input.substring(2, index);
            input = input.substring(index + 2).replace(new_delimiter, ",");
        }
        String[] arr = input.split("[,:]"); // splitPattern 안에 구분자들을 기준으로 분리함

        try {
            for (String a : arr) {
                if (!a.matches("[0-9]+")) {
                    throw new IllegalArgumentException("잘못된 숫자 형식:" + a); // 분리된 arr 안에 값들이 정수인지 확인
                }
                result += Integer.parseInt(a);
            }
            System.out.println("결과 : "+result); // 결과 출력!(성공)

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}