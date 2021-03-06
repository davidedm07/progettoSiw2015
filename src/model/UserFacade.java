package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpSession;

@Stateless(name="uFacade")
public class UserFacade {

	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;

	public User createUser(String email, String password,String username, String name, String cognome,String street, String city, String state, String zipCode, String country, String day, String month, String year)  {
		User user= new User(email,password,username,name,cognome);
		Date registrationDate= new Date();
		//Date dateofBirth= new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date dateofBirth = null;
		try {
			dateofBirth = formatter.parse(day+"/"+month+"/"+year+"");
		} catch (ParseException e) {
			// new Date cambia alcuni valori, questo andrà aggiustato 
			e.printStackTrace();
		}
		user.setRegistrationDate(registrationDate);
		user.setDateOfBirth(dateofBirth);
		Address address= new Address(street,city,state,zipCode,country);
		user.setAddress(address);
		em.persist(user);
		return user;
	}

	public User getUser(String email,String password) {
		Query q=this.em.createQuery("SELECT p From User p");
		List<User> us=q.getResultList();
		int c=0;
		for(User u:us){
			c++;
			if(u.getEmail().equals(email) && u.getPassword().equals(password))
				return u;
		}
		return null;
	}

	public List<Order> getAllOrders() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		User u=(User) session.getAttribute("user");
		Query q=this.em.createQuery("SELECT o FROM Order o"); 
		List<Order> orders=q.getResultList();
		List<Order> o2=new LinkedList<>();
		for(Order o:orders){
			if(o.getCostumer().getEmail().equals(u.getEmail())){
				o2.add(o);
			}
		}

		session.setAttribute("ordini",orders);
		return o2;


	}

	public List<User> getAllUsers() {
		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
		cq.select(cq.from(User.class));
		List<User> users = em.createQuery(cq).getResultList();
		return users;
	}

	public void updateUser(User user) {
		em.merge(user);
	}

	private void deleteUser(User user) {
		em.remove(user);
	}
	public Order getOrder(Long id) {
		Order o=em.find(Order.class, id);
		return o;

	}

	public void deleteProduct(String email) {
		User user= em.find(User.class, email);
		deleteUser(user);
	}
}
