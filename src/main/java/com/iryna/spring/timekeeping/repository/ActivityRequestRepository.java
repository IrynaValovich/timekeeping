package com.iryna.spring.timekeeping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @classname: TODO
 * @description: TODO
 * @author: iryna
 */

@Repository
public interface ActivityRequestRepository extends JpaRepository<ActivityRequestRepository, Long> {
}
