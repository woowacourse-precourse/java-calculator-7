package calculator;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String str = readLine();

            while(!str.equals("exit")) {
                ArrayList<Integer> tempList = new ArrayList<>();
                ArrayList<Integer> wholeList = new ArrayList<>();

                for(int i = 0; i < str.length(); i++) {

                    char tempChar = str.charAt(i);

                    if(Character.isDigit(tempChar)) {
                        int tempInt = tempChar - '0';
                        tempList.add(tempInt);
                    }
                    else {
                        if(tempChar == ',' || tempChar == ':') {
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