package net.inbon.exercise.transactional.service;

import lombok.extern.slf4j.Slf4j;
import net.inbon.exercise.transactional.entity.Post;
import net.inbon.exercise.transactional.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(propagation = Propagation.NESTED)
public class NestedTransactionalInnerService {
    private final PostRepository postRepository;

    @Autowired
    public NestedTransactionalInnerService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void innerMethodThrowingRuntimeEx() {
        postRepository.save(new Post("[NESTED Transactional class] innerMethodThrowingRuntimeEx"));
        throw new RuntimeException("RuntimeException inside");
    }
}
