package com.API_REST.config;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;


@Configuration // Permet à Spring de le lire comme un fichier de config il executera donc les bean contenu au démarrage de l'app
public class FlickrConfiguration {

    @Value("${flickr.apiKey}")
    private String apiKey;

    @Value("${flickr.apiSecret}")
    private String apiSecret;

    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;

    /*@Bean
    public Flickr getFlickr() throws InterruptedException, ExecutionException, IOException, FlickrException {
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST()); // Création d'une instance de type flickr contenant apiKey et apiSecret et un objet de type rest

        OAuth10aService service = new ServiceBuilder(apiKey) // Création d'un objet de type OAuth10aService
                .apiSecret(apiSecret)
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE)); // Definition du niveau d'autorisation

        final Scanner scanner = new Scanner(System.in); // Creation d'un scanner

        final OAuth1RequestToken request = service.getRequestToken(); //Récupération de request token

        final String authUrl = service.getAuthorizationUrl(request); //Recuperation de l'url d'autorisation

        System.out.println(authUrl);
        System.out.println("Paste it here >> ");

        final String authVerifier = scanner.nextLine();

        OAuth1AccessToken accessToken = service.getAccessToken(request, authVerifier); // Je vérifie si le token est valide

        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getTokenSecret());

        Auth auth = flickr.getAuthInterface().checkToken(accessToken);

        System.out.println("-------------------------------------");
        System.out.println(auth.getToken());
        System.out.println(auth.getTokenSecret());

        return flickr;
    }*/

    @Bean
    public Flickr getFlickr(){

        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());

        Auth auth = new Auth();

        auth.setPermission(Permission.DELETE);

        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);

        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);


        return flickr;
    }

}
