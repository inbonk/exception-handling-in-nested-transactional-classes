package net.inbon.exercise.transactional.repository;

import net.inbon.exercise.transactional.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
