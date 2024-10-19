package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Application {
    static String[] setDelimiter( String input ){
        StringTokenizer tokenizer = new StringTokenizer( input, "\\n" );
        if( tokenizer.countTokens() > 1 ){
            String customDelimiter = "";
            if( !input.substring(2, 3).equals("\\") ) customDelimiter  = tokenizer.nextToken().substring(2);
            else customDelimiter = "\\" + input.substring(3, input.indexOf("\\n"));
            String[] delimiterList = { customDelimiter, ",", ":" };
            return delimiterList;
        }
        String[] delimiterList = { ",", ":" };
        return delimiterList;
    }
    static int[] getNumbers( String input, String[] delimiterList ){
        String numString = "";
        if( delimiterList.length != 2 ) numString = input.substring( input.indexOf("\\n") + 2 );
        else numString = input;
        String regex = "";
        for( String s : delimiterList ){
            if( s.contains("\\") ) regex = regex + "|\\" + s;
            else regex = regex + "|" + s;
        }
        regex = regex.substring(1);
        Pattern pattern = Pattern.compile( regex );
        String[] nums = pattern.split( numString );
        int[] result = new int[nums.length];
        for( int i = 0; i < nums.length; i++ ) result[i] = Integer.parseInt( nums[i] );
        return result;
    }

    static int sum( int[] numbers ){
        int result = 0;
        if( numbers.length == 0 ) return 0;
        for( int num : numbers ) result += num;
        return result;
    }

    static boolean validateInput( String input ){
        StringTokenizer tokenizer = new StringTokenizer( input, "\\n" );
        // \n이 있는 경우
        if( tokenizer.countTokens() == 2 ){
            // 맨 앞에 //가 있는지 확인
            if( !tokenizer.nextToken().substring(0,2).equals("//") ) return false;
        }
        else {
            // 구분자 외의 값이 들어오는 경우

        }
        //if( input.substring(2,3).equals( "\\") ) System.out.println( true );
        // \n이 없는 경우

        return true;
    }

    public static void main(String[] args) {
        int result = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
            System.out.println( "덧셈할 문자열을 입력해 주세요." );
            String input = bufferedReader.readLine();
            validateInput( input );
            //if( !validateInput( input ) ) throw new IllegalArgumentException();
            String[] delimiterList = setDelimiter( input );
            int[] numbers = getNumbers( input, delimiterList );
            result = sum( numbers );
            System.out.println( "결과: " + result );
            bufferedReader.close();
        } catch (IOException e ){e.printStackTrace();}
    }
}
