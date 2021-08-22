package com.firstroman.botconstructor.changelog;

import com.firstroman.botconstructor.model.Role;
import com.firstroman.botconstructor.repository.role.RoleRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

@ChangeLog
public class ChangeLogRole {

    @ChangeSet(order = "001", id = "insertData", author = "FirstRoman", runAlways = false)
    public void changeSet(RoleRepository roleRepository) {
        Role role = new Role();
        role.setRole("ROLE_USER");
        roleRepository.save(role);
    }
}
