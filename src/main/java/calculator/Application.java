package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int result = 0;

        String input = Console.readLine();
        ArrayList <String> delimiters = new ArrayList<>(Arrays.asList(",",":"));
        // 재사용성을 위해 값을 유동적으로 추가할 수 있는 리스트로 설정

        // 공백이 입력된 경우(입력값이 없는 경우)
        if (input.isEmpty()){
            System.out.println(result);
            return;
        }

        // 단일 숫자가 입력된 경우
        if (input.matches("[-+]?[0-9]+")){
            System.out.println(Integer.parseInt(input));
            return;
        }

        // 커스텀 구분자 확인 및 저장
        if (input.length() >=2 && input.charAt(0) =='/' && input.charAt(1) == '/'){
            try{
                if (!input.contains("\\n")){
                    throw new IllegalArgumentException("입력 문자열에 \\n문자가 포함돼있지 않습니다");
                }
                int index = input.indexOf("\\n");
                String new_delimiter = input.substring(2,index);
                input = input.substring(index+2);
                delimiters.add(new_delimiter);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.exit(1); // 애플리케이션 종료
            }

        }

        String splitPattern = String.join("|",delimiters); // 예시 : ",|:|;"
        String[] arr = input.split(splitPattern); // splitPattern 안에 구분자들을 기준으로 분리함

        try {
            for (String a : arr) {
                if (!a.matches("[-+]?[0-9]+")) {
                    throw new IllegalArgumentException("잘못된 숫자 형식:" + a); // 분리된 arr 안에 값들이 정수인지 확인
                }
                result += Integer.parseInt(a);
            }
            System.out.println(result); // 결과 출력!(성공)

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}