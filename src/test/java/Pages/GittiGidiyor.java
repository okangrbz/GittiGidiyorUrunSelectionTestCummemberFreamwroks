package Pages;

import Utillies.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GittiGidiyor {

	public GittiGidiyor() {
		PageFactory.initElements(Driver.getDriver(), this);

	}


	@FindBy(xpath = "(//input[@type='text'])[1]")
	public WebElement aramaCubugu;

	//@FindBy(className = "tyj39b-5 bEEsJG")
	//public WebElement cookie;

	@FindBy(xpath = "//ul[@class='sc-12aj18f-3 kLmKCh']//li")
	public List<WebElement> aramaSayfalari;

	@FindBy(xpath = "//li[@class='sc-1nx8ums-0 dyekHG']")
	public List<WebElement> urunler;

	@FindBy(xpath = "//div[@class='title-container gg-w-24 gg-d-24 gg-t-24 gg-m-24 padding-none']")
	public WebElement urunBilgisi;

	@FindBy(xpath = "(//span[@id='sp-price-highPrice'])[1]")
	public  WebElement urunPrix;

	@FindBy(xpath = "//form[@action='https://www.gittigidiyor.com/sepete-ekle']")
	public  WebElement sepeteEkle;

	@FindBy(xpath = "//div[@class='basket-container robot-header-iconContainer-cart']")
	public WebElement sepetim;

	@FindBy(xpath = "//a[@class='gg-ui-btn-default padding-none']")
	public WebElement sepeteGit	;

	@FindBy(xpath = "//div[@class='gg-d-8 gg-m-10 detail-price']")
	public WebElement sepetteUrunPrix;

	@FindBy(xpath = "//select[@class='amount'] ")
	public WebElement urunAdedi	;

	@FindBy(xpath = "//div[@class='gg-d-16 gg-m-14 detail-text']")
	public  WebElement urunAdetDogrula;

	@FindBy(xpath = "(//a[@class='btn-delete btn-update-item'])[1]")
	public WebElement urunuSil	;

	@FindBy(xpath = "//div[@class='gg-d-19 gg-w-21 gg-t-19 gg-m-18']//h2")
	public WebElement sepetteUrunOlmadigiDogrulama;

	@FindBy(xpath = "//div[@class='total-price-box']")
	public WebElement urunsayfasindakiprix;

}


