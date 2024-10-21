package calculator.model.delimiter.factory;

import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;

public abstract class DelimitersFactory {

    public abstract Delimiters createDelimiters(Delimiter... additionalDelimiters);
}
