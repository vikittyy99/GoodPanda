package com.ekip.KVMK.controller;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.ekip.KVMK.beans.userRequest;
import com.ekip.KVMK.entities.City;
import com.ekip.KVMK.entities.Users;
import com.ekip.KVMK.repository.CityRepository;
import com.ekip.KVMK.repository.UserRepository;
import com.ekip.KVMK.repository.UserRepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/app")

public class UserController {

    private final UserRepository userRepository;

   private final CityRepository cityRepository;

   private final UserRepositoryLogin userLogin;



   UserController (UserRepository userRepository, CityRepository cityRepository, UserRepositoryLogin userLogin)
   {
       this.userRepository=userRepository;
       this.cityRepository=cityRepository;
       this.userLogin = userLogin;
   }

    @GetMapping("/user")
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/search/id")
    public String getUserById(@RequestParam(required = false) Long id) {


       String user = null;
      try {
          user = userRepository.findById(id).toString();
       }
      catch (Exception i) {
           return i.getClass().getName();
      }
     return user;

    }

      @GetMapping("/search/page")
      public ResponseEntity<?>paginateUser(@RequestParam(value = "currentPage", defaultValue= "1 ") int currentPage,
             @RequestParam(value = "perPage", defaultValue="5") int perPage,
              @RequestParam(required = false) String name,
              @RequestParam(required = false) String city,
              @RequestParam(required = false) Integer num)

    {
        Pageable pageable = PageRequest.of(currentPage - 1, perPage);
        Page<Users> users = userRepository.findPageUsers(pageable,
                name.trim().toLowerCase(),
                city.trim().toLowerCase(),
                   num== null? -1: num);

        Map<String, Object> response = new HashMap<>();
        response.put("users", users.getContent());
        response.put("currentPage", users.getNumber() + 1);
        response.put("totalElements", users.getTotalElements());
        response.put("totalPage", users.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

     @PostMapping("/save")
     public ResponseEntity<?> saveOrUpdate(@RequestBody userRequest form){

          City city = cityRepository.findById(form.getCityId()).orElse(cityRepository.findById(17L).get());
         boolean isNew = form.getId() == null;
         Users users = new Users (
                 form.getId(),
                 form.getName(),
                 form.getNum(),
//              cityId == null? cityRepository.save(new City(cityName)): cityRepository.findById(cityId).orElse(null) );
                 city );
         users = userRepository.save(users);
         Map<String, Object> response = new HashMap<>();
         response.put("generatedId", users.getId());
         if(isNew) {
             response.put("message", "Успешно записан!");
         }
         else{
             response.put("message", "Успешно редактиран!");
         }

         return new ResponseEntity<>(response, HttpStatus.OK);
     }
     @DeleteMapping("/delete")
     public ResponseEntity<?> deleteUsers(@RequestParam Long id)
     {
             userRepository.deleteById(id);
//         userRepository.findByName(name.toLowerCase()).ifPresent(users -> userRepository.delete(users));

         return ResponseEntity.ok("Успешно изтрихте записа!");
     }


    @GetMapping("/search/name")
    public ResponseEntity<?> getUsersName(@RequestParam(required = false) String name)
    {
        if(name== null || name.isBlank()) return ResponseEntity.ok().body("Не сте задали името като критерий!");
        Optional<Users> result = userRepository.findByName(name.toLowerCase());
        return result.isPresent()? ResponseEntity.ok(result) : ResponseEntity.ok("Не е открит запис па данните критерии!");
    }
    /*@Autowired
    private PasswordEncoder passwordEncoder;*/
    @GetMapping("/register")

    public ResponseEntity<String> Registration (Users users)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.save(users);
        System.out.println(users);
        /*users.setPassword(passwordEncoder.encode(users.getPassword()));*/
        return ResponseEntity.ok("register_success");
    }
    @GetMapping("/authenticate")
    public ResponseEntity<String> Login (Users users)
    {

       String email = users.getEmail();
       String password = users.getPassword();

        Users user = userLogin.authenticate(email, password);
        if(user == null)
        {

           //Nqma potrebitel
          return   ResponseEntity.ok("login_failed");

        }
        
        return ResponseEntity.ok("login_success");
    }
}


