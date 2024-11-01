package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.dox.User;
import org.example.backend.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        String account = "admin";
        long count = userRepository.count();
        if(count > 0){
            return;
        }
        User u = User.builder()
                .name(account)
                .dep(account)
                .account(account)
                .password(passwordEncoder.encode(account))
                .role(User.ADMIN)
                .build();
        userRepository.save(u);
    }
}
