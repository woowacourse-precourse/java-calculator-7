package calculator;

public class OutputWriter {

    private static final String OUTPUT_FORMAT = "결과 : ";

    public static void writeOutput(Long sum) {
        System.out.println(OUTPUT_FORMAT + sum);
    }
}
