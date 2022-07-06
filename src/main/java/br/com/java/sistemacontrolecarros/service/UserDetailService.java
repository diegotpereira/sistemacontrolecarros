package br.com.java.sistemacontrolecarros.service;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import br.com.java.sistemacontrolecarros.models.*;
import br.com.java.sistemacontrolecarros.models.User;

@Service
public class UserDetailService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        // TODO Auto-generated method stub
        User user = userService.findUserByUserName(userName);
        List<GrantedAuthority> autoridades = getUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, autoridades);
    }
    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> funcoes = new HashSet<>();

        for(Role role : userRoles) {
            funcoes.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(funcoes);
    }
    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
        user.isActive(), true, true, true, authorities);
    }
}
