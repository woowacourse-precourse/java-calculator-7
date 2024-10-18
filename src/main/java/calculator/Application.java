package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // camp.nextstep.edu.missionutils.Console에 readLine 함수 호출. nextLine() 고정.
//        System.out.println(input);
        
        String customDelimiter = "[,:]";
        if (input.startsWith("//")) {
            int indexOfDoubleSlash = input.indexOf("//");
            int indexOfReveredSlashN = input.indexOf("\\n");
//            System.out.println("\\n의 인덱스 : " + indexOfReveredSlashN);
            customDelimiter = input.substring(indexOfDoubleSlash + 2,
                    indexOfReveredSlashN);
//            System.out.println(customDelimiter);
            input = input.substring(indexOfReveredSlashN + 2);
//            System.out.println("3 : " + input);
        }

//        System.out.println(customDelimiter);
        String[] split = input.split(customDelimiter + "|[,:]");
        int result = 0;
        try {
            for (String s : split) {
                result += Integer.parseInt(s);
            }
        } catch (Exception e) {
//            System.err.println(e.getMessage());
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다 : " + e.getMessage());
        }
        System.out.println("결과 : " + result);
    }
}
