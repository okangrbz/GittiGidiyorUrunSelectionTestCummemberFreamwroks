package StepDefinition;


import Pages.GittiGidiyor;
import Utillies.ConfigReader;
import Utillies.Driver;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class GittiGidiyorStepDefinition {
	GittiGidiyor gitti = new GittiGidiyor();
	JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
	WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
	Faker fake=new Faker();
	Actions action=new Actions(Driver.getDriver());





	@Given("kullanici {string} sayfasina gider")
	public void kullanici_sayfasina_gider(String string) {
		Driver.getDriver().get(ConfigReader.getProperties(string));


	}

	@And("Arama kutucuğuna {string} kelimesi girer")
	public void aramaKutucuğunaKelimesiGirer(String kelime) {

		gitti.aramaCubugu.sendKeys(kelime + Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	@Then("Arama sonuçları sayfasından {int}.sayfa açar")
	public void arama_sonuçları_sayfasından_sayfa_açar(Integer sayfa) {
		wait.until(ExpectedConditions.visibilityOf(gitti.aramaSayfalari.get(sayfa+1)));
		jse.executeScript("arguments[0].click();",gitti.aramaSayfalari.get(sayfa+1));


	}



	@Then("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçer")
	public void sonuca_göre_sergilenen_ürünlerden_rastgele_bir_ürün_seçer() {
		gitti.urunler.get(fake.random().nextInt(0,gitti.urunler.size())).click();

	}


	@Then("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazar")
	public void seçilen_ürünün_ürün_bilgisi_ve_tutar_bilgisi_txt_dosyasına_yazar() {


		String date= SimpleDateFormat.getDateTimeInstance().format(Date.from(Instant.now()));
		File file=new File("/Users/pc/IdeaProjects/ExercicesCucumber/target/text"+date+".txt");
		try {
			FileWriter wrait=new FileWriter(file);
			wrait.write("Secilen Urunun bilgisi :"+gitti.urunBilgisi.getText()+"\nSecilen urunun fiyati :"+gitti.urunPrix.getText());
			wrait.close();

		} catch (IOException e) {
			e.printStackTrace();
		}



	}



	@Then("Seçilen ürün sepete ekler")
	public void seçilen_ürün_sepete_ekler() {
		wait.until(ExpectedConditions.elementToBeClickable(gitti.sepeteEkle));
		jse.executeScript("arguments[0].click();",gitti.sepeteEkle);

	}

	@Then("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırır.")
	public void ürün_sayfasındaki_fiyat_ile_sepette_yer_alan_ürün_fiyatının_doğruluğu_karşılaştırır() {


		action.moveToElement(gitti.sepetim).perform();
		wait.until(ExpectedConditions.elementToBeClickable(gitti.sepeteGit));
		jse.executeScript("arguments[0].click();",gitti.sepeteGit);
		String urunSayfasindakifiyat=gitti.urunsayfasindakiprix.getText();
		System.out.println("urunSayfasindakifiyat = " + urunSayfasindakifiyat);
		String sepettekiUrun=gitti.sepetteUrunPrix.getText();
		System.out.println("sepettekiUrun = " + sepettekiUrun);
		Assert.assertEquals(urunSayfasindakifiyat,sepettekiUrun);


	}

	@Then("Adet arttırılarak ürün adedinin {int} olduğu doğrular")
	public void adet_arttırılarak_ürün_adedinin_olduğu_doğrular(Integer int1) {
		Select select=new Select(gitti.urunAdedi);
		if (int1<select.getOptions().size()){
		select.selectByIndex(int1-1);
		String artirilacakmiktar=Integer.toString(int1);
		String artirildiktanSonra=select.getOptions().get(int1-1).getText();
		Assert.assertEquals(artirilacakmiktar,artirildiktanSonra);}
		else System.out.println("Sepette "+int1+" adet urun bulunmamaktadir ");


	}

	@Then("Ürün sepetten silinerek sepetin boş olduğu kontrol eder")
	public void ürün_sepetten_silinerek_sepetin_boş_olduğu_kontrol_eder() {

		gitti.urunuSil.click();

		String actual=gitti.sepetteUrunOlmadigiDogrulama.getText();
		System.out.println(actual);


	}


}
