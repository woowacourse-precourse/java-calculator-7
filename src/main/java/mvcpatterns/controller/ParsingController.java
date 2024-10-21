package mvcpatterns.controller;

import java.util.HashSet;
import java.util.Set;

public class ParsingController {
    protected Set<Character> delimiterSet;
    protected final char[] DEFAULT_DELIMITER = {',', ':'};

    public ParsingController() {
        this.delimiterSet = new HashSet<>();
    }

    public String[] extractNumbers(String input) {

        String[] parsedInput = this.parseInput(input);

        String header = parsedInput[0];
        String body = parsedInput[1];

        this.setCustomDelimiter(header);

        return this.parseBody(body);

    }

    private String[] parseInput(String input) {
        final int headStartIdx = 0;
        final String headStartStr = "//";
        final String headEndStr = "\\n";

        int idxHeadStart = input.indexOf(headStartStr);

        int idxHeadEnd = input.indexOf(headEndStr);

        //validate header
        if (idxHeadStart != -1 && idxHeadStart != headStartIdx) {
            // exception 유효치 않은 입력 문자열
            throw new IllegalArgumentException("Invalid Input String. Need to start \"//\" when set custom delimiter.");
        }

        if (idxHeadStart != -1 && idxHeadEnd == -1) {
            //exception 유효치 않은 입력 문자열
            throw new IllegalArgumentException("Invalid Input String. Need to keep format \"//...\\n\" ");
        }

        String customDelimiters = "";
        String body = "";
        int bodyIdx = 0;

        if (idxHeadStart != -1) {
            int s = idxHeadStart + headStartStr.length();
            int e = idxHeadEnd;
            customDelimiters = input.substring(s, e);

            bodyIdx = e + headEndStr.length();
        }

        body = input.substring(bodyIdx);

        String[] ret = {customDelimiters, body};

        //System.out.println("[parseInput] result : [ " + customDelimiters + " , " + body + "] ");

        return ret;
    }

    private void setCustomDelimiter(String delimiters) {

        //System.out.println("[setCustomDelimiter] delimiters : " + delimiters);
        for (int i = 0; i < delimiters.length(); i++) {
            char ch = delimiters.charAt(i);
            delimiterSet.add(ch);
        }

        //System.out.print("[setCustomDelimiter] delimiterSet : [");
        delimiterSet.forEach((del -> {
            //System.out.print(del + ", ");
        }));
        //System.out.print("]\n");
    }

    private String[] parseBody(String body) {

        //replace delimiter

        String strEle = body.replace(DEFAULT_DELIMITER[1], DEFAULT_DELIMITER[0]);

        for (Character del : delimiterSet) {
            strEle = strEle.replace(del, DEFAULT_DELIMITER[0]);
        }

        //System.out.println("[parseBody] : output : " + strEle);

        String[] ret = strEle.split(String.valueOf(DEFAULT_DELIMITER[0]));

        return ret;
    }
}
