package org.tap.enrollment.service.account;

import org.springframework.http.ResponseEntity;
import org.tap.enrollment.entity.account.Account;

public interface AccountService {
	public void deleteAccount(Long id);
	ResponseEntity<?> getAllAccounts();
	ResponseEntity<?> createAccount(Account user);
	ResponseEntity<?> updateAccount(Account user);
	ResponseEntity<?> getAccountbyId(Long id);
	ResponseEntity<?> loadUserByUsername(String username);
}
