package com.ekip.KVMK.Login;

import com.ekip.KVMK.entities.Users;
import com.ekip.KVMK.repository.UserRepository;
import com.ekip.KVMK.repository.UserRepositoryLogin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepositoryLogin userRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public  void testCreateUser()
    {
        Users users = new Users();
        users.setEmail("mario@gmail.com");
        users.setPassword("jivotnoo2020");
        users.setName("Mario");
        users.setLastname("Ime");

        Users savedUser =  userRepo.save(users);
        Users existUser = entityManager.find(Users.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(users.getEmail());

    }
 /*   @Test*/
    /*public void testFindUserByName(){
        String username = "Mario";
        Users users = userRepo.findByEmail(username);

        assertThat(users).isNotNull();
    }*/


}

