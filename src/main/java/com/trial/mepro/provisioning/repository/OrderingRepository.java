package com.trial.mepro.provisioning.repository;

import com.trial.mepro.provisioning.domain.Ordering;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface OrderingRepository extends R2dbcRepository<Ordering, Long> {
    Mono<Ordering> findByName(String name);
}
