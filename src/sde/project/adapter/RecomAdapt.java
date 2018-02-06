package sde.project.adapter;

import java.util.ArrayList;
import java.util.Random;

import java.util.HashMap;
import java.util.List;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.Purchase;
import com.recombee.api_client.bindings.Rating;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.bindings.Item;
import com.recombee.api_client.exceptions.ApiException;


import sde.project.model.Beer;
import sde.project.model.User;

public class RecomAdapt {

	public RecomAdapt() {
		
	}
	public static void BeerRecomInit() {
		
	
	    RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
	
	    try {
	        client.send(new ResetDatabase()); //Clear everything from the database
	        
	        
	       // client.send(new AddItemProperty("idBeer", "double"));
	        client.send(new AddItemProperty("name", "string"));
	        client.send(new AddItemProperty("color", "string"));
	        client.send(new AddItemProperty("type", "string"));
	        client.send(new AddItemProperty("taste", "string"));
	
	        // Prepare requests for setting a catalog of beer
	        final ArrayList<Request> requests = new ArrayList<Request>();
	        List<Beer> beerList = Beer.getAll();
	        Integer rating =null;
	        for(final Beer beer : beerList)
	        {
	            final SetItemValues req = new SetItemValues(Long.toString(beer.getIdBeer()), //itemId
	                //values:
	                new HashMap<String, Object>() {{
	                   // put("idBeer", beer.getIdBeer());
	                    put("name", beer.getName());
	                    put("color", beer.getColor());
	                    put("type", beer.getType());
	                    put("taste", beer.getCountry());
	                }}
	            ).setCascadeCreate(true);  // Use cascadeCreate for creating item
	                                       // with given itemId, if it doesn't exist;
	            requests.add(req);
	        }
	        client.send(new Batch(requests)); // Send catalog to the recommender system
	
	        // setting up the users
	        List<User> userList = User.getAll();
	        for(final User user : userList) {
	        		client.send(new AddUser(user.getUsername()));
	        }
	       
	       
	        // Generate purchases/wishlist of beer for users
	   
	        ArrayList<Request> addPurchaseRequests = new ArrayList<Request>();
	        for (User user : userList) {
	        		
	            for (Beer beer : user.getBeerList())
	                {
	                    AddPurchase req = new AddPurchase(user.getUsername(), Long.toString(beer.getIdBeer()))
	                                            .setCascadeCreate(true); //use cascadeCreate to create the users
	                    addPurchaseRequests.add(req);
	                }
	        }
	        client.send(new Batch(addPurchaseRequests)); // Send purchases to the recommender system

	    } catch (ApiException e) {
	        e.printStackTrace();
	        //Use fallback
	    }
	    
	   
	}

	//add user to catalog on recombee
	 public static boolean addUser(String username) {

		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 client.send(new AddUser(username));
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
		 
	    	
	    }
	 
	//delete user to catalog on recombee
	 public static boolean deleteUser(String username) {

		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 client.send(new DeleteUser(username));
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
			 
		    	
	 }
	 
	 //add rating to beer by user
	 public static boolean addRating(String username, long idBeer, int numStars) {
		 
		 
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 double rating = (numStars-3)/2;
			 client.send(new AddRating(username, Long.toString(idBeer),  rating)
					  .setCascadeCreate(true)
					);
			 
			 Rating [] result = client.send(new ListItemRatings(Long.toString(idBeer)));
			 for(Rating rate : result) {
				System.out.println(" - " + rate.getUserId() + " rate for beer with id: " + idBeer + " is " + rate.getRating());
			 }
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
		 
		
	 }
	 
	//remove rating to beer by user
	 public static boolean removeRating(String username, long idBeer) {
		 
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 client.send(new DeleteRating(username, Long.toString(idBeer))
					);
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
		 
	 }
	 
	 //add beer to user wishlist (wishlist intended as purchased list on recombee)
	 public static boolean addWishlist(String username, long idBeer) {
		 
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 client.send(new AddPurchase(username,Long.toString(idBeer))
                     .setCascadeCreate(true));
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
		
	 }
	 
	 //delete beer from user wishlist
	 public static boolean deleteWishlist(String username, long idBeer) {
		 
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 client.send(new DeletePurchase(username,Long.toString(idBeer))
                     );
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
		
	 }
	 
	 //add beer to catalog on recombee
	 public static boolean addBeer(final Beer beer) {
		 
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			client.send(new SetItemValues(String.format(Long.toString(beer.getIdBeer())), //itemId
		                //values:
		                new HashMap<String, Object>() {{
		                    put("idBeer", beer.getIdBeer());
		                    put("name", beer.getName());
		                    put("color", beer.getColor());
		                    put("type", beer.getType());
		                    put("taste", beer.getType());
		                }}
					 ).setCascadeCreate(true)); 
			 
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
		 
	 }
	 
	//delete beer from catalog on recombee
	public static boolean deleteBeer(Beer beer) {

		RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		try {
				 
			 client.send(new DeleteItem(Long.toString(beer.getIdBeer())));
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
			 
		    	
	}
	 
	 //get list of recommended beers userbased
	 public static List<Beer> recommendedBeers(String username, long count){
		 
		 List<Beer> beerList = new ArrayList<Beer>();
		 Beer beer = new Beer();
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			  
		 
		 
		 Recommendation [] result = client.send(new UserBasedRecommendation(username,  count)
				 );
		 
		 for(Recommendation rec: result) {
			 beer = Beer.getBeerById(Long.parseLong(rec.getId()));
			 beerList.add(beer);
		 }

		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
		 }
		 return beerList;
				
	 }
	 
	//add beer viewed by user
	 public static boolean addView(String username, long idBeer) {
		 
		 
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 client.send(new AddDetailView(username,Long.toString(idBeer))
	                 .setCascadeCreate(true));
			 return true;
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			 return false;
		 }
	 }
	 
	 public static List<Beer> getUserWishlist(String username){
		 
		
		 List<Beer> beerList = new ArrayList<Beer>();
		 Beer beer = new Beer();
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 Purchase [] result = client.send(new ListUserPurchases(username));
	                
			 for(Purchase pur: result) {
				 beer = Beer.getBeerById(Long.parseLong(pur.getItemId()));
				 beerList.add(beer);
			 }
			 
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			
		 }
		 return beerList;
		 
	 }
	 
	 public static List<Beer> getBeerAll(){
		 
		 List<Beer> beerList = new ArrayList<Beer>();
		 Beer beer = new Beer();
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 Item [] result = client.send(new ListItems());
	                
			 for(Item it: result) {
				 beer = Beer.getBeerById(Long.parseLong(it.getItemId()));
				 beerList.add(beer);
			 }
			 
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			
		 }
		 return beerList;
		 
	 }
	 
	 public static double getRating(String username, long idBeer) {
		 
		 double rate = 0;
		 RecombeeClient client = new RecombeeClient("intro2sde", "CDX065c4Q9yYKeArCvII74bK39GhB9W7X43gVwkaj8szcUAlGv7oeqGs9vYff84E");
		 try {
			 
			 Rating [] result = client.send(new ListItemRatings(Long.toString(idBeer)));
	                
			 for(Rating rating: result) {
				 if (rating.getUserId().equals(username)) {
					 rate = rating.getRating(); 
				 }
			 }
			 
		 } catch (ApiException e) {
			 e.printStackTrace();
	        //Use fallback
			
		 }
		 return rate;
		 
	 }
}
	