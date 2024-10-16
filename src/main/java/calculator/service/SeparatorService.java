package calculator.service;

import calculator.entity.IndexQueue;
import calculator.entity.NumList;
import calculator.entity.SeparatorSet;

public interface SeparatorService {

    NumList separateNum(String refinedInput, String regex);

    SeparatorSet getCustomSeparators(String input);

    String refineString(String input, IndexQueue idxQueue);

    IndexQueue getAllCustomSepIdx(String input);
}
