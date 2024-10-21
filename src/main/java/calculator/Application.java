package calculator;

public class Application {
    public static void main(String[] args) {
        String str;

        //문자열 입력받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
