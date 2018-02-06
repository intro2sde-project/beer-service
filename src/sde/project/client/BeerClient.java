package sde.project.client;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;



import sde.project.model.User;
import sde.project.adapter.RecomAdapt;
import sde.project.model.Beer;
import sde.project.soap.BeerInterf;

public class BeerClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://192.168.31.108:6901/ws/beer?wsdl");
        //https://beer-recom.herokuapp.com/ws/beer?wsdl
        //http://192.168.31.108:6901/ws/beer?wsdl
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.project.sde/", "RecomService");
        
        
        Service service = Service.create(url, qname);
        
        String out = "heeeey";

        
        BeerInterf beers = service.getPort(BeerInterf.class);
       // people.deleteBeer(1);
        
    /* 
	 
       	out = out + "\nMethod #1:" + "\n" 
       			+ "Paramenter: None\n"
       			+ "Response: \n";
       	
        List<User> uList = beers.readUserList();
        
        
        for(User user : uList) {
        	 	out = out + "	- User " + user.getUsername() + "\n";
        	 	
        }
       	
       	
        List<Beer> pList = beers.readBeerList();
     
       
        for(Beer beer : pList) {
        	 	out = out + "	- Beer " + beer.getIdBeer() + " in the list ==> "+beer.getName() + "\n";
        	 	
        }
          
        out = out + "\n=============================\n";
        out = out + "\nMethod #2:" + "\n" 
       			+ "Paramenter: None\n"
       			+ "Response: \n";
        System.out.println("prima");
        Beer b = beers.readBeer(1);
        System.out.println("dopo");
        
        System.out.println("Result ==> " + b.getName());
      
      
        
         List<Beer> bList = beers.readBeerList();
         for(Beer beer : bList) {
     	 //	System.out.println("Beer " + beer.getIdBeer() + " in the list ==> "+ beer.getName());
         }
        */
        User user = User.getUserByUsername("user_2");
        Beer b = beers.readBeer(1);
        
         beers.addBeerToUser(user, b);
       
         //beers.removeBeerToUser(user, Beer.getBeerById(14));
        /*
         beers.removeBeerToUser(user, Beer.getBeerById(5));
         beers.removeBeerToUser(user, Beer.getBeerById(6));
        */ 
       /*  List<Beer> beerList = user.getBeerList();
         for(Beer beer : beerList) {
     		System.out.println("Beer " + beer.getIdBeer() + " in the list ==> "+ beer.getName());
         }
        */
         
        // beers.rateUserBeer(user, b, 3);
         
         
         System.out.println("rating: " + beers.getBeerRatingUser(user, b));
         
       // beers.addUserView(user, beers.readBeer(1));
         
         //User.removeUser(user);
        	//User.removeUser(User.getUserByUsername("java"));
        // RecomAdapt.deleteUser("java");
         /*
         
         List<Beer> beerList = RecomAdapt.getBeerAll();
         for(Beer beer : beerList) {
     		System.out.println("---------- Beer " + beer.getIdBeer() + " in the list ==> "+ beer.getName());
         }*/
     /*    
         User user = new User();
         user.setUsername("user_5");
         user.setPassword("1234");
         user.setEmail("ahahah@mss.c");
         User newUser = beers.createUser(user);
         System.out.println(user.getUsername());
     */    
    /*
  
        beers.rateUserBeer("user_1", beer, value).evaluateBeerPreferences(3, Activity.getActivityById(5),1);
        people.evaluateBeerPreferences(3, Activity.getActivityById(4),4);
        people.evaluateBeerPreferences(3, Activity.getActivityById(6),3);
        
         
        
   
        
     
        
        aList = people.getBestBeerPreferences(3);
       for(Activity activity : aList) {
   	 	System.out.println("Activity " + activity.getIdActivity() + " in the list ==> "+activity.getName());
       
   	 	
       
       } 
        */ 
        System.out.println(out);
    }
}
