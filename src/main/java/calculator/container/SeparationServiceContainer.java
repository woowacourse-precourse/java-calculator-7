package calculator.container;

import calculator.service.separation.SeparationService;
import java.util.EnumMap;
import java.util.stream.Stream;

public class SeparationServiceContainer {

    private final EnumMap<SeparationServiceType, SeparationService> separationServices
            = new EnumMap<>(SeparationServiceType.class);

    public SeparationServiceContainer() {
        Stream.of(SeparationServiceType.values())
                .forEach(type -> separationServices.put(type, type.construct()));
    }

    public SeparationService getSeparationService(SeparationServiceType type) {
        return separationServices.get(type);
    }

    public EnumMap<SeparationServiceType, SeparationService> getSeparationServices() {
        return separationServices;
    }
}
