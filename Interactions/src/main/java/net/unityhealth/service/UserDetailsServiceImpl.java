package net.unityhealth.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import net.unityhealth.model.AdminUsers;
import net.unityhealth.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        AdminUsers user = userRepository.findByUsername(username);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
//	        for (Role role : user.getRoles()){
//	            grantedAuthorities.add(new SimpleGrantedAuthority(""));
//	        }
	        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	    }
}
