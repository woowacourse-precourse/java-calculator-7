package calculator.model;

import java.util.StringTokenizer;

public class ExtractString {

    public StringTokenizer ExtractInput(String input, StringBuilder split){

        StringTokenizer st = new StringTokenizer(input, split.toString());

        return st;

    }

}
