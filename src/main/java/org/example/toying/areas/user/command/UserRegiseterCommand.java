package org.example.toying.areas.user.command;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegiseterCommand {
    private String userId;
    private String username;
    private String password;
    private String role;
}
