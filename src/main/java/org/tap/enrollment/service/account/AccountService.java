package org.tap.enrollment.service.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service 
@Getter
@Setter
@PropertySource("classpath:user.properties")
public class AccountService {
    @Value("${myspring.account1.username}")
    private String userName;
    
    @Value("${myspring.account1.password}")
    private String userPassword;
    
    @Value("${myspring.account1.role}")
    private String userRole;
    
    @Value("${myspring.account2.username}")
    private String adminName;
    
    @Value("${myspring.account2.password}")
    private String adminPass;
    
    @Value("${myspring.account2.role}")
    private String adminRole;
}
