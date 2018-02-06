package sde.project.model;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import sde.project.dao.UserBeerDao;

@Entity
@Table(name="Beer")
@NamedQuery(name="Beer.findAll", query="SELECT b FROM Beer b")
//@XmlType(propOrder = {"idBeer", "name", "description", "place", "type", "startdate"})
@XmlRootElement(name="Beer")
public class Beer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="idBeer")
	private long idBeer;
	
	@Column(name="name")
	private String name;
	
	@Column(name="color")
	private String color;
	
	@Column(name="type")
	private String type;
	
	@Column(name="taste")
	private String taste;
	
	private Map<String, Integer> rating = new HashMap<>();
	
	public Beer () {
		
	}
	
	
	public Beer(String name, String color, String type, String taste) {
		super();
		this.name = name;
		this.color = color;
		this.type = type;
		this.taste = taste;
	}


	public long getIdBeer() {
		return idBeer;
	}

	public void setIdBeer(long idBeer) {
		this.idBeer = idBeer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return taste;
	}

	public void setCountry(String taste) {
		this.taste = taste;
	}
	
	
	public Map<String, Integer> getRating() {
		return rating;
	}


	public void setRating(Map<String, Integer> rating) {
		this.rating = rating;
	}


	public static Beer getBeerById(long BeerId) {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        Beer a = em.find(Beer.class, BeerId);
        UserBeerDao.instance.closeConnections(em);
        return a;
    }
	
    public static List<Beer> getAll() {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        List<Beer> list = em.createNamedQuery("Beer.findAll", Beer.class)
            .getResultList();
        UserBeerDao.instance.closeConnections(em);
        return list;
    }
    
    public static List<Beer> getAllColor(String color){
    	 EntityManager em = UserBeerDao.instance.createEntityManager();
         List<Beer> list = em.createNamedQuery("SELECT b FROM Beer b"
											+ "WHERE b.color=" + color , Beer.class)
             .getResultList();
         UserBeerDao.instance.closeConnections(em);
         return list;
    }
    
    public static List<Beer> getAllType(String type){
    	 EntityManager em = UserBeerDao.instance.createEntityManager();
         List<Beer> list = em.createNamedQuery("SELECT b FROM Beer b"
					+ "WHERE b.type=" + type , Beer.class)
             .getResultList();
         UserBeerDao.instance.closeConnections(em);
         return list;
    }
  

    public static Beer saveBeer(Beer a) {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a);
        tx.commit();
        UserBeerDao.instance.closeConnections(em);
        return a;
    } 

    public static Beer updateBeer(Beer a) {
        EntityManager em = UserBeerDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        a=em.merge(a);
        tx.commit();
        UserBeerDao.instance.closeConnections(em);
        return a;
    }

    public static void removeBeer(Beer a) {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        a=em.merge(a);
        em.remove(a);
        tx.commit();
        UserBeerDao.instance.closeConnections(em);
    }
}
