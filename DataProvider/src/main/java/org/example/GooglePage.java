package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class GooglePage {
    private WebDriver driver;

    @Test(dataProvider = "searchData")
    public void test_searchQuery(String searchQuery) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys(searchQuery + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleContains(searchQuery));
        Assert.assertTrue(driver.getTitle().contains(searchQuery));
        driver.quit();
    }

    @DataProvider(name = "searchData", indices = {0, 2})
    public String[] searchData() {
        String[] searchTerms = {"Google", "Oracle", "Microsoft", "Perplexity"};
        return searchTerms;
    }
}