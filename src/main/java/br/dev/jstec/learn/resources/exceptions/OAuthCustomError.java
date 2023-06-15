package br.dev.jstec.learn.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OAuthCustomError {
    private String error;
    @JsonProperty("error_description")
    private String errorDescription;
}
