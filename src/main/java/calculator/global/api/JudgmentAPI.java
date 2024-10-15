package calculator.global.api;

public class JudgmentAPI {

    private boolean validNumber(char ch) {
        for(char i = '0'; i < '9'; i++) {
            if(ch == i) {
                return true;
            }
        }

        return false;
    }

    public boolean[] convertBooleans(String sentence) {
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

    public int isNextTrue(Boolean[] booleans, int init) {
        int arrayLength = booleans.length;
        int continuousTrue = 0;

        for(int i = init; i < arrayLength; i++) {
            if(booleans[i]) {
                continuousTrue++;
            } else {
                return continuousTrue;
            }
        }

        return continuousTrue;
    }
}
