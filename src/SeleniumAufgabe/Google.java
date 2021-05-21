package SeleniumAufgabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Google {
	
	public static void launchBrowser(String word) {
		final WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver_win32(2)\\chromedriver.exe");   
		driver = new ChromeDriver();
		//opening google.com
		driver.get("https://www.google.com/"); 
		//Maximizing browser to be able to find elements
		driver.manage().window().maximize();
		//Google search bar is reachable under name q
		driver.findElement(By.name("q")).sendKeys(word + Keys.ENTER);
		//Getting results number as a plain text from div result status
		String results = driver.findElement(By.xpath("//*[contains(@id, 'result-stat')]")).getText();
		//Creating a list of webelements of link cites
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='g']//a//cite"));
		//needed to get the text
		List<String> strings = new ArrayList<String>();
		for(WebElement e : links){
		    strings.add(e.getText());
		    //Top 3 condition
			if (strings.size()==3) {
		    	break;
		    }
		}
		System.out.println(results);
		System.out.println(strings);
		//closing driver
		driver.close();
	}
	
	public static void main(String[] args) {
		//getting user words and use it as input for Launchbrowser function
		 Scanner scanner = new Scanner(System.in);  
		    System.out.println("Enter your word");
		    String userWord = scanner.nextLine(); 
		    scanner.close();
		    launchBrowser(userWord);
	
	
	}

}
