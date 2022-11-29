package com.gemini.mobile.selectors;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MobileXpath
{
    public static By appHeader = AppiumBy.xpath("//android.widget.TextView[@resource-id='io.perfecto.expense.tracker:id/tv_login_head']");
    public static By expensesPage = AppiumBy.xpath("//android.widget.ImageButton[@id='io.perfecto.expense.tracker:id/list_add_btn']");

    public static By btn(String btnName){
        return AppiumBy.xpath("//android.widget.Button[@resource-id='io.perfecto.expense.tracker:id/"+btnName+"']");
    }
    public static By textField(String textField){
        return AppiumBy.xpath("//android.widget.EditText[@resource-id='io.perfecto.expense.tracker:id/signup_"+textField+"']");
    }

    public static By loginField(String textField){
        return AppiumBy.xpath("//android.widget.EditText[@resource-id='io.perfecto.expense.tracker:id/"+textField+"']");
    }

    public static By dropdown(String field){
        return AppiumBy.xpath("//android.widget.Spinner[@resource-id='io.perfecto.expense.tracker:id/signup_"+field+"']");
    }
    public static By dropdownValue(int num){
        return AppiumBy.xpath("(//android.widget.TextView[@resource-id='android:id/text1'])["+num+"]");
    }




}
