Feature: US01 Gittigidiyor urun kontrol testi

  @win
  Scenario: TC01 gittigidiyor urun ekleme testi
    Given kullanici "gittiUrl" sayfasina gider
    And Arama kutucuğuna "bilgisayar" kelimesi girer
    Then Arama sonuçları sayfasından 2.sayfa açar
    And Sonuca göre sergilenen ürünlerden rastgele bir ürün seçer
    And Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazar
    And Seçilen ürün sepete ekler
    And Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırır.
    And Adet arttırılarak ürün adedinin 2 olduğu doğrular
    And Ürün sepetten silinerek sepetin boş olduğu kontrol eder