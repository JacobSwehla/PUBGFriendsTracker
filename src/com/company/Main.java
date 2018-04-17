package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String APP_KEY;
    private static final String BASE_URL = "https://api.playbattlegrounds.com/shards";

    public static void main( String[] args) {
        try {
        File apikeyfile = new File( "key.txt" );
        Scanner scan = new Scanner(  apikeyfile );
        APP_KEY = scan.next();
        } catch ( FileNotFoundException e ) {
            invalidKey();
        }



        List<String> playerNames = new ArrayList<String>(  );
        playerNames.add( "cadet111" );
        playerNames.add("Captain%20FFlippy");

        List<String> shards = new ArrayList<String>(  );
        shards.add( "xbox-na" );

        makePlayerSearchCall( BASE_URL, "xbox-na", playerNames );

    }

    private static void invalidKey() {
        System.out.println("Key file not found");
        System.exit( 1 );
    }

    private static void makePlayerSearchCall( String baseURL, String shard, List<String> playerNames ) {


        Client client = ClientBuilder.newClient();

        String appKey = "Bearer " + APP_KEY; // appKey is unique number

        StringBuilder target = new StringBuilder(  );

        target.append( baseURL );
        target.append( "/" + shard );
        target.append( "/players?filter[playerNames]=" );
        for(String s : playerNames){
            target.append( s + ",");
        }

        String targetStr = target.toString();
        targetStr.replace( " ", "%20" );

        WebTarget webTarget
                = client.target(targetStr);

        try {
            Response r = webTarget.request(  )
                    .header( "Content-Type", "application/json")
                    .header( "Authorization", appKey )
                    .header( "Accept", "application/vnd.api+json" )
                    .get();
            
            switch ( r.getStatus() ){
                case 404:
                    log404();
                    break;
                case 401:
                    invalidKey();
                    break;
                case 200:

                    String json = r.readEntity( String.class );

                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        RequestContent requestContent = mapper.readValue(json, RequestContent.class);

                    } catch ( IOException e ) {
                        e.printStackTrace();
                        System.out.println("Reading json failed");
                    }
            }

        } catch ( NotFoundException e ){
            System.out.println(e.getMessage());
            System.out.println( webTarget.getUri().toASCIIString());
        }

    }

    private static void log404() {
        System.out.println("404");
        System.exit( 2 );
    }
}
