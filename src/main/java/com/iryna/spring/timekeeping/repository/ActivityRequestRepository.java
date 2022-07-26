package com.iryna.spring.timekeeping.repository;

import com.iryna.spring.timekeeping.entity.ActivityRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @classname: TODO
 * @description: TODO
 * @author: iryna
 */

@Repository
public interface ActivityRequestRepository extends JpaRepository<ActivityRequest, Long> {
}
