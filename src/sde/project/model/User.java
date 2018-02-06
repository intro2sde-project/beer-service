package sde.project.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


import sde.project.dao.UserBeerDao;

@Entity
@Table(name="User")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
//@XmlType(propOrder = {"idPerson", "firstname", "lastname", "birthdate", "activity"})
@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 654354554568768461L;
	
	@Id // defines this attributed as the one that identifies the entity
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(cascade=CascadeType.ALL)
	  @JoinTable(name="\"user_beer\"", joinColumns=@JoinColumn(name="\"username\""), 
	  inverseJoinColumns=@JoinColumn(name="\"idBeer\""))
	private static List<Beer> beerList;
	
	public User () {
		 
	}
	
	public User(String username, String firstname, String lastname, String password, String email,
			List<Beer> beerList) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.beerList = beerList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	public List<Beer> getBeerList() {
		return beerList;
	}

	public void setBeer(Beer beer) {
		this.beerList.add(beer);
	}
	
	public void setBeerList(List<Beer> beerList) {
		this.beerList = beerList;
	}

	public static User getUserByUsername(String username) {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        User u = em.find(User.class, username);
        UserBeerDao.instance.closeConnections(em);
        return u;
    }

    public static List<User> getAll() {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        List<User> list = em.createNamedQuery("User.findAll", User.class)
            .getResultList();
        UserBeerDao.instance.closeConnections(em);
        return list;
    }

    public static User saveUser(User u) {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(u);
        tx.commit();
        UserBeerDao.instance.closeConnections(em);
        return u;
    } 

    public static User updateUser(User u) {
        EntityManager em = UserBeerDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        u=em.merge(u);
        tx.commit();
        UserBeerDao.instance.closeConnections(em);
        return u;
    }

    public static void removeUser(User u) {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        u=em.merge(u);
        em.remove(u);
        tx.commit();
        UserBeerDao.instance.closeConnections(em);
    }
    
    public static void removeBeer(User u, Beer b) {
        EntityManager em = UserBeerDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Iterator<Beer> it = beerList.iterator();
        while (it.hasNext()) {
        	  Beer val = it.next();
        	  if (val.getIdBeer()==b.getIdBeer())
        	    it.remove();
        	}
        u=em.merge(u);
        tx.commit();
        UserBeerDao.instance.closeConnections(em);
    }
}