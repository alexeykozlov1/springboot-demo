package com.spring.springselenium.googletest;

import com.spring.springselenium.page.google.GooglePage;
import com.spring.springselenium.SpringBaseTestNGTest;
import com.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.spring.springselenium.kelvin.service.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 25);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }

}
