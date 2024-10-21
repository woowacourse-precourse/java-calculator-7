package calculator;

public class Application {
    public static void main(String[] args) {
        String separator = "[,;]";
        String str;
        String[] operand;

        //문자열 입력받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //구분자 분리
        operand = str.split(separator);

    }
}
