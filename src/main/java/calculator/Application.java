package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    static String[] setDelimiter( String input ) {
        StringBuffer sb = new StringBuffer( input );
        String[] delimiterList = { input.split( "\n", 2 )[0].substring(2), ",", ":" };
        return delimiterList;
    }

    public static void main(String[] args) {
        int result = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
            String input = bufferedReader.readLine();
            String[] dellimiterList = setDelimiter( input );

            System.out.println( result );
            bufferedReader.close();
        } catch (IOException e ){
            e.printStackTrace();
        }
    }
}
