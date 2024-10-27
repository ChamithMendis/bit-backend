package com.bit.backend.repositories;

import com.bit.backend.dtos.AuthDto;
import com.bit.backend.dtos.SystemPrivilegeDto;
import com.bit.backend.dtos.SystemPrivilegeListDto;
import com.bit.backend.entities.User;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Query(nativeQuery = true, value = "SELECT * FROM get_auth_ids WHERE user_id = :userId")
    Optional<List<Integer>> findAuthIdsByUserId(@Param("userId") long userId);


    @Query(nativeQuery = true, value = "SELECT id, description FROM get_available_system_auth_details WHERE assigned = 0")
    List<Tuple> getAvailableSystemPrivileges();

    @Query(nativeQuery = true, value = "SELECT id, description FROM get_available_system_auth_details WHERE assigned = 1")
    List<Tuple> getAssignedSystemPrivileges();
}
