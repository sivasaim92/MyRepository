package com.heroku;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected static WebDriver driver;
    protected URL url;
    public void beforeSuite() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:7080/");
    }
    @BeforeSuite
    public void setUpBrowser() throws MalformedURLException {

        if (System.getProperty("setUp").equalsIgnoreCase("cloud") || System.getProperty("setUp").equalsIgnoreCase("localhost")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            SafariOptions safariOptions = new SafariOptions();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platform", System.getProperty("operatingSystem"));
            capabilities.setCapability("version", "latest");
            capabilities.setCapability("browserName", System.getProperty("browser"));
            capabilities.setCapability("name", "lambda test");
            capabilities.setCapability("network", true);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("video", true);
            capabilities.setCapability("console", true);
            CapabilityInit.TakeObjectToCreateChrome platformOptions = (browser) -> {
                browser.setPlatformName(System.getProperty("operatingSystem"));
                browser.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Remote build on chrome");
                sauceOptions.put("name", "Remote test on chrome");
                browser.setCapability("sauce:options", sauceOptions);
                url = new URL(CapabilityInit.TakeObjectToCreateChrome.sauceUrl);
            };
            CapabilityInit.TakeObjectToCreateFirefox platformOptionsFireFox = (firefoxBrowser) -> {
                firefoxBrowser.setPlatformName(System.getProperty("operatingSystem"));
                firefoxBrowser.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Remote build on FireFox");
                sauceOptions.put("name", "Remote test on FireFox");
                firefoxBrowser.setCapability("sauce:options", sauceOptions);
            };
            CapabilityInit.TakeObjectToCreateSafari platformOptionsSafari = (safariBrowser) -> {
                safariBrowser.setPlatformName(System.getProperty("operatingSystem"));
                safariBrowser.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Remote build on Safari");
                sauceOptions.put("name", "Remote test on Safari");
                safariBrowser.setCapability("sauce:options", sauceOptions);
            };
            if(System.getProperty("platform").equalsIgnoreCase("saucelabs")) {

                if (System.getProperty("setUp").equalsIgnoreCase("cloud") && System.getProperty("browser").equalsIgnoreCase("chrome")) {
                    CapabilityInit.createCapability(platformOptions, chromeOptions);
                    driver = new RemoteWebDriver(url, chromeOptions);
                    driver.get("https://the-internet.herokuapp.com/");
                } else if (System.getProperty("setUp").equalsIgnoreCase("host") && System.getProperty("browser").equalsIgnoreCase("firefox")) {
                    CapabilityInit.createFireFoxCapability(platformOptionsFireFox, firefoxOptions);
                    url = new URL(CapabilityInit.TakeObjectToCreateFirefox.sauceUrl);
                    driver = new RemoteWebDriver(url, firefoxOptions);
                    driver.get("https://the-internet.herokuapp.com/");
                } else if (System.getProperty("setUp").equalsIgnoreCase("host") && System.getProperty("browser").equalsIgnoreCase("safari")) {
                    CapabilityInit.createSafariCapability(platformOptionsSafari, safariOptions);
                    url = new URL(CapabilityInit.TakeObjectToCreateSafari.sauceUrl);
                    driver = new RemoteWebDriver(url, safariOptions);
                    driver.get("https://the-internet.herokuapp.com/");
                }
            } else if(System.getProperty("platform").equalsIgnoreCase("lambdatest")) {
                url = new URL(CapabilityInit.TakeObjectToCreateSafari.lambdaurl);
                driver = new RemoteWebDriver(url, capabilities);
                driver.get("https://the-internet.herokuapp.com/");
            }
        } else if (System.getProperty("setUp").equalsIgnoreCase("localhost")) {
            if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.get("http://localhost:7080/");
            } else if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.get("http://localhost:7080/");
            } else if (System.getProperty("browser").equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                driver.get("http://localhost:7080/");
            }
        }
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Are we closing driver?");
        driver.quit();
    }
}
