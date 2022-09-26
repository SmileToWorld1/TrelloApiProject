package trello.request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import trello.utilities.ConfigurationReader;

public class Request {
    Response response;
    /**
     * Actually without request body, contentType(ContentType.JSON) this method is useless but while when I run the
     * @param organizationName
     * @param endpoint
     * @return
     */
    public Response postOrganization(String organizationName, String endpoint){
        response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParams("displayName",organizationName,"key",
                        ConfigurationReader.getProperty("key"),"token", ConfigurationReader.getProperty("token"))
                .when()
                .post(endpoint);
        return response;
    }

    public Response postBoard(String boardName, String endpoint){
        response = RestAssured.given()
                                    .accept(ContentType.JSON)
                                    .contentType(ContentType.JSON)
                                    .queryParams("name",boardName,"key",
                                            ConfigurationReader.getProperty("key"),"token", ConfigurationReader.getProperty("token"))
                                .when()
                                     .post(endpoint);
        return response;
    }

    public Response postList(String listName, String endpoint,String idBoard){
        response = RestAssured.given()
                                    .accept(ContentType.JSON)
                                    .contentType(ContentType.JSON)
                                    .queryParams("name",listName,"idBoard",idBoard,"key",
                                            ConfigurationReader.getProperty("key"),"token", ConfigurationReader.getProperty("token"))
                                .when()
                                    .post(endpoint);
        return response;
    }

    public Response postCard(String cardName, String endpoint, String idList){
        response = RestAssured.given()
                                    .accept(ContentType.JSON)
                                    .contentType(ContentType.JSON)
                                    .queryParams("name",cardName, "idList", idList, "key",
                                            ConfigurationReader.getProperty("key"),"token", ConfigurationReader.getProperty("token"))
                                .when()
                                     .post(endpoint);
        return response;
    }

    public Response putCard(String updatedCardName, String endpoint, String idCard, boolean closed){
        response = RestAssured.given()
                                    .accept(ContentType.JSON)
                                    .contentType(ContentType.JSON)
                                    .pathParam("id",idCard)
                                    .queryParams("name",updatedCardName, "closed", closed, "key", ConfigurationReader.getProperty("key"),
                                            "token", ConfigurationReader.getProperty("token"))
                                .when()
                                    .put(endpoint);
        return response;
    }

    public Response deleteCard(String endpoint, String idCard){
        response = RestAssured.given()
                                    .pathParam("id",idCard)
                                    .queryParams("key", ConfigurationReader.getProperty("key"),
                                            "token", ConfigurationReader.getProperty("token"))
                                .when()
                                    .delete(endpoint);
        return response;
    }

    public Response deleteBoard(String endpoint, String idBoard){
        response = RestAssured.given()
                                    .pathParam("id",idBoard)
                                    .queryParams("key", ConfigurationReader.getProperty("key"),
                                            "token", ConfigurationReader.getProperty("token"))
                                .when()
                                    .delete(endpoint);
        return response;
    }
}
