package com.screenply.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox {
    public static Target SEARCH_FIELD = Target.the("search field").located(By.id("txtSearch"));
    public static Target text = Target.the("expeced field").located(By.xpath("//div[@class='cb18w4 hijax cb18filtersloaded']//strong"));
    public static Target Customlist = Target.the("expeced field").located(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']"));
}
