package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.AdminFacade;
import model.Order;
import model.OrderFacade;


@ManagedBean
//@SessionScoped
public class AdminController {
	
	
	@ManagedProperty(value="#{param.id}")
	private String email;
	private String password;
	private String username;
	private Date dateOfBirth;
	private String day;
	private String month;
	private String year;
	private Admin admin;
	private List<Order> orders;
	@ManagedProperty(value="#{param.idProdotto}")
    private Long idOrdine;

	@EJB(name="adFacade")
	private AdminFacade adminFacade;

	private Order currentOrder;

	public String createAdmin() {
		this.admin=this.adminFacade.createAdmin(email,password,username,day,month,year);
		return "loginAmministratore"; 
	}

	public String loginAdmin() {
		this.admin=this.adminFacade.loginAdmin(email,password);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("admin", this.admin);
		return "homepageAmministratore"; 

	}

	public String manageOrders() {
		this.orders=this.adminFacade.getAllOrders();
		return "gestioneOrdini";	
	}

	public String evadeOrder() {
		this.currentOrder=this.adminFacade.getOrder(idOrdine);
		this.adminFacade.evadeOrder(this.currentOrder);
		return "homepageAmministratore";

	}

	public String findOrder() {
		this.currentOrder=this.adminFacade.getOrder(idOrdine);
		return "dettaglioOrdine";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public AdminFacade getAdminFacade() {
		return adminFacade;
	}

	public void setAdminFacade(AdminFacade adminFacade) {
		this.adminFacade = adminFacade;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Long idOrdine) {
		this.idOrdine = idOrdine;
	}


}
