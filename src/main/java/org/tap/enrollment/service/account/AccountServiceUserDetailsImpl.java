package org.tap.enrollment.service.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tap.enrollment.entity.account.Account;
import org.tap.enrollment.genericresponse.GenericResponseEntity;
import org.tap.enrollment.repository.account.AccountRepository;


@Service
@Transactional
public class AccountServiceUserDetailsImpl implements AccountService{
	
    @Autowired
    private AccountRepository accRepository;
    
    public ResponseEntity<?> createAccount(Account user) {
    	Optional<Account> userDb = this.accRepository.findById(user.getId());
		if(userDb.isPresent()) {
			return GenericResponseEntity.forbiddenEntity("This account already exists.");
		}
		else {
			return GenericResponseEntity.createSuccessEntity(accRepository.save(user));
		}
	}
    
    @Override
    public ResponseEntity<?> loadUserByUsername(String username){
    	
        Optional <Account> user = this.accRepository.findByUsername(username);
        if(user.isPresent()) {
        	return GenericResponseEntity.createSuccessEntity(user.get());
        }
        else {
        	return GenericResponseEntity.notFoundEntity("Record not found with username: " + username);
        }
    }
    
    @Override
	public ResponseEntity<?> updateAccount(Account user) {
		Optional<Account> accDb = this.accRepository.findById(user.getId());
		if(accDb.isPresent()) {
			Account accUpdate = accDb.get();
			accUpdate.setId(user.getId());
			accUpdate.setUsername(user.getUsername());
			accUpdate.setPassword(user.getPassword());
			accUpdate.setRole(user.getRole());
			accRepository.save(accUpdate);
			return GenericResponseEntity.createSuccessEntity(accUpdate);
		}
		else {
			return GenericResponseEntity.notFoundEntity("Record not found with id: " + user.getId());
		}
	}


	@Override
	public ResponseEntity<?> getAllAccounts() {
		List<Account> accDb = this.accRepository.findAll();

		if(accDb.isEmpty()) {
			return GenericResponseEntity.notFoundEntity("There are no records found in this table.");
		}else {
			return GenericResponseEntity.createSuccessEntity(accRepository.findAll());
		}
	}


	@Override
	public ResponseEntity<?> getAccountbyId(Long id) {
		Optional<Account> accDb = this.accRepository.findById(id);

		if(accDb.isPresent()) {
			return GenericResponseEntity.createSuccessEntity(accDb.get());
		}else {
			return GenericResponseEntity.notFoundEntity("Record not found with id: " + id);
}
	}


	@Override
	public void deleteAccount(Long id) {
		Optional<Account> accDb = this.accRepository.findById(id);

		if(accDb.isPresent()) {
			this.accRepository.delete(accDb.get());
		}else {
			GenericResponseEntity.notFoundEntity("Record not found with id: " + id);
		}
	}

}