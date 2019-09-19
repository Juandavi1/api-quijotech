package com.sumasaas.repository.persistence;

import com.sumasaas.repository.entities.PostMongoExample;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 *
 */
@Repository
public interface PostRepository extends ReactiveMongoRepository<PostMongoExample, String> {
    Flux<PostMongoExample> findAllByUserId(final Integer id);
}
