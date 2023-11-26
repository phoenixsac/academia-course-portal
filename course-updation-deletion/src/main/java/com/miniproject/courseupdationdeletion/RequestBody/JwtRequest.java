package com.miniproject.courseupdationdeletion.RequestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class JwtRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;


    @JsonProperty("password")
    private String password;

    @JsonProperty("type")
    private String type;
}