package com.ekip.KVMK.Validation;

import com.ekip.KVMK.CustomUserDetails;
import com.ekip.KVMK.entities.Users;
import com.ekip.KVMK.repository.UserRepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositoryLogin userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepo.findByEmail(email);
        if(users == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(users);

    }
}
