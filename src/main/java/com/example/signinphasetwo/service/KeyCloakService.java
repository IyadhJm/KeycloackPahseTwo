package com.example.keycklockspring.services;

import com.example.keycklockspring.DTO.OrgDTO;
import com.example.keycklockspring.KeycklockConfig;
import io.phasetwo.client.OrganizationMembershipsResource;
import io.phasetwo.client.OrganizationResource;
import io.phasetwo.client.OrganizationsResource;
import io.phasetwo.client.PhaseTwo;
import io.phasetwo.client.openapi.model.OrganizationRepresentation;
import io.phasetwo.client.openapi.model.UserRepresentation;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class KeyCloakService  {
@Autowired
KeycklockConfig keycklockConfig;
    public String addOrg(OrgDTO orgDTO) {
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());

        OrganizationRepresentation organizationRepresentation = new OrganizationRepresentation().name(orgDTO.getName());

        //organizationRepresentation.setName(orgDTO.getName());

        OrganizationsResource orgs = phaseTwo.organizations(keycklockConfig.getREALM());

        String orgId = orgs.create(organizationRepresentation);







        return orgId;
    }




    public List<OrganizationRepresentation >gettOrg() {
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());

        List<OrganizationRepresentation> organizations = phaseTwo.organizations(keycklockConfig.REALM).get();

        return  organizations;
    }



}
