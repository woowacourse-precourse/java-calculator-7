package calculator.api;

public class StrInput {
    public static final String question = "덧셈할 문자열을 입력해 주세요.\n";

    public boolean validNumber(char ch) {
        for(char i = '0'; i < '9'; i++) {
            if(ch == i) {
                return true;
            }
        }

        return false;
    }

    public boolean[] saveBooleans(String sentence) {
        int sentenceLength = sentence.length();
        boolean[] booleanArrayFromSentence = new boolean[sentenceLength+1];
        char[] splitSentence = sentence.toCharArray();

        for (char ch : splitSentence) {
            for(int i = 0; i < sentenceLength; i++) {
                booleanArrayFromSentence[i] = validNumber(ch);
            }
        }

        return booleanArrayFromSentence;
    }
}
