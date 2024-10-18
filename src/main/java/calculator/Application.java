package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //....
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        String strDelim = insertSeparator(selectDelimiter(str), "|");
        String addStr = addString(str);
        int answer = cal(strDelim, addStr);
        System.out.println("결과 : "+answer);

    }
    public static String selectDelimiter(String str){
        //구분자가 한번에 안들어올 수 있다.
        // "//"와 "\n" 사이 값만 추출해서 ..?
        // 추출값을 구분자그룹에 넣고, 원본스트링에서 구분자 그룹을 제외하기?
        String defaultDelimiter = ",:";
        String customDelimiter = defaultDelimiter;
        int idxStart, idxEnd;
        if((idxStart=str.indexOf("//"))!=-1) {
            if((idxEnd=str.indexOf("\\n", idxStart))!=-1) {
                customDelimiter += str.substring(idxStart+2, idxEnd).trim();
            }
        }
        //System.out.println("selectDelimiter:"+customDelimiter);
        return customDelimiter;
    }
    public static String insertSeparator(String original, String separator) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<original.length(); i++) {
            char ch = original.charAt(i);
            if(ch=='|') {
                sb.append("\\|");
            }else {
                sb.append(ch);
            }

            if(i<original.length()-1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
    public static String addString(String str) {
        int startIdx, endIdx;
        if((startIdx=str.indexOf("//"))!=-1) {
            if((endIdx=str.indexOf("\\n",startIdx))!=-1) {
                String str1 = str.substring(0, startIdx).trim();
                String str2 = str.substring(endIdx+2).trim();
                str = str1+str2;
            }
        }
        //System.out.println("addString:"+str);
        return str;
    }

    public static int cal(String delim, String str){
        String[] strArr = str.replace(" ","").split(delim);
        int sum = 0;
        for (String s : strArr) {
            try {
                int a = Integer.parseInt(s.trim());
                System.out.println("a:" + a);
                if (a > 0) {
                    sum += a;
                    //System.out.println("::if::");
                } else {
                    //System.out.println(":::else:::");
                    throw new IllegalArgumentException("Non-positive numbers are not allowed");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid number:"+ str);
            }

        }
        return sum;
    }
    public static int cal2(String str) {
        String delimiter = selectDelimiter(str);
        String delimRegex = insertSeparator(delimiter, "|");
        String summingStr = addString(str);
        //String realStr = summingStr.replace(" ", "");
        //System.out.println(realStr);
        String[] strArr = summingStr.replace(" ","").split(delimRegex);
        System.out.println(Arrays.toString(strArr));
        int sum = 0;
        for (String s : strArr) {
            try {
                int a = Integer.parseInt(s.trim());
                System.out.println("a:" + a);
                if (a > 0) {
                    sum += a;
                    System.out.println("::if::");
                } else {
                    System.out.println(":::else:::");
                    //throw new IllegalArgumentException("Non-positive numbers are not allowed");
                }
            } catch (NumberFormatException e) {
                //throw new IllegalArgumentException("invalid number:"+ str);
                throw e;
            }

        }
        return sum;
        //String split을 여러 문자로?-> 정규식 이용 ...

    }
}
