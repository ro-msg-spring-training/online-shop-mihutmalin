package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Entities.Customer;
import ro.msg.learning.shop.Exceptions.UserNotFoundException;
import ro.msg.learning.shop.Repositories.CustomerRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findCustomerByUsername(s);
        if(customer == null){
            throw new UserNotFoundException();
        }else{
            return new User(customer.getUsername(), customer.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        }
    }
}
