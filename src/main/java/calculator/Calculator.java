package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Calculator {

    private ArrayList<String> separator;
    private static final String INVALID_INPUT_MESSAGE = "유효하지 않은 입력값입니다.";

    public void addSeparator(String newSeparator) {
        this.separator.add(newSeparator);
    }

    public void setDefaultSeparator(String[] separator) {
        this.separator = new ArrayList<>();
        this.separator.addAll(Arrays.asList(separator));
    }


    public String getCustomSeparator(String inStr) {
        if (inStr.startsWith("//")) {
            if (inStr.contains("\\n")) {
                int separatorEndIdx = inStr.indexOf("\\n");
                String customSeparator = inStr.substring(2, separatorEndIdx);
                addSeparator(customSeparator);

                String restStr = inStr.substring(separatorEndIdx + 2);
                if (restStr.contains("\\n") || restStr.contains("//")) {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
                return customSeparator;
            } else {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
        return "";
    }

    public void inspectConsoleStr(String inStr, String customSeparator) {
        if (!"".equals(inStr)) {
            String str = inStr.replace(",", "")
                    .replace(":", "")
                    .replace("//", "")
                    .replace("\\n", "")
                    .replace(customSeparator, "");
            try {
                int intValue = Integer.parseInt(str);
                if (intValue < 0) {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
    }

    public int outputResult(String inStr, String customSeparator) {
        if (!"".equals(customSeparator)) {
            int subIdx = inStr.indexOf("\\n");
            inStr = inStr.substring(subIdx + 2);
        }

        int returnInt = 0;
        StringBuilder delim = new StringBuilder();
        for (String separator : this.separator) {
            delim.append(separator);
        }
        StringTokenizer st = new StringTokenizer(inStr, delim.toString());
        while (st.hasMoreTokens()) {
            returnInt += Integer.parseInt(st.nextToken());
        }
        return returnInt;
    }

}
