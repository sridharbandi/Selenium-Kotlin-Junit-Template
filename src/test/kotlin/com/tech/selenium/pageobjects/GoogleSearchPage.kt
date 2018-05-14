package com.tech.selenium.pageobjects

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GoogleSearchPage(driver: WebDriver) {

    private var _driver: WebDriver? = null

    @FindBy(id = "lst-ib")
    internal var _searchBox: WebElement? = null

    init {
        this._driver = driver
        PageFactory.initElements(_driver, this)
    }

    fun openURL() {
        _driver!!.get("https://www.google.com/")
    }

    fun searchFor(_searchTerm: String) {
        _searchBox!!.sendKeys(_searchTerm + Keys.RETURN)
    }
}