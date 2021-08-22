package com.firstroman.botconstructor.service.security;

import com.firstroman.botconstructor.dto.RegistryDTO;
import com.firstroman.botconstructor.exception.UserRegistryException;

public interface UserRegistry {

    void registry(RegistryDTO registryDTO) throws UserRegistryException;
}
