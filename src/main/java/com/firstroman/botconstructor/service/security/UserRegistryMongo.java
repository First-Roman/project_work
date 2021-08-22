package com.firstroman.botconstructor.service.security;

import com.firstroman.botconstructor.dto.RegistryDTO;
import com.firstroman.botconstructor.exception.UserRegistryException;
import com.firstroman.botconstructor.model.Role;
import com.firstroman.botconstructor.model.User;
import com.firstroman.botconstructor.model.UserPreference;
import com.firstroman.botconstructor.repository.preference.UserPreferenceRepository;
import com.firstroman.botconstructor.repository.role.RoleRepository;
import com.firstroman.botconstructor.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserRegistryMongo implements UserRegistry {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserPreferenceRepository userPreferenceRepository;

    @Override
    public void registry(RegistryDTO registryDTO) throws UserRegistryException {
        UserPreference userPreference = validator(registryDTO);
        User user = new User();
        user.setPassword(bCryptPasswordEncoder.encode(registryDTO.getPassword()));
        user.setLogin(registryDTO.getUsername());
        Role role = roleRepository.findByRole("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        userPreference.setLogin(user.getLogin());
        userPreferenceRepository.save(userPreference);
    }

    private UserPreference validator(RegistryDTO registryDTO) throws UserRegistryException {
        User user = userRepository.findUserByLogin(registryDTO.getUsername());
        if (user != null) {
            throw new UserRegistryException("Некорректный логин, необходимо изменить!");
        }
        UserPreference userPreference = userPreferenceRepository.findByUserToken(registryDTO.getUserToken());
        if (userPreference == null) {
            throw new UserRegistryException("Некорректный токен, возможно вы не зарегистрировались в t.me/Easy_Bot_Constructor_bot");
        }
        if (!registryDTO.getPassword().equals(registryDTO.getPassword2())) {
            throw new UserRegistryException("Пароли не совпадают!");
        }
        if (registryDTO.getPassword().length() < 6) {
            throw new UserRegistryException("Длина пароля меньше 6 символов!");
        }
        return userPreference;
    }
}
