package calculator;

import java.util.ArrayList;

public class Calculation {
    private ArrayList<Integer> valList;
    private ArrayList<Character> separatorList;

    public Calculation()
    {
        this.valList = new ArrayList<>();
        this.separatorList = new ArrayList<>();
        this.separatorList.add(',');
        this.separatorList.add(':');
    }

    // 입력 문자열을 분해해서 필드에 저장하기
    public void splitInputString(String input)
    {
        // 입력값이 비어있는지 확인
        if (input.isEmpty()) {
            // 빈 문자열 처리
            return;
        }

        if (input.startsWith("//")) {
            input = checkCustomSperator(input);
        }

        // 중간점검
        System.out.println(input);
        System.out.println(separatorList);

        // 구분자로 숫자 분리
        //String[] tokens = input.split();
        String tmp = "";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i); // 현재 문자를 가져옴

            // 문자가 숫자인지 확인
            if (currentChar >= '0' && currentChar <= '9') {
                tmp += currentChar; // 숫자면 tmp에 더함
            }
            // 문자가 구분자인지 확인
            else if (separatorList.contains(currentChar)) {
                valList.add(Integer.parseInt(tmp));
                tmp = ""; // tmp를 초기화
            }
            // 숫자도 구분자도 아닌 경우 에러 처리
            else {
                System.err.println("Error: Invalid seperator");
            }
        }
        valList.add(Integer.parseInt(tmp)); // 마지막 value 추가
        System.out.println(valList);

    }

    // 커스텀 구분자가 있는 경우 해당 구분자를 추가
    private String checkCustomSperator(String input)
    {
        // "//"와 "\n" 사이의 문자열을 구분자로 사용
        String[] tmp = input.split("\\\\n");
        String custom = tmp[0].substring(2);  // 커스텀 구분자 추출

        // 커스텀 구분자 추가하기
        for(int i=0; i<custom.length(); i++)
        {
            this.separatorList.add(custom.charAt(i));
        }

        return tmp[1]; // 실제 숫자 부분만 리턴
    }

    // valList에 저장된 모든 값을 더한후 리턴
    public int returnAddition()
    {
        int sum = 0;
        for(int i=0; i<valList.size(); i++)
        {
            sum += valList.get(i);
        }
        return sum;
    }
}
