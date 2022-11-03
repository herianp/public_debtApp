package com.petis.debtapp.service;

import com.petis.debtapp.dto.UserDTO;
import com.petis.debtapp.entity.User;
import com.petis.debtapp.exceptions.InvalidEmailFormatException;
import com.petis.debtapp.exceptions.PasswordTooShortException;
import com.petis.debtapp.exceptions.UsernameOrEmailNotUnique;
import com.petis.debtapp.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Boolean checkPasswordLength(String password) {
        return password.length() >= 8;
    }

    private Boolean checkEmailValidation(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

    private Boolean checkUsername(String username) {
        if (userRepository.findUserByUsername(username).isPresent() || username.isBlank()){
            return false;
        }else{
            return true;
        }
    }

    public Long getIdFromAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (Long)auth.getPrincipal();
    }

    private void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(10)));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
    }

    public void addUser(UserDTO userDTO) {
        List<String> errors = new ArrayList<>();
        if (!checkPasswordLength(userDTO.getPassword())){
            throw new PasswordTooShortException();
        }
        if (!checkUsername(userDTO.getUsername())){
            errors.add("Username not unique");
        }
        if (errors.size() > 0){
            throw new UsernameOrEmailNotUnique(errors);
        }
        saveUser(userDTO);
    }
}
