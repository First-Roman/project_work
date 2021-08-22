package com.firstroman.botconstructor.repository.preference;

import com.firstroman.botconstructor.model.UserPreference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPreferenceRepository extends MongoRepository<UserPreference, String> {

    UserPreference findByLogin(String login);

    UserPreference findByUserToken(String userToken);
}
