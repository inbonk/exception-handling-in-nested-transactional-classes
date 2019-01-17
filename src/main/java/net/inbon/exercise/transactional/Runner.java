package net.inbon.exercise.transactional;

import net.inbon.exercise.transactional.service.OuterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by inbonk on 2019-01-16.
 */
@Profile("!test")
@Component
public class Runner implements ApplicationRunner {

    private final OuterService outerService;

    @Autowired
    public Runner(OuterService outerService) {
        this.outerService = outerService;
    }

    @Override
    public void run(ApplicationArguments args) {
        outerService.callingTransactionalMethodThrowingRuntimeEx();
    }
}
