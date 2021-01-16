package com.ekip.KVMK.repository;

import com.ekip.KVMK.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositoryLogin extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE lower(u.email) =:email")

   Users findByEmail(String email);

    @Query("SELECT u FROM Users u WHERE u.email =:email AND u.password=:password")


    Users authenticate(String email, String password);





}
