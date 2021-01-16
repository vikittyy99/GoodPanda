package com.ekip.KVMK.repository;


import com.ekip.KVMK.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE lower(u.name) =:name")
    Optional <Users> findByName(String name);

    @Query("SELECT u FROM Users u LEFT JOIN u.city c " +
    "WHERE lower(u.name) " +
    "LIKE :#{#name == null || #name.isEmpty()? '%': '%' + #name + '%'} " +
    "AND lower(c.name) " +
            "LIKE :#{#city == null || #city.isEmpty()? '%': '%' + #city + '%'} " +
            "AND (u.num =:num OR :num = -1) " )


    Page<Users>findPageUsers(Pageable pageable, String name, String city, Integer num);


    Users findUserById(Long id);
}