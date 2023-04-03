package haagahelia.BoxingProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import haagahelia.BoxingProject.domain.User;
import haagahelia.BoxingProject.domain.UserRepository;

@Service
public class UserDetailServiceImplBoxerProject implements UserDetailsService {
	private final UserRepository urepository;
	
	@Autowired
	public UserDetailServiceImplBoxerProject(UserRepository userRepository) {
		this.urepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		User currentUser = urepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
	}
}
