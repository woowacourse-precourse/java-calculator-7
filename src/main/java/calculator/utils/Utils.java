package calculator.utils;

import calculator.domain.Calculator;

public class Utils {

    public void addCustomDelimiters(Calculator list, String s) {
        if (s.startsWith("//")) {
            char[] ss = extractDelimitersFromHeader(s);
            for (char c : ss) {
                list.delimiters.add(c);
            }
        }
    }

    private char[] extractDelimitersFromHeader(String s) {
        String ss = s.substring(2);
        String[] split = ss.split("\\\\n");
        return split[0].toCharArray();
    }

    public String extractCalculationString(String s) {
        String[] split = s.split("\\\\n");
        return split[1];
    }

    public int[] convertStringToIntList(String s, Calculator list) {
        String result = list.getDelimitersAsString();
        String[] split = s.split(result);

        int[] lists = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            lists[i] = Integer.parseInt(split[i]);
        }
        return lists;
    }

    public int sumIntList(int[] list) {
        int ans = 0;
        for (int i = 0; i < list.length; i++) {
            ans += list[i];
        }
        return ans;
    }
}
