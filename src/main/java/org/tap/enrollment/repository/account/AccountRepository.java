package org.tap.enrollment.repository.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tap.enrollment.entity.account.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Optional<Account> findByUsername(@Param("username")String username);
}

