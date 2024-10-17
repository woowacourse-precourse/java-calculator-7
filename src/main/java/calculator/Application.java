package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        if(!checkEmpty(string)){
            System.exit(1);
        }
    }

    static boolean checkEmpty(String string){
        try {
            if(string == null || string.trim().equals("")){
                throw new IllegalArgumentException("IllegalArgumentException 발생");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
