package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr;
        String convertedStr;
        inputStr = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println(inputStr);

        // 구분자 1차 병합 (":" -> ",")
        convertedStr = inputStr.replace(":",",");
        StringBuilder entireStr = new StringBuilder(convertedStr);

    }
}
