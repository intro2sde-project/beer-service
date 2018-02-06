package sde.project.endpoint;


import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;

import java.util.List;

import javax.xml.ws.Endpoint;



import sde.project.model.Beer;
import sde.project.model.User;
import sde.project.adapter.RecomAdapt;
import sde.project.soap.BeerImpl;

public class BeerPublisher {
   public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException{
	   
	   
	   
	    String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        if (HOSTNAME.equals("127.0.0.1"))
        {
            HOSTNAME = "localhost";
        }
        String PORT = "6901";
        String BASE_URL = "/ws/beer";

        if (String.valueOf(System.getenv("PORT")) != "null"){
            PORT=String.valueOf(System.getenv("PORT"));
        }
        
        String endpointUrl = PROTOCOL+HOSTNAME+":"+PORT+BASE_URL;
        System.out.println("Starting Recom Service...");
        System.out.println("--> Published. Check out "+endpointUrl+"?wsdl");
        Endpoint.publish(endpointUrl, new BeerImpl());
        

      
        
       // System.out.println(User.getAll());
        
      
        
        
    
   

	   //WineRecom.WineRecomInit(); //initialize wine catalog on recombee
	   //BeerRecom.BeerRecomInit(); //initialize beer catalog on recombee
	   
	   
	   
	  	//System.out.println(BeerRecom.addWishlist("user_1", 14));
	  	//System.out.println(BeerRecom.addWishlist("user_1", 5));
	  	//System.out.println(BeerRecom.addWishlist("user_1", 6));
    		//List<Beer> beerList = RecomAdapt.recommendedBeers("user_1", 5);
    		//System.out.println(BeerRecom.deleteWishlist("user_3", 1));
    		//System.out.println(BeerRecom.deleteWishlist("user_3", 4));
    		//System.out.println(BeerRecom.deleteWishlist("user_3", 8));
    		//System.out.println(BeerRecom.deleteWishlist("user_3", 17));
    		//System.out.println(BeerRecom.deleteWishlist("user_3", 17));
	   
    		/*for(Beer beer : beerList) {
    			System.out.println(" - " + beer.getIdBeer() + " " + beer.getName() + "  " + beer.getType() + " " + beer.getColor());
    		}
    		*/
    		/*
    		BeerRecom.removeRating("user_1", 20);
    		BeerRecom.removeRating("user_1", 16);
    		BeerRecom.removeRating("user_1", 4);
    		BeerRecom.removeRating("user_1", 13);
    		BeerRecom.removeRating("user_1", 8);
    		*/
    		/*
    		BeerRecom.addRating("user_1", 20, 3);
    		BeerRecom.addRating("user_1", 16, 1);
    		BeerRecom.addRating("user_1", 4, 5);
    		BeerRecom.addRating("user_1", 13, 5);
    		BeerRecom.addRating("user_1", 8, 3);
    		
    		*/
    		

    
   } 
    	   
}