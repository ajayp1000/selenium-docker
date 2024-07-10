package com.ajayp.pages.venderportal;

import com.ajayp.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {

    private static  final Logger log= LoggerFactory.getLogger(DashboardPage.class);

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarning;

    @FindBy(id = "annual-earning")
    private WebElement annualEarning;

    @FindBy(id = "profit-margin")
    private WebElement profitMargin;

    @FindBy(id = "available-inventory")
    private WebElement availableInventory;

    @FindBy(css ="input[type='search']")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCountElement;

    @FindBy(css = "img.img-profile")
    private WebElement userProfilePicture;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal a")
    private WebElement logoutConfirm;
    public DashboardPage(WebDriver driver){
        super(driver);
    }
    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.monthlyEarning));
        return this.monthlyEarning.isDisplayed();
    }

    public String getMonthlyEarning(){
        return this.monthlyEarning.getText();
    }

    public String getAnnualEarning(){
        return this.annualEarning.getText();
    }

    public String getProfitMargin(){
        return this.profitMargin.getText();
    }

    public String getAvailableInventory(){
        return this.availableInventory.getText();
    }

    public void searchOrderHistoryBy(String keyword){
        this.searchInput.sendKeys(keyword);
    }

    public int getSearchResultsCount(){
        String resultsText = this.searchResultsCountElement.getText();
        String [] elements = resultsText.split(" ");
        int count = Integer.parseInt(elements[5]);
        log.info("Results Count : {} ",count);
        return count;
    }

    public void logout(){
        this.userProfilePicture.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
        this.logoutLink.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutConfirm));
        this.logoutConfirm.click();
    }

}
