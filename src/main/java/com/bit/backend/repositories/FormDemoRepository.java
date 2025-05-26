package com.bit.backend.repositories;

import com.bit.backend.entities.FormDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormDemoRepository extends JpaRepository<FormDemoEntity, Long> {

    @Query(nativeQuery = true, value = "select * from form_demo where age >= 18")
    List<FormDemoEntity> getAgeGreaterThan18();
}
