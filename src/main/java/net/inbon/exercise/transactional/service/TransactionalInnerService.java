package net.inbon.exercise.transactional.service;

import net.inbon.exercise.transactional.entity.Post;
import net.inbon.exercise.transactional.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionalInnerService {
    private final PostRepository postRepository;

    private static final Logger log = LoggerFactory.getLogger(TransactionalInnerService.class);

    @Autowired
    public TransactionalInnerService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void innerMethodThrowingRuntimeEx() {
        postRepository.save(new Post("[Transactional class] innerMethodThrowingRuntimeEx"));
        throw new RuntimeException("RuntimeException inside");
    }

    public void innerMethodCatchingRuntimeEx() {
        postRepository.save(new Post("[Transactional class] innerMethodCatchingRuntimeEx"));
        try {
            throw new RuntimeException("exception after save");
        } catch (RuntimeException ex) {
            log.warn("caught exception inside. e:{}", ex.getMessage());
        }
    }
}
