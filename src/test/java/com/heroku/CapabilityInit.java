package com.heroku;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;

public class CapabilityInit<T extends MutableCapabilities> {

    interface TakeObjectToCreateChrome {
        void absFunction(ChromeOptions platform) throws MalformedURLException;
        static String sauceUrl = "https://oauth-sivasaim92-79ae9:1ff3a5d6-f2fa-494e-b1c9-b1e31a66bb5b@ondemand.us-west-1.saucelabs.com:443/wd/hub";
        static String lambdaurl = "https://sivasaikumar534:W79OU5J4oCLLsokmEEmvXIGNVaiPonO3p43r6nt9XRNqHl81j0@hub.lambdatest.com/wd/hub";
    }
    public static void createCapability(TakeObjectToCreateChrome platformOptions, ChromeOptions specificBrowserOption) throws MalformedURLException {
        platformOptions.absFunction(specificBrowserOption);
    }
    interface TakeObjectToCreateFirefox {
        void absFunction1(FirefoxOptions platform) throws MalformedURLException;
        static String sauceUrl = "https://oauth-sivasaim92-79ae9:1ff3a5d6-f2fa-494e-b1c9-b1e31a66bb5b@ondemand.us-west-1.saucelabs.com:443/wd/hub";
        static String lambdaurl = "https://sivasaikumar534:W79OU5J4oCLLsokmEEmvXIGNVaiPonO3p43r6nt9XRNqHl81j0@hub.lambdatest.com/wd/hub";
    }
    public static void createFireFoxCapability(TakeObjectToCreateFirefox platformOptionsFireFox, FirefoxOptions specificBrowserOption) throws MalformedURLException {
        platformOptionsFireFox.absFunction1(specificBrowserOption);
    }
    interface TakeObjectToCreateSafari {
        void absFunction2(SafariOptions platform);
        static String sauceUrl = "https://oauth-sivasaim92-79ae9:1ff3a5d6-f2fa-494e-b1c9-b1e31a66bb5b@ondemand.us-west-1.saucelabs.com:443/wd/hub";
        static String lambdaurl= "https://sivasaikumar534:W79OU5J4oCLLsokmEEmvXIGNVaiPonO3p43r6nt9XRNqHl81j0@hub.lambdatest.com/wd/hub";
    }
    public static void createSafariCapability(TakeObjectToCreateSafari platformOptionsSafari, SafariOptions specificBrowserOption) {
        platformOptionsSafari.absFunction2(specificBrowserOption);
    }
}

