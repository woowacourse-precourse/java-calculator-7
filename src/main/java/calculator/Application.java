package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Application {

    static String[] setDelimiter( StringTokenizer tokenizer ){
        if( tokenizer.countTokens() > 1 ){
            String[] delimiterList = { tokenizer.nextToken().substring(2), ",", ":" };
            return delimiterList;
        }
        String[] delimiterList = { ",", ":" };
        return delimiterList;
    }

    static int[] getNumbers( StringTokenizer tokenizer, String[] delimiterList ){
        if( tokenizer.countTokens() > 1 ){ tokenizer.nextToken(); }
        String numString = tokenizer.nextToken();
        String regex = String.join( "|", delimiterList );
        Pattern pattern = Pattern.compile( regex );
        String[] nums = pattern.split( numString );
        int[] result = new int[nums.length];
        for( int i = 0; i < nums.length; i++ ){
            result[i] = Integer.parseInt( nums[i] );
        }
        return result;
    }

    static int sum( int[] numbers ){
        int result = 0;
        for( int num : numbers ){
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
            System.out.println( "덧셈할 문자열을 입력해 주세요." );
            String input = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer( input, "\\n" );
            String[] delimiterList = setDelimiter( tokenizer );
            int[] numbers = getNumbers( tokenizer, delimiterList );
            result = sum( numbers );
            System.out.println( "결과: " + result );
            bufferedReader.close();
        } catch (IOException e ){
            e.printStackTrace();
        }
    }
}
