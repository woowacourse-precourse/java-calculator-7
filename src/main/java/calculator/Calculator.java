package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    protected Set<Character> delimiterSet;
    protected ArrayList<Long> elementList;
    protected final char[] DEFAULT_DELIMITER = {',', ':'};

    Calculator() {
        delimiterSet = new HashSet<>();
        elementList = new ArrayList<>();

    }

    protected String[] parseInput(String input) {

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty. please check input");
        }

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


    protected void setCustomDelimiter(String delimiters) {

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

    protected String[] parseBody(String body) {

        //replace delimiter

        String strEle = body.replace(DEFAULT_DELIMITER[1], DEFAULT_DELIMITER[0]);

        for (Character del : delimiterSet) {
            strEle = strEle.replace(del, DEFAULT_DELIMITER[0]);
        }

        //System.out.println("[parseBody] : output : " + strEle);

        String[] ret = strEle.split(String.valueOf(DEFAULT_DELIMITER[0]));

        return ret;
    }


    protected String sum(String[] elementList) {

        final int maxSize = 8;
        BigInteger sum = new BigInteger("0");

        for (String s : elementList) {

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (!Character.isDigit(ch)) {
                    throw new IllegalArgumentException(s + " is not number or positive number. please check it");
                }
            }

            BigInteger num = new BigInteger(s);

            sum = sum.add(num);
        }

        //System.out.println("[sum] result : " + sum);

        return sum.toString();

    }

    String doTask(String input) {

        final int bodyIdx = 1;
        final int headerIdx = 0;
        //get custom delimiter
        String[] dataList = parseInput(input);

        setCustomDelimiter(dataList[headerIdx]);

        String[] numbers = parseBody(dataList[bodyIdx]);

        return sum(numbers);

    }
}
