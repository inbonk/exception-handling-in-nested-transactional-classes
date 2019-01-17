package net.inbon.exercise.transactional.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class OuterService {
    private final InnerService innerService;
    private final TransactionalInnerService transactionalInnerService;
    private final NestedTransactionalInnerService nestedTransactionalInnerService;

    @Autowired
    public OuterService(InnerService innerService, TransactionalInnerService transactionalInnerService, NestedTransactionalInnerService nestedTransactionalInnerService) {
        this.innerService = innerService;
        this.transactionalInnerService = transactionalInnerService;
        this.nestedTransactionalInnerService = nestedTransactionalInnerService;
    }

    public void callingTransactionalMethodThrowingRuntimeEx() {
        try {
            transactionalInnerService.innerMethodThrowingRuntimeEx();
        } catch (RuntimeException ex) {
            log.warn("OuterService caught exception at outer. ex:{}", ex.getMessage());
        }
    }

    public void callingTransactionalMethodCatchingRuntimeExInside() {
        try {
            transactionalInnerService.innerMethodCatchingRuntimeEx();
        } catch (RuntimeException ex) {
            log.warn("OuterService caught exception at outer. ex:{}", ex.getMessage());
        }
    }

    public void callingNestedTransactionalMethodThrowingRuntimeEx() {
        try {
            nestedTransactionalInnerService.innerMethodThrowingRuntimeEx();
        } catch (RuntimeException ex) {
            log.warn("OuterService caught exception at outer. ex:{}", ex.getMessage());
        }
    }

    public void callingMethodThrowingRuntimeEx() {
        try {
            innerService.innerMethodThrowingRuntimeEx();
        } catch (RuntimeException ex) {
            log.warn("OuterService caught exception at outer. ex:{}", ex.getMessage());
        }
    }

    public void callingMethodCatchingRuntimeExInside() {
        try {
            innerService.innerMethodCatchingRuntimeEx();
        } catch (RuntimeException ex) {
            log.warn("OuterService caught exception at outer. ex:{}", ex.getMessage());
        }
    }
}
