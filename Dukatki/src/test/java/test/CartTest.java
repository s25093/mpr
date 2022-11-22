package test;

import org.junit.Assert;
import org.junit.Test;
import po.NavigationBar;

public class CartTest extends BaseTest {

    @Test
    public void cartIsEmptyByDefault() {
        NavigationBar navigationBar = new NavigationBar(webDriver);
        Assert.assertEquals("0,00 zł", navigationBar.getCartStatus());
    }

    @Test
    public void cartPriceIsEqualToItemPrice() {

    }
}
