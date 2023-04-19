package org.tap.enrollment.controller.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tap.enrollment.entity.account.Account;
import org.tap.enrollment.model.request.account.AccountInfoRequest;
import org.tap.enrollment.service.account.AccountService;


@RestController                                                     /* This annotation indicates that it's a controller for a RESTful web service and that
																	 * the methods in the class should be mapped to specific HTTP endpoints
																	 */
@RequestMapping(value = "/account")                              // This annotation sets a base URL prefix for all the endpoint mappings in the class
public class AccountController {

	@Autowired
	private AccountService  accService;

	
	@GetMapping("/get-all-user")
	public ResponseEntity<?> getAllAccInfo(){
		return accService.getAllAccounts();
	}


	@GetMapping("/get-user/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable long id){
		return accService.getAccountbyId(id);
	}


	@GetMapping("/get-user/{username}")
	public ResponseEntity<?> getAccountByUsername(@PathVariable String username){
		return accService.loadUserByUsername(username);
	}


	@PostMapping("/create-user")
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountInfoRequest accountInfo){

		Account acc = new Account();
		acc.setUsername(accountInfo.getUsername());
		acc.setPassword(accountInfo.getPassword());
		acc.setRole(accountInfo.getRole());

		return accService.createAccount(acc);
	}


	@PutMapping("/update-user/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable long id, @RequestBody Account user){
		user.setId(id);
		return accService.updateAccount(user);
	}


	@DeleteMapping("/delete-user/{id}")
	public HttpStatus deleteCourse(@PathVariable Long id) {
		accService.deleteAccount(id);
		return HttpStatus.OK;
	}

}
