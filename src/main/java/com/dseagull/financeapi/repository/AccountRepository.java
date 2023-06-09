package com.dseagull.financeapi.repository;

import com.dseagull.financeapi.document.Account;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;

public interface AccountRepository extends MongoRepository<Account, String> {

  Set<Account> findAllByUser(String id);

  @NonNull
  Optional<Account> findById(@NonNull String id);
}
