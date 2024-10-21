package calculator;

import java.util.ArrayList;

public class Calculator {
    String numberString; // 구분자와 숫자만 들어있는 문자열
    ArrayList<Character> separatorList; // 구분자 종류

    // Calulator 인스턴스를 생성하며 Custom구분자를 추가
    public Calculator(String input) {
        separatorList = new ArrayList<>();
        separatorList.add(',');
        separatorList.add(':');
        getCustomSeparator(input);
    }

    // input을 통해 구분자를 list에 저장하고, numberString을 추출해낸다.
    public void getCustomSeparator(String input) throws IllegalArgumentException {
        if(input.length()<6)
            numberString = input;
        else if (input.substring(0, 2).equals("//") && input.substring(3,5).equals("\\n")) {
            char customSeparator = input.charAt(2);
            if (customSeparator > '0' && customSeparator < '9')
                throw new IllegalArgumentException();
            separatorList.add(customSeparator);
            numberString = input.substring(5, input.length());
        }
        else
            numberString=input;
    }

    public long getSum() throws IllegalArgumentException {
        if(numberString.length()==0)
            return 0;

        // 숫자들 구분해서 numArr에 넣기
        String separator = "\\";
        for (int i = 0; i < separatorList.size(); i++) {
            separator = separator + separatorList.get(i);
            if(i<separatorList.size()-1)
                separator+="|\\";
        }
        String[] numArr = numberString.split(separator); // 구문자에 따라 숫자들 분리

        // 구분된 숫자들의 합 구하기
        long sum = 0;
        try {
            for (int i = 0; i < numArr.length; i++) {
                long val = Long.parseLong(numArr[i]);
//            System.out.println("val:"+val);
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
