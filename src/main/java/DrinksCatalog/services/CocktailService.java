package DrinksCatalog.services;

import DrinksCatalog.models.Cocktail;
import DrinksCatalog.repositories.CocktailRepository;
import DrinksCatalog.repositories.specifications.CocktailSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

@Service
public class CocktailService {

    @Autowired
    private RestTemplate restTemplate;
    public static final String URL = "https://reimagined-sniffle-xgg9pq54jxrh6x76-3000.app.github.dev/";
    @Autowired
    private CocktailRepository repository;

    public String getImage(String path){
        disableSSLCertificateChecking();
        String url = URL+path;
        System.err.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    public List<Cocktail> getRandonsDrinks(){
        return repository.getRandonsDrinks();
    }

    public List<Cocktail> findDrinks(String search, String letter, String ingredient, String alcoholic, String category) {
        Specification<Cocktail> spec = Specification.where(null);
        System.err.println(search);

        if (search != null && !search.isEmpty()) {
            System.out.println("a");
            spec = spec.and(CocktailSpecifications.searchDrinksWith(search));
        }
        if (letter != null && !letter.isEmpty()) {
            System.out.println("b");
            spec = spec.and(CocktailSpecifications.hasNameStartingWith(letter));
        }
        if (ingredient != null && !ingredient.isEmpty()) {
            System.out.println("c");
            spec = spec.and(CocktailSpecifications.hasIngredient(ingredient));
        }
        if (alcoholic != null && !alcoholic.isEmpty()) {
            System.out.println("d");
            spec = spec.and(CocktailSpecifications.isAlcoholic(alcoholic));
        }
        if (category != null && !category.isEmpty()) {
            System.out.println("e");
            spec = spec.and(CocktailSpecifications.hasCategory(category));
        }

        return repository.findAll(spec);
    }

    private static void disableSSLCertificateChecking() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                    }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) { return true; }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            System.out.println("Validação de certificado SSL desabilitada.");
        } catch (Exception e) {
            System.err.println("Erro ao desabilitar a validação do certificado SSL:");
            e.printStackTrace();
        }
    }
}
