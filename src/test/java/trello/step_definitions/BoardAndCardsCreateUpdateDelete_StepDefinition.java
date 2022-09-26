package trello.step_definitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import trello.pojo.*;
import trello.request.Request;
import java.util.Random;

public class BoardAndCardsCreateUpdateDelete_StepDefinition {
    Response response;
    Request getRequest = new Request();
    Board trelloBoard;
    BoardList boardList;
    Card card1;
    Card card2;
    int randomInt;

    @Given("User send a POST request with {string} endpoint for create a new Organization which name is {string}")
    public void user_send_a_post_request_with_endpoint_for_create_a_new_organization_which_name_is(String endpoint, String organizationName) {
        response = getRequest.postOrganization(organizationName,endpoint);
    }

    @When("User send a POST request with {string} endpoint for create a new Board and board name should be {string}")
    public void user_send_a_post_request_with_endpoint_for_create_a_new_board_and_board_name_should_be(String endpoint, String boardName) {
        response = getRequest.postBoard(boardName,endpoint);
        trelloBoard = response.body().as(Board.class);
    }

    @Given("Verify that status code {int} and content type {string}")
    public void verify_that_status_code_and_content_type(Integer statusCode, String contentType) {
        response.then().assertThat().statusCode(statusCode).contentType(contentType);
    }

    @When("User send a POST request with {string} endpoint for create a new List which name is {string}, before create a Cards")
    public void user_send_a_post_request_with_endpoint_for_create_a_new_list_which_name_is_before_create_a_cards(String endpoint, String listName) {
        response = getRequest.postList(listName,endpoint,trelloBoard.getId());
        boardList = response.body().as(BoardList.class);
    }

    @When("Verify that status code {int} and List name equals {string}")
    public void verify_that_status_code_and_list_name_equals(Integer statusCode, String listName) {
        response.then().assertThat().statusCode(statusCode).body("name", Matchers.is(listName));
        Assert.assertEquals("List name is mismatch!!",boardList.getName(),listName);
    }

    @Then("User send a POST request with {string} endpoint for create two new Cards and cards name should be {string} and {string}")
    public void user_send_a_post_request_with_endpoint_for_create_two_new_cards_and_cards_name_should_be_and(String endpoint, String cardName1, String cardName2) {
        response = getRequest.postCard(cardName1,endpoint,boardList.getId());
        card1 = response.body().as(Card.class);
        response = getRequest.postCard(cardName2,endpoint,boardList.getId());
        card2 = response.body().as(Card.class);
    }

    @Then("Verify that status code {int} and card' names equal {string} and {string}")
    public void verify_that_status_code_and_card_names_equal_and(Integer statusCode, String cardName1, String cardName2) {
        response.then().statusCode(statusCode);
        Assert.assertEquals("Card name is not matching!",card1.getName(),cardName1);
        Assert.assertEquals("Card name is not matching!",card2.getName(),cardName2);
    }

    @Then("User send a PUT request with {string} endpoint for update one random card and updated card' name should be {string}")
    public void user_send_a_put_request_with_endpoint_for_update_one_random_card_and_updated_card_name_should_be(String endpoint, String updatedCardName) {
        randomInt = new Random().nextInt(2);
        if (randomInt==0){
            response = getRequest.putCard(updatedCardName,endpoint,card1.getId(),new Random().nextBoolean());
             card1 = response.body().as(Card.class);
        }else {
            response = getRequest.putCard(updatedCardName,endpoint,card2.getId(),new Random().nextBoolean());
            card2 = response.body().as(Card.class);
        }
    }

    @Then("Verify that status code {int} and updated card' names equal {string}")
    public void verify_that_status_code_and_updated_card_names_equal(Integer statusCode, String updatedCardName) {
        response.then().statusCode(statusCode);
        if (randomInt==0){
            Assert.assertEquals("Card name did not update successfully!",updatedCardName,card1.getName());
        }else {
            Assert.assertEquals("Card name did not update successfully!",updatedCardName,card2.getName());
        }
    }

    @Then("User send a DELETE request with {string} endpoint for delete a Cards")
    public void user_send_a_delete_request_with_endpoint_for_delete_a_cards(String endpoint) {
       response = getRequest.deleteCard(endpoint,card1.getId());
       response = getRequest.deleteCard(endpoint,card2.getId());
    }

    @Then("User send a DELETE request with {string} endpoint for delete a Board")
    public void user_send_a_delete_request_with_endpoint_for_delete_a_board(String endpoint) {
        response = getRequest.deleteBoard(endpoint,trelloBoard.getId());
    }
}
