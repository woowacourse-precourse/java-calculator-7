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
                            int tempSize = tempList.size();
                            int powCount = tempSize - 1;
                            int tempInt2 = 0;
                            for(int j = 0; j < tempSize; j++) {
                                tempInt2 += tempList.get(j) * Math.pow(10, powCount);
                                powCount--;
                            }
                            wholeList.add(tempInt2);
                            tempList.clear();
                        }
                        else {
                            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
                        }
                    }
                }

                if (tempList.size() != 0) {
                    int tempSize2 = tempList.size();
                    int powCount2 = tempSize2 - 1;
                    int tempInt2 = 0;
                    for(int j = 0; j < tempSize2; j++) {
                        tempInt2 += tempList.get(j) * Math.pow(10, powCount2);
                        powCount2--;
                    }
                    wholeList.add(tempInt2);
                    tempList.clear();
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
}