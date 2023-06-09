package com.dseagull.financeapi.repository;

import com.dseagull.financeapi.document.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByUsername(String mail);

  boolean existsByUsername(String mail);
}
