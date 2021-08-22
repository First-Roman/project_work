package com.firstroman.botconstructor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "role")
public class Role implements GrantedAuthority {

    @Id
    private long id;

    private String role;

    @Override
    public String getAuthority() {
        return this.getRole();
    }
}
