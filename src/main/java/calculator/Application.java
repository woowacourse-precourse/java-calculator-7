package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Application {

    static String[] setDelimiter( String input ){
        StringTokenizer tokenizer = new StringTokenizer( input, "\\n" );
        if( tokenizer.countTokens() > 1 ){
            String[] delimiterList = { tokenizer.nextToken().substring(2), ",", ":" };
            return delimiterList;
        }
        String[] delimiterList = { ",", ":" };
        return delimiterList;
    }

    public static void main(String[] args) {
        int result = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
            System.out.println( "덧셈할 문자열을 입력해 주세요." );
            String input = bufferedReader.readLine();
            String[] delimiterList = setDelimiter( input );


            System.out.println( "결과: " + result );
            bufferedReader.close();
        } catch (IOException e ){
            e.printStackTrace();
        }
    }
}
