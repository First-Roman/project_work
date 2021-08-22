package com.firstroman.botconstructor.repository.role;

import com.firstroman.botconstructor.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
