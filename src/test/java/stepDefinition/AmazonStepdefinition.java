package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmazonStepdefinition extends BaseCLass {

    @Given("User is in the Home Page")
    public void user_is_in_the_home_page() {
        setUpDriver("Chrome");
    }

    @And("Go to search bar and search for mobiles")
    public void go_to_search_bar_and_search_for_mobiles() {
        pageFactory.getCartPage().clickOnSearchBar();

    }

    @And("Select one mobile and console its name")
    public void select_one_mobile_and_console_its_name() {
        pageFactory.getCartPage().clickOnMobile();
    }

    @And("Check and console size,color")
    public void check_and_console_size_color() {
        pageFactory.getCartPage().displayingProducts();
    }

    @And("Go to customer question & answer section and print top three question and answers")
    public void go_to_customer_question_answer_section_and_print_top_question_and_answers() {
        pageFactory.getCartPage().searchedProductColour();
    }

    @And("Add item to cart and also verify it in the cart")
    public void add_item_to_cart_and_also_verify_it_in_the_cart() throws InterruptedException {
        pageFactory.getCartPage().addProductInTheCart();
    }

    @And("Go to shopping cart and increase the quantity")
    public void go_to_shopping_cart_and_increase_the_quantity() {
        pageFactory.getCartPage().verifyProductInTheCart();
    }

    @Then("Verify the item in the cart and console the total amount of product")
    public void verify_the_item_in_the_cart_and_console_the_total_amount_of_product() {
        pageFactory.getCartPage().goToTheCart();
    }

}

