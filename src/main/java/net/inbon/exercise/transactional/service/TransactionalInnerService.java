package net.inbon.exercise.transactional.service;

import lombok.extern.slf4j.Slf4j;
import net.inbon.exercise.transactional.entity.Post;
import net.inbon.exercise.transactional.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class TransactionalInnerService {
    @Autowired
    private PostRepository postRepository;

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
