package calculator.service;

import calculator.entity.IndexQueue;
import calculator.entity.Input;
import calculator.entity.NumList;
import calculator.entity.RefinedInput;
import calculator.entity.RegexStr;
import calculator.entity.SeparatorSet;

public interface SeparatorService {


    NumList separateNum(RefinedInput refinedInput, RegexStr regex);

    SeparatorSet getCustomSeparators(Input input);

    RefinedInput refineInput(Input input, IndexQueue idxQueue);

    IndexQueue getAllCustomSepIdx(Input input);
}
