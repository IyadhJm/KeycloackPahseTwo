package com.example.signinphasetwo.httpRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class OrgDTO {


    private String name;


    private String id;

    private String realm;
    private String displayName;
    private String url;
    private String domain;
    private String attributes;





}
