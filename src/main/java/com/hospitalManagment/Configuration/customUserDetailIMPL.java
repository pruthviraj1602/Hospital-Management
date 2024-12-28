package com.hospitalManagment.Configuration;

import com.hospitalManagment.Entities.User;
import com.hospitalManagment.Repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class customUserDetailIMPL implements UserDetailsService {

    @Autowired
    private userRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.getUserByUserEmail(userEmail);
      if(user==null){
        throw new UsernameNotFoundException("User Not Found");
      }
        return new customUserDetail(user);
    }
}
