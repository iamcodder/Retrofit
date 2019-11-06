## Retrofit
Retrofit, Square şirketi tarafından Open Source(Açık Kaynak Kod) olarak geliştirilmiş bir REST istemcisidir. 

##### Peki ya Rest istemcisi nedir?
REST ; istemci ile sunucu arasında hızlı ve kolay şekilde iletişim kurulmasını sağlayan bir servis yapısıdır.  HTTP üzerinde çalışır ve diğer alternatiflere göre daha basittir, minimum içerikle veri alıp gönderdiği için de daha hızlıdır.
İstemci ve sunucu arasında XML veya JSON verilerini taşıyarak uygulamaların haberleşmesini sağlar.
REST standartlarına uygun yazılan web servislerine de **RESTful Servisler** denir.

RESTful servisler veri iletiminde farklı HTTP metotlarını kullanmaktadır. Bunlar **GET, POST, PUT, DELETE** metotlarıdır. 
GET okuma, POST yeni kayıt ekleme(insert), PUT kayıt güncelleme(update), DELETE ise kayıt silme işlemi için kullanılır. Yapılan HTTP request  için çağrılan URL ile beraber HTTP method bilgisi bahsi geçen 4 metottan biri olarak seçilir ve sunucu yapılan talebin kayıt üzerine nasıl etki edeceğini buna göre belirler.

Her bir metot için ayrı bir proje oluşturup açıklamalarla anlatacağım.
Şimdilik her projemizde olması gerekenler şunlar olacak: 


**BuildGradle:**


    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.2'

Retrofiti kullanabilmek için bu kütüphaneleri eklememiz gerekiyor.
Ayrıca fake json verisin alabilmek için de şu siteyi kullanacağız.

	https://jsonplaceholder.typicode.com/



