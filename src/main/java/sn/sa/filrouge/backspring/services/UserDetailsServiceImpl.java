package sn.sa.filrouge.backspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.sa.filrouge.backspring.model.User;
import sn.sa.filrouge.backspring.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private User userConnect;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
                this.userConnect = user;
        return UserPrinciple.build(user);
    }

    public User getUserConnect() {
        return userConnect;
    }
}
