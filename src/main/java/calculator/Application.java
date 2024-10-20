package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 사용자 입력 받기
        System.out.println("구분자와 양수 구성된 문자열을 입력해 주세요.");
        String input = Console.readLine();

        //빈 문자열 또는 null이 입력된 경우 0을 반환
        if(input == null || input.equals("")) {
            System.out.println("0");
            return;
        }
        //쉼표 or 콜론을 구분자로 숫자 추출 후 합산
        String delimiter = ",|:";
        String[] numbers = input.split(delimiter);

        //커스텀 구분자 처리
        if (input.length() > 2 && input.charAt(0) == '/' && input.charAt(1) == '/') {
            int nindex = input.indexOf("\n");
            delimiter = delimiter + "|" + input.substring(2, nindex);
            numbers = (input.substring(nindex+1)).split(delimiter);



        }

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }

        //테스트용 결과 출력
        System.out.println(sum);







    }
}
