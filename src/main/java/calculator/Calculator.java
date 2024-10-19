package calculator;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    Set<Character> delimiterSet;
    ArrayList<Long> elementList;
    String startConfigStr = "//";
    String endConfigStr = "\n";
    String endConfigStrEscapeExp = "\\n";
    char[] defaultDel = {',', ':'};

    Calculator() {
        delimiterSet = new HashSet<>();
        elementList = new ArrayList<>();

    }

    /*TODO
    - 입력값은 UTF-8 CharSet인가?
    - 입력 문자의 범위는?
    */
    void readInput(String input) {

        final int startIdx = 0;
        final int maxNumLength = String.valueOf(Long.MAX_VALUE).length() + 1;
        //문자열 입력 부분 제대로 읽게 만들기
        int idxOfCustom = input.indexOf(startConfigStr);
        int idxOfCustomEnd =
                input.indexOf(endConfigStr) != -1 ? input.indexOf(endConfigStr)
                        : input.indexOf(endConfigStrEscapeExp) != -1 ? input.indexOf(endConfigStrEscapeExp) + 1 : -1;

        if (idxOfCustom != -1 && idxOfCustom != startIdx) {
            // exception 유효치않은 입력 문자열
            throw new IllegalArgumentException("Invalid Input String. Need to start \"//\" when set custom delimiter.");
        }

        if (idxOfCustom != -1 && idxOfCustomEnd == -1) {
            //exception 유효치 않은 입력 문자열
            throw new IllegalArgumentException("Invalid Input String. Need to keep format \"//...\\n\" ");
        }

        //get custom delimiter
        if (idxOfCustom != -1) {
            int idx = startConfigStr.length();
            int end = idxOfCustomEnd;

            while (idx < end) {
                delimiterSet.add(input.charAt(idx));
                System.out.println(input.charAt(idx));
                idx++;
            }
        }

        //get number
        int idxNum = idxOfCustomEnd + endConfigStr.length();
        String strEle = input.substring(idxNum).replace(defaultDel[1], defaultDel[0]); // check

        for (Character del : delimiterSet) {
            strEle = strEle.replace(del, defaultDel[0]);
        }

        String[] strNum = strEle.split(String.valueOf(defaultDel[0]));

        for (String s : strNum) {

            if (s.length() >= maxNumLength) {
                throw new IllegalArgumentException("Over MAX Number. num : " + s);
            }

            long ll = Long.valueOf(s);

            if (ll <= 0) {
                throw new IllegalArgumentException("Out Of Range Number. num : + ll");
            }
            elementList.add(ll);
        }

    }

    long sum() {
        long sum = 0;

        for (long ll : elementList) {
            sum += ll;
        }

        return sum;

    }
}
