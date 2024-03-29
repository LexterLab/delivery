package com.tuvarna.delivery.delivery.repository;

import com.tuvarna.delivery.delivery.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByType(String type);
}
