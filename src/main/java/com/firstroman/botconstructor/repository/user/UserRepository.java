package com.firstroman.botconstructor.repository.user;

import com.firstroman.botconstructor.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByLogin(String login);
}
