package dev.janwillem.collectionapi.security.services;


import dev.janwillem.collectionapi.dataAccess.dao.UserDAO;
import dev.janwillem.collectionapi.dataAccess.models.User;
import dev.janwillem.collectionapi.interfaces.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {
    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    @Override
    public UserDetails loadUserById(UUID id) throws UsernameNotFoundException {
        User user = userDAO.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with UUID: " + id));

        return UserDetailsImpl.build(user);
    }
}