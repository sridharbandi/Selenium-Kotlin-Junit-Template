package com.tech.selenium.pageobjects

import org.junit.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SearchResultsPage(driver: WebDriver) {

    private var _driver: WebDriver? = null

    @FindBy(linkText = "Selenium - Web Browser Automation")
    internal var _lnkSelenium: WebElement? = null

    init {
        this._driver = driver
        PageFactory.initElements(_driver, this)
    }

    fun assertSeleniumPresent() {
        Assert.assertTrue(_lnkSelenium!!.isDisplayed)
    }
}