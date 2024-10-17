package calculator.global.api;

public class JudgmentAPI {

	public boolean isExitCustomSeparator() {
		return true;
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
