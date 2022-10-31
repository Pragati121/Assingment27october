package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DataTableStepDefinition extends BaseCLass{
   By clickOnACcountAndList = By.xpath("//span[@class='nav-line-2 ']") ;
   By enterPhoneNumber = By.xpath("//input[@name='email']");
   By clickOnCountinue = By.xpath("//input[@type='submit']");
   By enterPassword = By.xpath("//input[@name='password']");
    @Given("User is on Home Page")
    public void user_is_on_home_page() throws IOException {
     Setup();
    }
    @And("User click on Accounts and lists")
    public void user_click_on_accounts_and_lists() {
     driver.findElement(clickOnACcountAndList).click();
    }
    @When("User entered phone number and password")
    public void user_entered_phone_number_and_password(DataTable table) {
     List<List<String>> data = Collections.singletonList(table.values());
     driver.findElement(enterPhoneNumber).sendKeys(data.get(0).get(0));
     driver.findElement(clickOnCountinue).click();
    }
    @Then("User has signed in and user is again on the home page")
    public void user_has_signed_in_and_user_is_again_on_the_home_page(DataTable table) {
     driver.findElement(enterPassword).click();
     List<List<String>> data = Collections.singletonList(table.values());
     driver.findElement(enterPassword).sendKeys(data.get(0).get(1));
    }
}
