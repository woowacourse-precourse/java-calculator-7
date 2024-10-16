package calculator.helper;

public class OutputHelper {
    public static final String OUTPUT_STR_FORMAT = "결과 : %d";


    public static String getFormattedOutputStr(int result){
        return String.format(OUTPUT_STR_FORMAT,result);
    }

}
