package pkg1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenDemo {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 String recodata="(//div[@class='swiper-wrapper'])[4]/div/div/a/div/div/div[2]/div[1]/span";
		WebDriverManager.chromedriver().setup();
		// System.setProperty("WebDriver.chrome.driver" , "C:\\Users\\Ajinkya
		// Patil\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.noon.com/uae-en/");
		dataforyou(recodata);

		

	}
	public static void dataforyou(String data)
	{
		List<WebElement> alldata = driver
				.findElements(By.xpath(data));
		WebElement swiper = driver.findElement(By.xpath("(//div[@data-qa='widget_productCarousel']/div)[2]/div[2]"));
		

			for (WebElement single : alldata) {
				System.out.println(single.getText());
			}

			if (swiper.isEnabled() == true) 
				swiper.click();
			else  System.out.println("Finish data");
	}

}
