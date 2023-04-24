package com.example.keycklockspring.Controllers;

import com.example.keycklockspring.DTO.OrgDTO;
import com.example.keycklockspring.DTO.UserDTO;
import com.example.keycklockspring.KeycklockConfig;
import com.example.keycklockspring.services.KeyCloakService;
import com.example.keycklockspring.services.UserService;
import com.sun.jdi.PrimitiveValue;
import io.phasetwo.client.openapi.model.OrganizationRepresentation;
import io.smallrye.common.constraint.NotNull;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BadRequestException;
import java.util.List;



@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {


@Autowired
    private UserService userService;
@Autowired
 private KeycklockConfig config;
@Autowired
    UserService use ;
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(UserController.class);



    @PostMapping("/create")
    public String createOrg(@RequestBody UserDTO userDTO) {




        return use.addUser(userDTO);
    }
    @PostMapping("/login")

    public ResponseEntity<AccessTokenResponse> login(@NotNull @RequestBody UserDTO userDTO) {
        Keycloak keycloak = config.newKeycloakBuilderWithPasswordCredentials(userDTO.getUserName(), userDTO.getPassword()).build();

        AccessTokenResponse accessTokenResponse = null;
        try {
            accessTokenResponse = keycloak.tokenManager().getAccessToken();
            return ResponseEntity.status(HttpStatus.OK).body(accessTokenResponse);
        } catch (BadRequestException ex) {
            LOG.warn("invalid account. User probably hasn't verified email.", ex);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(accessTokenResponse);
        }

    }




}
