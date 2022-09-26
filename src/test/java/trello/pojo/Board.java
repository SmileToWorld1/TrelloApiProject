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
/**
 * @JsonIgnoreProperties(ignoreUnknown = true) => this means that while the deserialization, unwanted variable' are not allowed to take in this class object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {
    /**
     * if the variable name includes such as space or not allowed characters @JsonProperty() this annotation help us to match variables during the deserialization and serialization
     */
    @JsonProperty("id")
    private String id;
    private String name;
    private String desc;
    private boolean closed;
    private String idOrganization;
    private String url;
    private String shortUrl;

}
