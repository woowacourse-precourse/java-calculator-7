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

        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }

        String[] inputArray;
        int num = 0;

        if (input.startsWith("//")) {
            int endIdx = input.indexOf("\\n");
            String separator = input.substring(2, endIdx);
            inputArray = input.substring(endIdx + 2).split(separator);
        } else {
            inputArray = input.split("[,:]");
        }

        for (String s : inputArray) {
            num += Integer.parseInt(s);
        }

        System.out.println(num);
    }
}
