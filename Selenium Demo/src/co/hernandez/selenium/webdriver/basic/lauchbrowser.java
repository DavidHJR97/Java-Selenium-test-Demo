package co.hernandez.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class lauchbrowser {

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// open the web app
		driver.navigate().to("https://www.amazon.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.com"))
			System.out.println("Title matches");
		else
			System.out.println(title);
		
		String tagname = " ";
		tagname = driver.findElement(By.cssSelector("#nav-hamburger-menu > i")).getText();
		System.out.println(tagname);

		Actions action = new Actions(driver);
		// Dropdown menu
		WebElement dropdown = driver.findElement(By.cssSelector("#nav-hamburger-menu > i"));
		action.moveToElement(dropdown);
		action.click();
		action.perform();
		Thread.sleep(3000);
		
		// Go to electronics menu 
		WebElement electronicsMenu = driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(14) > a > div"));
		action.moveToElement(electronicsMenu);
		action.click();
		action.perform();
		Thread.sleep(3000);
		
		// Go to wearable technology section
		WebElement wearableTech = driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(12) > a > div"));
		action.moveToElement(wearableTech);
		action.click();
		action.perform();
		Thread.sleep(3000);

	
		// Typing the text
		WebElement myElement=driver.findElement(By.id("twotabsearchtextbox"));
		myElement.sendKeys("Apple Watch Series 5");
		
		driver.findElement(By.className("nav-input")).click();
		Thread.sleep(2000);
	
		// Select the watch
		driver.findElement(By.partialLinkText("(GPS + Cellular, 44mm)")).click();
		Thread.sleep(2000);
		
		// Click on drop down for options 
		driver.findElement(By.cssSelector("#dropdown_selected_style_name > span > span")).click();
		Thread.sleep(2000);
		
		// Select space gray aluminum with sports band watch 
		driver.findElement(By.cssSelector("#native_dropdown_selected_style_name_6")).click();
		Thread.sleep(2000);
		
//		
//		// Shift the tab control 
//		java.util.Set<String> handles = driver.getWindowHandles();
//		String winHandle1 = driver.getWindowHandle();
//		handles.remove(winHandle1);
	
//		String winHandle=handles.iterator().next();
//		String winHandle2 = " ";
//		if(winHandle != winHandle1) {
//			// to retrienve the handle of second window, extracting the handle which does 
//			winHandle2 = winHandle; // Stroing handle of second window handle 
//			driver.switchTo().window(winHandle2);
//			System.out.println(winHandle2);
//		}
//		Thread.sleep(2000);
		
		// add to cart 
		driver.findElement(By.cssSelector("#add-to-cart-button")).click();
		Thread.sleep(5000);
		
		WebElement noThanksBtn = driver.findElement(By.cssSelector("#attachSiNoCoverage-announce"));  
//		WebElement continueBtn = driver.findElement(By.cssSelector("#a-autoid-70 > span > input"));  
		noThanksBtn.click();
		Thread.sleep(2000);
		
		// Click on proceed to checkout button 
		driver.findElement(By.cssSelector("#attach-sidesheet-checkout-button > span > input")).click();
		Thread.sleep(2000);
		
		// scroll the web page till end 
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		Thread.sleep(3000);
		
		//iframes
//		driver.get("http:demo.automatingtesting.in/Frames.html");
//		WebElement frame=driver.findElement(By.xpath("\\iframe[src='SingleFrame.html']"));
//		driver.switchTo().frame(frame);
//		Thread.sleep(2000);
//		
//		WebElement textbox=driver.findElement(By.xpath("//input[@type='text'"));
//		textbox.sendKeys("hey");
//		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}

}
