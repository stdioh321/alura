package br.com.alura.mvc.mudi.config;


import br.com.alura.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var optUser = userRepository.findByUsername(s);
        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        var userDetails =
                User.builder()
                        .username(s)
                        .password(optUser.get().getPassword())
                        .roles("ADMIN")
                        .build();
        return userDetails;
    }
}
