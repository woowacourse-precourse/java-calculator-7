package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) {
        int result = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
            String input = bufferedReader.readLine();

            System.out.println( result );
            bufferedReader.close();
        } catch (IOException e ){
            e.printStackTrace();
        }
    }
}
