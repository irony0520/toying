package org.example.toying.areas.user.service;

import lombok.RequiredArgsConstructor;
import org.example.toying.areas.user.command.UserRegiseterCommand;
import org.example.toying.entity.User;
import org.example.toying.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//컴포넌트 어노테이션이랑 똑같은데 트랜잭션 대상으로 설정, 명시적인 의미
//빈 등록과정 ComponentScan + ApplicationContext 로 확인하기 내일의 나..
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;





    public void registerUser(UserRegiseterCommand command) {

        User user = User.builder()
                .userId(command.getUserId())
                .username(command.getUsername())
                .password(passwordEncoder.encode(command.getPassword()))
                .role(command.getRole())
                .build();

        userRepository.save(user);
    }

}