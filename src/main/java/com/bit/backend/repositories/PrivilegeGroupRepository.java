package com.bit.backend.repositories;

import com.bit.backend.entities.PrivilegeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrivilegeGroupRepository extends JpaRepository<PrivilegeGroup, Long> {

    List<PrivilegeGroup> findAll();
    Optional<PrivilegeGroup> findByGroupName(String groupName);
    Optional<PrivilegeGroup> findById(int id);
    @Query(nativeQuery = true, value = "SELECT * FROM auth_groups WHERE status = 1")
    List<PrivilegeGroup> getActivePrivilageGroups();
}
