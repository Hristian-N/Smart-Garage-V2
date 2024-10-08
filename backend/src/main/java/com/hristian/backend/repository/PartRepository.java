package com.hristian.backend.repository;

import com.hristian.backend.model.Part;
import com.hristian.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
