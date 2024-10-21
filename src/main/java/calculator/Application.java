package calculator;

public class Application {
    public static void main(String[] args) {
        String separator = "[,:]";
        String str;
        String[] operand;
        int sum = 0;

        //문자열 입력받기
        try {
            str = camp.nextstep.edu.missionutils.Console.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        //커스텀 구분자
        if(str.matches("^//.{1}\\\\n.*")) {
            separator = separator.substring(0, separator.length()-1) + str.charAt(2) + "]";
            str = str.substring(5);
        }

        //구분자 분리
        operand = str.split(separator);

        //숫자 합 구하기
        try {
            for(String s : operand) {
                if (Integer.parseInt(s) < 0) throw new IllegalArgumentException();
                else sum += Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        //결과 출력하기
        System.out.println("결과 : " + sum);
    }
}
