package trello.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Lombok dependency helps to create automatically all the variable's getter,setter and also toString methods
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardList {
    /**
     * if the variable name includes such as space or not allowed characters @JsonProperty() this annotation help us to match variables during the deserialization and serialization
     */
    private String id;
    @JsonProperty("name")
    private String name;
    private Boolean closed;
    private String idBoard;
    private Object pos;

}
