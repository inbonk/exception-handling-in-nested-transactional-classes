package net.inbon.exercise.transactional.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OuterServiceTest {
    @Autowired
    private OuterService outerService;

    @Test
    public void callingTransactionalMethodThrowingRuntimeEx() {
        outerService.callingTransactionalMethodThrowingRuntimeEx();
    }

    @Test
    public void callingTransactionalMethodCatchingRuntimeExInside() {
        outerService.callingTransactionalMethodCatchingRuntimeExInside();
    }

    @Test
    public void callingMethodThrowingRuntimeEx() {
        outerService.callingMethodThrowingRuntimeEx();
    }

    @Test
    public void callingMethodCatchingRuntimeExInside() {
        outerService.callingMethodCatchingRuntimeExInside();
    }
}
