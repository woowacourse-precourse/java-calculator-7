package calculator.service.container;

import calculator.service.separation.BasicSeparationService;
import calculator.service.separation.CustomSeparationService;
import calculator.service.separation.SeparationService;
import java.util.function.Supplier;

public enum SeparationServiceType {

    BASIC(BasicSeparationService::new),
    CUSTOM(CustomSeparationService::new),
    ;

    private final Supplier<SeparationService> supplier;

    SeparationServiceType(Supplier<SeparationService> supplier) {
        this.supplier = supplier;
    }

    public SeparationService construct() {
        return supplier.get();
    }
}
