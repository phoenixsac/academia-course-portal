package com.miniproject.courseupdationdeletion.RequestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrereqReqBody {

    @JsonProperty("course_id")
    private Long prereqId;

    @JsonProperty("description")
    private String description;

}
