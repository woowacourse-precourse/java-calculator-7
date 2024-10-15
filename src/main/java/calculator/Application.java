package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        List<String> stringList = List.of(",", ":");
        InputGuidelines inputGuidelines = new InputGuidelines(stringList);
        inputGuidelines.printInputGuidelines();

    }
}
