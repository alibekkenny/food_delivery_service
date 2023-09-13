package com.project.fooddeliveryservice.repository;

import com.project.fooddeliveryservice.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByNameContainingIgnoreCase(@Param("name") String name);

    Company findById(@Param("id") long id);

    List<Company> findByCategoryContainingIgnoreCase(@Param("category") String category);
}
