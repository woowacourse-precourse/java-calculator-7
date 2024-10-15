package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // 문자열 입력
        System.out.print("덧셈할 문자열을 입력해 주세요.");
        String FullLine = Console.readLine();
        // 커스텀 구분자 및 기본 구분자로 문자열 분리
        int[] NumList = MakeSplitWordList(FullLine);
        // NumList의 합 구한 후 결과 도출
        int ResultValue = Result(NumList);
        // 결과 도출
        System.out.print("결과 : "+ ResultValue);
    }
    public static int[] MakeSplitWordList(String FullLine) {
        String[] SplitWords;
        if (FullLine.startsWith("//")) {
            int EndIndex = FullLine.indexOf("\\n");
            String CustomSplitWord = FullLine.substring(2, EndIndex);
            String RemainLine = FullLine.substring(EndIndex+2);
            SplitWords =  RemainLine.split("[,:]" + CustomSplitWord);
        } else {
            SplitWords =  FullLine.split("[,:]");
        }

        // int로 형변환 및 잘못된 입력값 구분
        int[] NumList = new int[SplitWords.length];
        for (int i = 0; i < NumList.length; i++){
            try {
                NumList[i] = Integer.parseInt(SplitWords[i]);
                // 양수 확인
                if (NumList[i] < 1) {
                    throw new IllegalArgumentException("IllegalArgumentException");
                }
            //숫자가 아니면 에러 발생
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        }
        return NumList;
    }
    public static int Result(int[] NumList) {
        int ResultValue = 0;
        for (int Num : NumList) {
            ResultValue += Num;
        }
        return ResultValue;
    }
}