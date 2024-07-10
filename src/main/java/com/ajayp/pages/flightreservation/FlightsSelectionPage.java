package com.ajayp.pages.flightreservation;

import com.ajayp.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsSelectionPage extends AbstractPage {

    @FindBy(id = "dep-emirates-first")
    private WebElement departureFlightOptions;

    @FindBy(id = "arr-emirates-first")
    private WebElement arrivalFlightsOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightsSelectionPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        return this.confirmFlightsButton.isDisplayed();
    }

    public void selectFlights(){
        this.departureFlightOptions.click();
        WebElement element = driver.findElement(By.id("arr-emirates-first"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

    }

    public void confirmFlights(){
        WebElement element = driver.findElement(By.id("confirm-flights"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
}
