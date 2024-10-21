package calculator;

import java.util.ArrayList;

public class Calculator {
    String input; // 숫자 input
    ArrayList<Character> separatorList; // 구분자 종류

    public Calculator(String str) {
        separatorList = new ArrayList<>();
        separatorList.add(',');
        separatorList.add(':');
        getCustomSeparator(str);
    }

    public void getCustomSeparator(String str) throws IllegalArgumentException {
        if(str.length()<6)
            input = str;
        else if (str.substring(0, 2).equals("//") && str.substring(3,5).equals("\\n")) {
            char customSeparator = str.charAt(2);
            if (customSeparator > '0' && customSeparator < '9')
                throw new IllegalArgumentException();
            separatorList.add(customSeparator);
            input = str.substring(5, str.length());
        }
        else
            input=str;
    }

    public long getSum() throws IllegalArgumentException {
        if(input.length()==0)
            return 0;
        String separator = "\\";
        for (int i = 0; i < separatorList.size(); i++) {
            separator = separator + separatorList.get(i);
            if(i<separatorList.size()-1)
                separator+="|\\";
        }
//        for(int i=0;i<separatorList.size();i++)
//            System.out.println("sepa "+i+" : " + separatorList.get(i));
        String[] numArr = input.split(separator); // 구문자에 따라 숫자들 분리
//        for(int i=0;i<numArr.length;i++)
//            System.out.println(i+" :" +numArr[i]);
        long sum = 0;
        try {
            for (int i = 0; i < numArr.length; i++) {
                long val = Long.parseLong(numArr[i]);
                //System.out.println("val:"+val);
                if (val <= 0)
                    throw new IllegalArgumentException();
                sum += val;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return sum;
    }

}