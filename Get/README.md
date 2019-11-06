### Detaylar

Random json verilerini şu siteden çekeceğiz.

	https://jsonplaceholder.typicode.com/posts
Verileri çekmeden önce bu site bloğunu 2 parçaya böleceğiz.İlk parçamız **com/** kısmının sonuna kadar , 2.parçamız da sadece **posts** kısmı olacak.Nedenini aşağıda anlatacağım şimdilik sadece 2 parçaya böldüğümüzü bilin.

Önceki sayfada kullanacağımız 2 adet retrofit kütüphanesini ekledik.Şimdilik başka kütüphane olmayacak. O zaman kodlamaya geçelim.

------------



##### AndroiManifest.xml
İlk olarak **Manifest** dosyasından internet izni alalalım.

    <uses-permission android:name="android.permission.INTERNET"/>

------------



##### JsonApi Interface
Şimdiyse bir adet interface oluşturacağız. Bu interface sayesinde verileri çekme işlemi yapacağız.
Başta siteyi 2 parçaya ayırıyoruz demiştik.İşte burada sitenin kalan kısmını ekliyoruz yani 2.parçayı.Sebebiyse her seferinde adresi yeniden yazmamak için.Ayrıca Call metoduysa Retrofit ile gelen ve liste halinde json verisini almak için istek gönderen bir metot olacak.

	public interface JsonApi {
	
    @GET("posts")
    Call<List<Post>> getData(); 
	
	}

------------


##### Post Class
Sonrasında json olarak aldığımız verileri parçalayıp bir sınıfta tutmamız gerekiyor.Bu sınıfta Encapsulation yapıyoruz.
@SerializedName("userId")  dememizin sebebi. siteden çekeciğimiz verinin değişken adı userId olması.Ya bu sınıfta değişken adını userId yapacağız ya da @SerializedName diyerek yine userId değişkeninin içeriğini alacağız ama kendimizin farklı bir isim vererek oluşturduğumuz değişkene içeriğini atacağız.Ben farklı isimli oluşturdum.

	public class Post {

    @SerializedName("userId")
    private int kullanıcı_id;
	
	public int getKullanıcı_id() {
        return kullanıcı_id;
    }
	public void setKullanıcı_id(int kullanıcı_id) {
        this.kullanıcı_id = kullanıcı_id;  }
	}
	
------------

##### MainActivity Class
Şimdiyse en cafcaflı kısım.

 	Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
Retrofit nesnesi oluşturuyoruz ve buna baseUrl diyerek veri çekeceğimiz websitesinin kemik adresini veriyoruz. 2.olarak addConverterFactory diyoruz çünkü çektiğimiz json verisinin parçalanması lazım.Bunuda Gson yardımıyla yapıyoruz.Son olarak build ediyoruz.

	JsonApi jsonApi = retrofit.create(JsonApi.class);
Oluşturduğumuz retrofit nesnesi JsonApi arabiriminin bir uygulamasını oluşturur.Bu sayede istek atabiliriz.

	Call<List<Post>> list = jsonApi.getData();
Burada da sunucuya istek atıyoruz.

        list.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccessful()) {
                    List<Post> list = response.body();
					//veri çekme başarılı oldu
                } }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //hata mesajı göster
            }});

Son olarakta list.enqueue diyerek CallBack oluşturuyoruz.Veri başarılı bir şekilde çekildi mi yoksa hata mı var diyerek kontrol ediyoruz.Eğer başarılı çekildiyse response.body() diyerek içeriğimizi Post nesneleri halinde listeye atıyoruz ve kullanıma hazır hale getiriyoruz.
