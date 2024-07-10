package com.ajayp.tests.vendorportal.model;

public class VendorPortalTestData {
    private String username;
    private String password;
    private String monthlyEarning;
    private String annualEarning;
    private String profitMargin;
    private String availableInventory;
    private String searchKeyword;
    private long searchResultsCount;

    public VendorPortalTestData(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public String getMonthlyEarning() {
        return monthlyEarning;
    }

    public void setMonthlyEarning(String value) {
        this.monthlyEarning = value;
    }

    public String getAnnualEarning() {
        return annualEarning;
    }

    public void setAnnualEarning(String value) {
        this.annualEarning = value;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(String value) {
        this.profitMargin = value;
    }

    public String getAvailableInventory() {
        return availableInventory;
    }

    public void setAvailableInventory(String value) {
        this.availableInventory = value;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String value) {
        this.searchKeyword = value;
    }

    public long getSearchResultsCount() {
        return searchResultsCount;
    }

    public void setSearchResultsCount(long value) {
        this.searchResultsCount = value;
    }


}
