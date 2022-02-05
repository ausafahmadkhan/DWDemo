package com.dropwizard.demo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User
{
    @Id
    private String id = UUID.randomUUID().toString();

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    @JsonProperty
    private String email;
}
