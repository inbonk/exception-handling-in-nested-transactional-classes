package net.inbon.exercise.transactional.service;

import net.inbon.exercise.transactional.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class OuterServiceTest {
    @Autowired
    private OuterService outerService;
    @Autowired
    private PostRepository repository;

    @Before
    public void clear() {
        repository.deleteAll();
    }

    @Test//(expected = UnexpectedRollbackException.class)
    public void callingTransactionalMethodThrowingRuntimeEx() {
        outerService.callingTransactionalMethodThrowingRuntimeEx();
    }

    @Test
    public void callingNestedTransactionalMethodThrowingRuntimeEx() {
        outerService.callingNestedTransactionalMethodThrowingRuntimeEx();

        assertThat(repository.count()).isEqualTo(0);
    }

    @Test
    public void callingTransactionalMethodCatchingRuntimeExInside() {
        outerService.callingTransactionalMethodCatchingRuntimeExInside();

        assertThat(repository.count()).isEqualTo(1);
    }

    @Test
    public void callingMethodThrowingRuntimeEx() {
        outerService.callingMethodThrowingRuntimeEx();

        assertThat(repository.count()).isEqualTo(1);
    }

    @Test
    public void callingMethodCatchingRuntimeExInside() {
        outerService.callingMethodCatchingRuntimeExInside();

        assertThat(repository.count()).isEqualTo(1);
    }
}
