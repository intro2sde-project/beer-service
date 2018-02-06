package sde.project.soap;

import sde.project.model.Beer;
import sde.project.model.User;

import java.util.List;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;



@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface BeerInterf {
	
    @WebMethod(operationName="readBeer")
    @WebResult(name="beer") 
    public Beer readBeer(@WebParam(name="idBeer") long id);
    
    @WebMethod(operationName="readUser")
    @WebResult(name="user") 
    public User readUser(@WebParam(name="username") String username);

    @WebMethod(operationName="readBeerList")
    @WebResult(name="beer") 
    public List<Beer> readBeerList();
    
    @WebMethod(operationName="readUserList")
    @WebResult(name="user") 
    public List<User> readUserList();

    @WebMethod(operationName="createBeer")
    @WebResult(name="beer") 
    public Beer createBeer(@WebParam(name="beer") Beer beer);
    
    @WebMethod(operationName="createUser")
    @WebResult(name="user") 
    public User createUser(@WebParam(name="user") User user);
  
    @WebMethod(operationName="updateBeer")
    @WebResult(name="beer") 
    public Beer updateBeer(@WebParam(name="beer") Beer beer);

    @WebMethod(operationName="deleteBeer")
    @WebResult(name="beer") 
    public long deleteBeer(@WebParam(name="idBeer") long id);
    
    @WebMethod(operationName="deleteUser")
    @WebResult(name="user") 
    public long deleteUser(@WebParam(name="user") User user);
    
    @WebMethod(operationName="addUserView")
    @WebResult(name="beer") 
    public long addUserView(@WebParam(name="user") User user, 
			@WebParam(name="beer") Beer beer);
    
    @WebMethod(operationName="addBeerToUser")
    @WebResult(name="beer") 
    public long addBeerToUser(@WebParam(name="user") User user, 
    												@WebParam(name="beer") Beer beer);
    
    @WebMethod(operationName="readUserWL")
    @WebResult(name="beer") 
    public List<Beer> readUserWL(@WebParam(name="user") User user);
    
    
    @WebMethod(operationName="rateUserBeer")
    @WebResult(name="beer") 
    public boolean rateUserBeer(@WebParam(name="user") User user, 
    													@WebParam(name="beer") Beer beer,
    													@WebParam(name="value") int value);
    
    @WebMethod(operationName="removeBeerToUser")
    @WebResult(name="beer") 
    public long removeBeerToUser(@WebParam(name="user") User user, 
    												@WebParam(name="beer") Beer beer);
    
    @WebMethod(operationName="getUserRecom")
    @WebResult(name="beer") 
    public List<Beer> getUserRecom(@WebParam(name="user") User user, 
    												@WebParam(name="count") long count);
    
    

    @WebMethod(operationName="getBeerRatingUser")
    @WebResult(name="beer") 
    public double getBeerRatingUser(@WebParam(name="user") User user, 
    									@WebParam(name="beer") Beer beer);

}
