package com.ekip.KVMK.Validation;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.*;

public class PassEncoder {
  /*  private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    private void checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword))
            System.out.println("The password matches.");
        else
            System.out.println("The password does not match.");
    }*/

    /*int strength = 10; // work factor of bcrypt
    BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder(strength, new SecureRandom());
    private CharSequence plainPassword;
    String encodedPassword = bCryptPasswordEncoder.encode(plainPassword);*/

     public static void main(String[] args) {
         int strength=10;
         
         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
         CharSequence plainPassword = null;
         String encodedPassword = passwordEncoder.encode(plainPassword);

         assertTrue(passwordEncoder.matches("myPass", encodedPassword));
         System.out.println(encodedPassword);


    }

    private static void assertTrue(boolean myPassword) {
    }
}
