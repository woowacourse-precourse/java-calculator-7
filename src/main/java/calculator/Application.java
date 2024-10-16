package calculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // 문자열 입력
        FullLine fullLine = new FullLine();
        fullLine.lineInput();
        // 형 변환
        Numbers numbers = new Numbers();
        numbers.toInt(fullLine.makeSplitWordList());
        // 결과 도출
        numbers.result();
    }
}

class FullLine {
    private String inputLine;
    public void lineInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요.");
        this.inputLine = Console.readLine();
    }
    public String[] makeSplitWordList() {
        if (inputLine.startsWith("//")) {
            int endIndex = inputLine.indexOf("\\n");
            String customSplitWord = inputLine.substring(2, endIndex);
            String remainLine = inputLine.substring(endIndex + 2);
            return remainLine.split("[,:]" + customSplitWord);
        }
        return inputLine.split("[,:]");
    }
}
class Numbers {
    private int[] numList;
    public void toInt(String[] wordList){
        int[] numList = new int[wordList.length];
        for (int i = 0; i < wordList.length; i++){
            numList[i] = Parse(wordList[i]);
        }
        this.numList = numList;
    }
    private int parse(String Word) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(Word);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        if (parseInt < 1) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        return parseInt;
    }
    public void result() {
        int sum = 0;
        for (int num : numList) {
            sum += num;
        }
        System.out.print("결과 : " + sum);
    }
}
