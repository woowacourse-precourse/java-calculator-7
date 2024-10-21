package calculator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        try {
            input = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] inputArray = input.split("[,;]");
        int num = 0;
        for (String s : inputArray) {
            num += Integer.parseInt(s);
        }

        System.out.println(num);
    }
}
