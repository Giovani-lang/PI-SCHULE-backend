package com.logonedigital.PI.SCHULE.Security;


import com.logonedigital.PI.SCHULE.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findUserByEmail(username)
                .map(com.logonedigital.PI.SCHULE.Security.UserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("This user doesn't exist, try again"));
    }
}
