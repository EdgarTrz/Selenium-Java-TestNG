package TestNG;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AppTest1 {

    private String url = "https://cosmobellezamexico.com/";
    WebDriver driver;

    @BeforeMethod
    public void setUrl() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @Test
    public void Test1_Tittle() {
        String expectedTitle = "Cosmo Belleza";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void Test2_CarSale() {
        WebElement image1 = driver.findElement(By.cssSelector("img[alt='Colorton-Gel-y-Polvo-Dark-Brown']"));
        image1.click();
        WebElement button1 = driver.findElement(By.id("tono"));
        button1.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Selector1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='Medium Brown']")));
        Selector1.click();

        WebElement buttonCar = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        buttonCar.click();
    }

    @Test
    public void Test3_Car2Sale() {
        WebElement image1 = driver.findElement(By.cssSelector("img[alt='Colorton-Gel-y-Polvo-Dark-Brown']"));
        image1.click();
        WebElement button1 = driver.findElement(By.id("tono"));
        button1.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Selector1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='Medium Brown']")));
        Selector1.click();

        WebElement buttonCar = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        buttonCar.click();

        //WebElement button1_2 = driver.findElement(By.xpath("//*[@id=\"product-7161\"]/section/ul/li[3]/div[1]/a/img"));
        //button1_2.click();
        String[] xpathsOpciones = {
                "//*[@id=\"product-7161\"]/section/ul/li[1]",
                "//*[@id=\"product-7161\"]/section/ul/li[2]",
                "//*[@id=\"product-7161\"]/section/ul/li[3]"
        };
        //Iterar sobre cada Xpath y verificar si cada opcion esta agotada
        WebElement ProductOpcion = null;
        for (String xpath : xpathsOpciones) {
            WebElement producto = driver.findElement(By.xpath(xpath));
            try {
                // Intentar encontrar la etiqueta de agotado dentro del producto
                WebElement etiquetaAgotado = producto.findElement(By.xpath(".//span[contains(@class, 'ast-shop-product-out-of-stock')]"));
            } catch (NoSuchElementException e) {
                // Si no se encuentra la etiqueta de agotado, la opción no está agotada
                ProductOpcion = producto;
                break;
            }
        }
        //validacion de producto
        if (ProductOpcion != null) {
            ProductOpcion.click();
            System.out.println("Se ha seleccionado una opción no agotada.");
        } else {
            System.out.println("No se encontraron opciones no agotadas.");
        }
        //agregar el 2 producto al carrito
        buttonCar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.single_add_to_cart_button")));
        buttonCar.click();

        //identificar que el carrito tenga 2 productos
        try {
            // Wait until the text of the element is equal to "2"
            WebElement numberCar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='astra-icon ast-icon-shopping-cart '][@data-cart-total='2']")));
            // Once the text is "2", you can proceed with the necessary operations
            System.out.println("The number in the cart is 2.");
        } catch (TimeoutException e) {
            // Handle the case where the text of the element is not "2" within the timeout
            System.out.println("The text of the NumberCar element is not '2' within the timeout.");
            Assert.fail("The text of the NumberCar element is not '2' within the timeout.");
        }

    }

    @Test
    public void Test4_searchBar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement searchInputBar = driver.findElement(By.id("dgwt-wcas-search-input-1"));
        searchInputBar.sendKeys("shampoo");
       WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"menu-item-4910\"]/div/form/div/button"));
       searchButton.click();
       //Search selection product
        WebElement productSearch = driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li[1]/div[1]/a/img"));
        productSearch.click();
        WebElement buttonCar = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
        buttonCar.click();
        //validation Car
        try {
            // Wait until the text of the element is equal to "1"
            WebElement numberCar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='astra-icon ast-icon-shopping-cart '][@data-cart-total='1']")));
            // Once the text is "1", you can proceed with the necessary operations
            System.out.println("The number in the cart is 1.");
        } catch (TimeoutException e) {
            // Handle the case where the text of the element is not "2" within the timeout
            System.out.println("The text of the NumberCar element is not '1' within the timeout.");
            Assert.fail("The text of the NumberCar element is not '1' within the timeout.");
        }

    }
    @AfterMethod
    public void closeSession() {
        //driver.quit();
    }
}
