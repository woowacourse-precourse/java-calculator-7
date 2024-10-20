package calculator;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String str = readLine();

            ArrayList<Integer> tempList = new ArrayList<>();
            ArrayList<Integer> wholeList = new ArrayList<>();

            while(!str.equals("exit")) {

                boolean isCustom;
                if(str.length() == 0) {
                    isCustom = false;
                } else {
                    isCustom = (str.charAt(0) == '/') && (str.charAt(1) == '/') && (str.charAt(3) == '\\') && (str.charAt(4) == 'n');
                }

                char custom = '0';
                if(isCustom) {
                    custom = str.charAt(2);
                    str = str.substring(5);
                }

                for(int i = 0; i < str.length(); i++) {

                    char tempChar = str.charAt(i);

                    if(Character.isDigit(tempChar)) {
                        int tempInt = tempChar - '0';
                        tempList.add(tempInt);
                    }
                    else {
                        boolean plusCustom = (tempChar == ',') || (tempChar == ':');
                        if(custom != '0') {
                            plusCustom = (tempChar == ',') || (tempChar == ':') || (tempChar == custom);
                        }

                        if(plusCustom) {
                            tempListToWholeList(tempList, wholeList);
                        }
                        else {
                            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
                        }
                    }
                }

                if (tempList.size() != 0) {
                    tempListToWholeList(tempList, wholeList);
                }

                int finalSum = 0;
                for(int i = 0; i < wholeList.size(); i++) {
                    finalSum += wholeList.get(i);
                }
                System.out.println("결과 : " + finalSum);
                System.out.println();

                wholeList.clear();

                System.out.println("덧셈할 문자열을 입력해 주세요.");
                str = readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("계산기가 종료되었습니다.");
    }

    public static void tempListToWholeList(ArrayList<Integer> tempList, ArrayList<Integer> wholeList) {
        int tempSize = tempList.size();
        int powCount = tempSize - 1;
        int tempInt = 0;
        for(int j = 0; j < tempSize; j++) {
            tempInt += tempList.get(j) * Math.pow(10, powCount);
            powCount--;
        }
        wholeList.add(tempInt);
        tempList.clear();
    }
}