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
        this.separatorList.add(';');
    }

    // 입력 문자열을 분해해서 필드에 저장하기
    public void splitInputString(String input)
    {

    }

    // 커스텀 구분자가 있는 경우 해당 구분자를 추가
    private void checkCustomSperator()
    {

    }

    // valList에 저장된 모든 값을 더한후 리턴
    public int returnAddition()
    {
        return 0;
    }
}
