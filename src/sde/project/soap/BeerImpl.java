package sde.project.soap;

import sde.project.model.Beer;
import sde.project.model.User;
import sde.project.adapter.RecomAdapt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebService;





//Service Implementation

@WebService(endpointInterface = "sde.project.soap.BeerInterf",
    serviceName="RecomService")
public class BeerImpl implements BeerInterf {
	
	
	
	
    @Override
    public Beer readBeer(long id) {
        System.out.println("---> Reading Beer by id = "+id);
        Beer b = Beer.getBeerById(id);
        if (b!=null) {
            System.out.println("---> Found Beer by id = "+id+" => "+b.getName());
        } else {
            System.out.println("---> Didn't find any Beer with  id = "+id);
        }
        return b;
    }

    //get all beers from database
    @Override
    public List<Beer> readBeerList() {
        return Beer.getAll();
    }

    
  	//add beer to database (local and on recombee)
    @Override
    public Beer createBeer(Beer beer) {
        Beer.saveBeer(beer);
        RecomAdapt.addBeer(beer);
        return beer;
    }

    //update beer on database (local and on recombee)
    @Override
    public Beer updateBeer(Beer beer) {	
        Beer.updateBeer(beer);
        beer = Beer.getBeerById(beer.getIdBeer());
        RecomAdapt.addBeer(beer);
        return beer;
    }

    //remove beer from database (local and on recombee)
    @Override
    public long deleteBeer(long id) {
        Beer beer = Beer.getBeerById(id);
        if (beer!=null) {
            Beer.removeBeer(beer);
            RecomAdapt.deleteBeer(beer);
            return 0;
        } else {
            return -1;
        }
    }

    //add beer to wishlist (local and on recombee)
	@Override
	public long addBeerToUser(User user, Beer beer) {
		
		//User user = User.getUserByUsername(username);
		System.out.println("Adding new beer to user with username: " + user.getUsername());
	/*	
		user.setBeer(beer);
		User.updateUser(user);
	*/	
		RecomAdapt.addWishlist(user.getUsername(), beer.getIdBeer());
		
		return 0;
	}

	//user rates beer (local and on recombee)
	@Override
	public boolean rateUserBeer(User user, Beer beer, int value) {
		
		Map<String, Integer> eval = new HashMap<>();
		eval = beer.getRating();
		
		System.out.println("Rating beer with id: " + beer.getIdBeer() + " - by user with id: " + user.getUsername());
		
			if (0<value && value<6 ) {
			
				eval.put(user.getUsername(), value);
				beer.setRating(eval);
				Beer.updateBeer(beer);
				
			    	String key =user.getUsername();
			    	String rating = eval.get(key).toString();  
			    	System.out.println(key + " " + rating);  
			   
			    	RecomAdapt.addRating(user.getUsername(), beer.getIdBeer(), value);
			
			}else {
				System.out.println("Rating must be between 1 to 5");
			}
		
		
		return false;
	}

	//remove beer from wishlist
	@Override
	public long removeBeerToUser(User user, Beer beer) {
		//User.removeBeer(user, beer);
		RecomAdapt.deleteWishlist(user.getUsername(), beer.getIdBeer());
		return 0;
	}

	//get recommendation
	@Override
	public List<Beer> getUserRecom(User user, long count) {
			List<Beer> recomBeer = RecomAdapt.recommendedBeers(user.getUsername(), count);
		return recomBeer;
	}

	@Override
	public User createUser(User user) {
		 User.saveUser(user);
	     RecomAdapt.addUser(user.getUsername());
		
		return user;
	}

	@Override
	public User readUser(String username) {
		 System.out.println("---> Reading User with username = " + username);
	        User u = User.getUserByUsername(username);
	        if (u!=null) {
	            System.out.println("---> Found User by id = " + username+" => " + u.getFirstname());
	        } else {
	            System.out.println("---> Didn't find any User with username = " + username);
	        }
	        return u;
	
	}

	@Override
	public List<User> readUserList() {
		return User.getAll();
	}

	@Override
	public List<Beer> readUserWL(User user) {
		
		List<Beer> wl = RecomAdapt.getUserWishlist(user.getUsername());
		
		return wl;
	}

	@Override
	public long addUserView(User user, Beer beer) {
		
		RecomAdapt.addView(user.getUsername(), beer.getIdBeer());
		return 0;
	}

	@Override
	public long deleteUser(User user) {
		
	        if (user!=null) {
	        		User.removeUser(user);
	            RecomAdapt.deleteUser(user.getUsername());
	            return 0;
	        } else {
	            return -1;
	        }
	
	}

	@Override
	public double getBeerRatingUser(User user, Beer beer) {
		
		int count = 0;
		Map<String, Integer> m = new HashMap<>();
		m = beer.getRating();
		
		double rec = RecomAdapt.getRating(user.getUsername(), beer.getIdBeer());
		
		
		
		for (Entry<String, Integer> e : m.entrySet()){
			if (e.getKey().toString().equals(user.getUsername())) {
				System.out.println(++count + " " + e.getKey().toString() + " " + e.getValue() );
				return e.getValue(); 
			}
			
		}
		return rec;
		
		
	}
}
    

    
  

 



