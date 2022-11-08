package Pages;

import helpers.ReusableFunc;
import helpers.WebActions;
import helpers.ReusableFunc;
import helpers.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class TestScenarioOnePage extends TestBase{





    @FindBy(id = "menu-category--706522961-dropdown-outer")
    public WebElement menu_Launcher;

    @FindBy(xpath = "//div/h4[text()=' Shop ']")
    public WebElement menu_shop;

    @FindBy(id = "menu-navigation-main-nav-search-icon-img")
    public WebElement search_icon;

    @FindBy(id = "menu-search-overlay-search-icon")
    public WebElement inside_search_icon;

    @FindBy(xpath = "//a[@href='/shopping/deal-details-page/DV2I26DAAM?contractSkus=DV2I26DAGI&contractSkus=DV2I26DAAM'] ")
    public WebElement product_link;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptAll_btn;






    @FindBy(xpath = "//a[text()=' Online Exclusive Deals ']")
    public WebElement OnlineExclusiveDeals_linkText;

    @FindBy(xpath = "//button/span[text()='Do Upgrade']")
    public WebElement DoUpgrade_btn;


    @FindBy(xpath = "//div[@class='v-progressbar-indicator']")
    public WebElement progressIndicator_bar;

    @FindBy(id = "Status-Field")
    public WebElement status_txt;

    @FindBy(id = "TimeStarted-Field")
    public WebElement timeStarted_datePicker;

    @FindBy(id = "Description-Field")
    public WebElement description_txt;
    @FindBy(xpath = "//div[contains(@class,'DealCard_image-text-content')]//span[@class='title']")
    public List <WebElement> descProd;
    @FindBy(xpath = "//div[contains(@id,'See details-btn-deals')]/button/span")
    public List<WebElement> seeDetails;

    @FindBy(xpath = "//div[text()='Samsung Galaxy A33 5G DS']")
    public List<WebElement> selectedDevice_txt;

    @FindBy(xpath = "//div[text()='Deal price']")
    public List<WebElement> dealPrice_field;

    @FindBy(xpath = "//div[text()='Contract duration']")
    public List<WebElement> contractDuration_field;

    @FindBy(xpath = "//div[text()='Available online']")
    public List<WebElement> availableOnline_field;

    @FindBy(xpath = "//button[text()='Get this deal']")
    public List<WebElement> getThisDeal_btn;






    public void cockiesBtn()throws Exception{

        Boolean CookieIsPresent = this.driver.findElements(By.xpath("//button[@id='onetrust-accept-btn-handler']")).size() > 0;
        if (CookieIsPresent){
            ReusableFunc.waitForElementToAppear(driver,acceptAll_btn);
            WebActions.waitForElementVisible(driver, acceptAll_btn, "cookie_popup",  30);
            acceptAll_btn.click();
            //helpers.ReusableFunc.waitForElementToAppear(driver,cockie_popup);
        } else  {
            System.out.println("all good");
            //helpers.ReusableFunc.waitForElementToAppear(driver,cockie_popup);
        }

    }


    public boolean selectProductByName(String name)throws Exception{

        boolean productSelected=false;


        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'DealCard_image-text-content')]//span[@class='title']"));
        System.out.println(list.size());
        System.out.println(list);


        for( int i=0;i<list.size();i++){
            System.out.println( list.get(i).getText());

            if (list.get(i).getText().contains(name)) {
                ReusableFunc.click(list.get(i));
                productSelected=true;


                break;
            }

        }

return productSelected;

    }


    public boolean Verify_device_details() throws Exception {

        try {
            cockiesBtn();

            WebActions.waitForElementClickable(driver,menu_shop,"menu_shop",120);
            menu_shop.click();
            WebActions.waitForElementClickable(driver,OnlineExclusiveDeals_linkText,"OnlineExclusiveDeals_linkText",120);
            OnlineExclusiveDeals_linkText.click();


        } finally {

        }


        return false;
    }











    public TestScenarioOnePage(WebDriver driver) {

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 120), this);
        this.driver = driver;

    }

}


