package com.tech.selenium.driverutil

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.opera.OperaDriver
import java.util.concurrent.TimeUnit

object DriverFactory {

    val browser: WebDriver
        get() {

            var _driver: WebDriver
            val _browserName = System.getProperty("browser", DriverType.CHROME.toString()).toUpperCase()
            val _driverType = DriverType.valueOf(_browserName)

            when (_driverType) {
                DriverType.CHROME -> {
                    WebDriverManager.chromedriver().setup()
                    _driver = ChromeDriver()
                }
                DriverType.FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup()
                    _driver = FirefoxDriver()
                }
                DriverType.EDGE -> {
                    WebDriverManager.edgedriver().setup()
                    _driver = EdgeDriver()
                }
                DriverType.IE -> {
                    WebDriverManager.iedriver().setup()
                    _driver = InternetExplorerDriver()
                }
                DriverType.OPERA -> {
                    WebDriverManager.operadriver().setup()
                    _driver = OperaDriver()
                }
            }

            _driver.manage().window().maximize()
            _driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
            return _driver
        }
}