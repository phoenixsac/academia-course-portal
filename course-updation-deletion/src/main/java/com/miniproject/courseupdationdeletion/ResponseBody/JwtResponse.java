package com.miniproject.courseupdationdeletion.ResponseBody;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

    private String jwtToken;
    private String username;

    // Constructors, getters, and setters

    // Builder pattern for creating instances
    public static Builder builder() {
        return new Builder();
    }

    // Builder class to facilitate constructing instances
    public static class Builder {

        private String jwtToken;
        private String username;

        public Builder() {
        }

        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            JwtResponse response = new JwtResponse();
            response.setJwtToken(jwtToken);
            response.setUsername(username);
            return response;
        }
    }


}
