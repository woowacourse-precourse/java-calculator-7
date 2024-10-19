package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        //입력값 받기 위한 메시지 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        //입력값 받기
        String input = Console.readLine();

        input = input.replace("\\n", "\n");

        //입력값이 null이거나, 비어있을 경우 0 반환
        if (input == null || input.isEmpty()) {
            System.out.println(0);

            // input 값이 // 으로 시작한다면
        } else if (input.startsWith("//")) {

            // \n 이 시작하는 인덱스 값 저장
            int targetIndex = input.indexOf('\n');

            // \n으로 끝나지 않는다면 예외처리
            if (targetIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");

            } else {
                // 저장한 인덱스 값의 위치까지 지정해, 설정한 구분자 저장
                String custom = input.substring(2, targetIndex);

                // 이후의 숫자를 numbers 배열에 저장
                String numbers = input.substring(targetIndex + 1);

                //백슬래시가 포함된 구분자를 이스케이프로 처리
                if (custom.contains("\\")) {
                    custom = custom.replace("\\", "\\\\");
                }

                // 설정한 구분자를 바탕으로 숫자들을 splitedNumber 배열에 저장
                String[] splitedNumber = numbers.split(custom);
                int customSum = 0;

                // for 문을 사용하여 splitedNumber에 있는 숫자를 더해 값을 저장
                for (String s : splitedNumber) {
                    int changedNumber = Integer.parseInt(s);

                    //입력 값이 음수일 경우 IllegalArgumentException 발생
                    if (changedNumber < 0) {
                        throw new IllegalArgumentException();
                    }
                    customSum += changedNumber;
                }
                // 더한 합 출력
                System.out.println("결과 : " + customSum);
            }
            // input 값이 // 으로 시작하지 않는다면
        } else {
            // 쉼표나 콜론을 구분자로 가지는 문자열을 전달 하는 경우, 숫자를 splited 배열에 저장
            String[] splited = input.split("[,|:]");
            int sum = 0;

            // for 문을 사용하여 저장되어있는 값 합을 구하기
            for (String s : splited) {
                int changedNumbers = Integer.parseInt(s);

                //입력 값이 음수일 경우 IllegalArgumentException 발생
                if (changedNumbers < 0) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(s);
            }

            //결과 출력
            System.out.println("결과 : " + sum);
        }


    }
}
