package calculator.service.impl;

import static calculator.utils.Constants.CUSTOM_SEPARATOR_LENGTH;

import calculator.entity.Index;
import calculator.entity.IndexQueue;
import calculator.entity.Input;
import calculator.entity.NumList;
import calculator.entity.RefinedInput;
import calculator.entity.RegexStr;
import calculator.entity.Separator;
import calculator.entity.SeparatorSet;
import calculator.service.SeparatorService;

public class SeparatorServiceImpl implements SeparatorService {

    @Override
    public SeparatorSet getCustomSeparators(Input input) {

        SeparatorSet separatorSet = new SeparatorSet();

        Index idx = new Index(0);
        Index maxIdx = input.maxSepStringIdx();

        while (idx.isLessThanOrEqual(maxIdx)) {
            if (input.isCustomSep(idx)) {
                Index customSeparatorIdx = idx.customSeparatorIdx();
                Separator separator = input.toSeparatorByIndex(customSeparatorIdx);
                separatorSet.addSeparator(separator);
            }

            idx = idx.increase();
        }

        return separatorSet;
    }



    @Override
    public IndexQueue getAllCustomSepIdx(Input input) {
        IndexQueue idxQueue = new IndexQueue();

        Index idx = new Index(0);
        Index maxIdx = input.maxSepStringIdx();

        while (idx.isLessThanOrEqual(maxIdx)) {
            if (input.isCustomSep(idx)) {
                idxQueue.offer(idx);
            }

            idx = idx.increase();
        }

        return idxQueue;
    }



    @Override
    public RefinedInput refineInput(Input input, IndexQueue idxQueue) {

        RefinedInput refinedInput = new RefinedInput();

        Index idx = new Index(0);
        Index maxIdx = input.maxIdx();

        while (idx.isLess(maxIdx)) {
            if (idxQueue.isIndexProcess(idx)) {
                Index customSeparatorIdx = idx.customSeparatorIdx();
                refinedInput.appendLetter(input, customSeparatorIdx);
                idx = idx.plus(CUSTOM_SEPARATOR_LENGTH);
                idxQueue.poll();
                continue;
            }

            refinedInput.appendLetter(input, idx);

            idx = idx.increase();
        }

        return refinedInput;
    }

    @Override
    public NumList separateNum(RefinedInput refinedInput, RegexStr regexStr) {
        return refinedInput.toNumList(regexStr);
    }


}
