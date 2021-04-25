package com.company.carservices.service.implementations;

import com.company.carservices.dto.UserDto;
import com.company.carservices.entity.User;
import com.company.carservices.repository.UserRepository;
import com.company.carservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Integer saveUser(UserDto userdto) {
        User user = mapFromDto(userdto);
        return userRepository.save(user).getId();
    }

    private User mapFromDto(UserDto userDto) {
        User user = new User();
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setRoles(userDto.getRoles());

        return user;
    }
}
