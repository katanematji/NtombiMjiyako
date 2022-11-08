package Tests;

import Pages.TestBase;
import Pages.TestScenarioOnePage;
import helpers.ReusableFunc;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestScenarioOneTest extends TestBase {

    TestScenarioOnePage testScenarioOnePage;
    public String testName = "";
    public String Name;





    @BeforeClass
    public void before() throws Exception {

        super.before();
        getWebDriver().get(Get_QA_URL());
        testScenarioOnePage = new TestScenarioOnePage(driver);
        String className = this.getClass().getSimpleName();
        parentTest = extent.createTest(className);




    }




    @SneakyThrows
    @Test(alwaysRun = true)
    public void Verify_device_details() throws Exception {

        try {



            extent.createNode(parentTest,"load product");
            testScenarioOnePage.Verify_device_details();
            extent.info("Navigated to the correct page",true);

            if (testScenarioOnePage.selectProductByName ("Samsung Galaxy A33 5G DS")){

                extent.pass("product selected successfully",true);
            }
            else
                extent.fail("unable to load product",true);













            } catch (Exception e){
            e.printStackTrace();

        }
    }
}