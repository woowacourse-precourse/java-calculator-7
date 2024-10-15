package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // 문자열 입력
        FullLine FullLine = new FullLine();
        FullLine.LineInput();
        // 형 변환
        Numbers Numbers = new Numbers();
        Numbers.ToInt(FullLine.MakeSplitWordList());
        // 결과 도출
        Numbers.Result();
    }
}

class FullLine {
    private String InputLine;
    public void LineInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요.");
        this.InputLine = Console.readLine();
    }
    public String[] MakeSplitWordList() {
        if (InputLine.startsWith("//")) {
            int EndIndex = InputLine.indexOf("\\n");
            String CustomSplitWord = InputLine.substring(2, EndIndex);
            String RemainLine = InputLine.substring(EndIndex + 2);
            return RemainLine.split("[,:]" + CustomSplitWord);
        }
        return InputLine.split("[,:]");
    }
}
class Numbers {
    private int[] NumList;
    public void ToInt(String[] WordList){
        int[] NumList = new int[WordList.length];
        for (int i = 0; i < WordList.length; i++){
            NumList[i] = Parse(WordList[i]);
        }
        this.NumList = NumList;
    }
    private int Parse(String Word) {
        int ParseInt ;
        try {
            ParseInt = Integer.parseInt(Word);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        if (ParseInt < 1) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        return ParseInt;
    }
    public void Result() {
        int Sum = 0;
        for (int Num : NumList) {
            Sum += Num;
        }
        System.out.print("결과 : " + Sum);
    }
}
