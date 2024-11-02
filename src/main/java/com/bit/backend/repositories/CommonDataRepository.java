package com.bit.backend.repositories;

import com.bit.backend.entities.CommonDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommonDataRepository extends JpaRepository<CommonDataEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT auth_id as id, description FROM get_assigned_auths WHERE group_id != :groupId OR group_id is null")
    List<CommonDataEntity> getAvailablePrivilegesByGroupId(int groupId);

    @Query(nativeQuery = true, value = "SELECT auth_id as id, description FROM get_assigned_auths WHERE group_id = :groupId")
    List<CommonDataEntity> getAssignedPrivilegesByGroupId(int groupId);
}
