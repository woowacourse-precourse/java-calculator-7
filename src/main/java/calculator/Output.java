package calculator;

public class Output {
    private static final String form = "결과 : ";

    public static void outLine(int number){
        System.out.println(makeOutput(number));
    }

    private static String makeOutput(int number){
        return form + number;
    }

}
