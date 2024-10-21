package calculator;

public class Application {
    public static void main(String[] args) {
        String separator = "[,;]";
        String str;
        String[] operand;
        int sum = 0;

        //문자열 입력받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = reader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
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
        System.out.println("결과: " + sum);
    }
}
