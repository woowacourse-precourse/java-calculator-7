package calculator.regex.service;

import calculator.number.domain.NumberService;
import calculator.number.domain.impl.DoubleNumber;
import calculator.number.domain.impl.LongNumber;
import calculator.number.util.NumberConvertorService;
import calculator.number.util.impl.DoubleConvertor;
import calculator.number.util.impl.LongConvertor;
import calculator.regex.domain.RegexPattern;
import calculator.service.calculator.CalculatorService;
import calculator.service.calculator.impl.DoubleCalculatorProcess;
import calculator.service.calculator.impl.LongCalculatorProcess;
import calculator.view.output.ResultService;
import calculator.view.output.impl.DoubleOutputProcess;
import calculator.view.output.impl.LongOutputProcess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class RegexPatternServiceResolver {
    private final Map<RegexPattern, Function<List<Number>, NumberService>> serviceMap = new HashMap<>();
    private final Map<RegexPattern, Supplier<NumberConvertorService>> convertorServiceMap = new HashMap<>();
    private final Map<RegexPattern, CalculatorService> calculatorServicMap = new HashMap<>();
    private final Map<RegexPattern, ResultService> resultServiceMap = new HashMap<>();
    public RegexPatternServiceResolver() {
        initNumberService();
        initNumberConvertorService();
        initCalculatorService();
        initResultService();
    }


    public Function<List<Number>, NumberService> getService(RegexPattern regexPattern) {
        return serviceMap.get(regexPattern);
    }

    public Supplier<NumberConvertorService> getConvertorService(RegexPattern regexPattern) {
        return convertorServiceMap.get(regexPattern);
    }

    public CalculatorService getCalculatorService(RegexPattern regexPattern) {
        return calculatorServicMap.get(regexPattern);
    }

    public ResultService getResultService(RegexPattern regexPattern) {
        return resultServiceMap.get(regexPattern);
    }

    private void initNumberService() {
        serviceMap.put(RegexPattern.DEFAULT_DOUBLE_SEPARATOR, DoubleNumber::of);
        serviceMap.put(RegexPattern.CUSTOM_SEPARATOR_DOUBLE, DoubleNumber::of);
        serviceMap.put(RegexPattern.DEFAULT_SEPARATOR, LongNumber::of);
        serviceMap.put(RegexPattern.CUSTOM_SEPARATOR, LongNumber::of);
        serviceMap.put(RegexPattern.BLANK, LongNumber::of);
    }

    private void initNumberConvertorService() {
        convertorServiceMap.put(RegexPattern.DEFAULT_DOUBLE_SEPARATOR, DoubleConvertor::new);
        convertorServiceMap.put(RegexPattern.CUSTOM_SEPARATOR_DOUBLE, DoubleConvertor::new);
        convertorServiceMap.put(RegexPattern.DEFAULT_SEPARATOR, LongConvertor::new);
        convertorServiceMap.put(RegexPattern.CUSTOM_SEPARATOR, LongConvertor::new);
        convertorServiceMap.put(RegexPattern.BLANK, LongConvertor::new);
    }

    private void initCalculatorService() {
        calculatorServicMap.put(RegexPattern.DEFAULT_DOUBLE_SEPARATOR, new DoubleCalculatorProcess());
        calculatorServicMap.put(RegexPattern.CUSTOM_SEPARATOR_DOUBLE, new DoubleCalculatorProcess());
        calculatorServicMap.put(RegexPattern.DEFAULT_SEPARATOR, new LongCalculatorProcess());
        calculatorServicMap.put(RegexPattern.CUSTOM_SEPARATOR, new LongCalculatorProcess());
        calculatorServicMap.put(RegexPattern.BLANK, new LongCalculatorProcess());
    }

    private void initResultService() {
        resultServiceMap.put(RegexPattern.DEFAULT_DOUBLE_SEPARATOR, new DoubleOutputProcess());
        resultServiceMap.put(RegexPattern.CUSTOM_SEPARATOR_DOUBLE, new DoubleOutputProcess());
        resultServiceMap.put(RegexPattern.DEFAULT_SEPARATOR, new LongOutputProcess());
        resultServiceMap.put(RegexPattern.CUSTOM_SEPARATOR, new LongOutputProcess());
        resultServiceMap.put(RegexPattern.BLANK, new LongOutputProcess());
    }
}
