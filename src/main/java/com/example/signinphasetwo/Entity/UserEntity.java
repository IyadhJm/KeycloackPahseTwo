package com.example.signinphasetwo.httpRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private String userName;

    private String email;
    private String password;
    private String id;
private String orgId;
    private String realm;






}
