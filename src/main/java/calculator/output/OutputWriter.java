package calculator.output;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputWriter {
    private StringBuilder stringBuilder;


    public void writer(String result) {
        getStringBuilder().append("결과 : ").append(result);
        System.out.print(getStringBuilder());
    }

    private StringBuilder getStringBuilder() {
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }

        return stringBuilder;
    }
}
