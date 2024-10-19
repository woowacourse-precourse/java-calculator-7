package calculator.service;

import calculator.model.Separator;
import calculator.repository.SeparatorRepository;
import java.util.Set;

public class SeparatorServiceImpl implements SeparatorService{
    private final SeparatorRepository separatorRepository;

    public SeparatorServiceImpl(SeparatorRepository separatorRepository) {
        this.separatorRepository = separatorRepository;
    }

    @Override
    public void join(Separator separator) {
        if (!have(separator)) {
            separatorRepository.save(separator);
        }
    }

    private boolean have(Separator separator) {
        return separatorRepository.findAll()
                .stream()
                .anyMatch(i -> i.equals(separator));
    }

    @Override
    public Set<Separator> findAllSeparator() {
        return separatorRepository.findAll();
    }
}
