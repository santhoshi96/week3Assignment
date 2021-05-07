package Week3.day2.assignment;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelenium {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MSB");
		fromStation.sendKeys(Keys.TAB);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("KKDI");
		toStation.sendKeys(Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		driver.findElement(By.id("buttonFromTo")).click();
		Map<String, String> map = new TreeMap<String, String>();
		List<WebElement> table = driver.findElementsByXPath("//table[contains(@class,'DataTable TrainList')]");
		System.out.println("Table Size: " + table.size());
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr"));
		System.out.println("Row size: " + rows.size());
		List<WebElement> column = driver.findElements(By.xpath("//div[@id='divTrainsListHeader']//td"));
		for (WebElement webElement : rows) {
			
			for (WebElement webElement2 : column) {
				if(webElement2.getText().startsWith("M")) {
					map.put(webElement2.getText(), webElement2.getText());
	}
			}
		}
		System.out.println(map);
}
}
