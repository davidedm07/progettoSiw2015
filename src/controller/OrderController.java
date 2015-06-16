package controller;


import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Order;
import model.OrderFacade;
import model.OrderLine;
import model.User;


import model.*;


@ManagedBean
//@SessionScoped
public class OrderController {

	@ManagedProperty(value="#{param.id}")
	private Long idProdotto;
	//@ManagedProperty(value="#{param.quantity}")
	private int quantity;
	//@ManagedProperty(value="#{param.idProdotto}")

	private Date creationDate;
	private Date closingDate;
	private Date EvasionDate;
	private User user;
	private List<OrderLine> orderLines ;
	private List<Order> orders ;
	private List<Product> catalogo;
	private Product product;
	private Order order;
	private ProductController productController;
	
	private Long id; // id dell'ordine
	@EJB(name="orderFacade")
	private OrderFacade orderFacade;
	

//	public String listOrders() {
//		this.orders = orderFacade.getAllOrders();
//		return "listaOrdini"; 
//	}
//	public String createOrder() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//		if(session.getAttribute("user")==null)
//			return "login.jsp";
//		else{
//			this.user=(User) session.getAttribute("user");
//		this.catalogo = orderFacade.getAllProducts();
//		this.creationDate=new Date();
//		this.order=this.orderFacade.createOrder(this.user);
//		session.setAttribute("order", this.order);
//		return "creaOrdine"; }
//	}
	public String createOrder() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		if(session.getAttribute("user")==null)
			return "login.jsp";
		else{
			this.user=(User) session.getAttribute("user");
		this.catalogo = orderFacade.getAllProducts();
		this.creationDate=new Date();
		this.order=new Order(creationDate);
		this.order.setUser(user);
		session.setAttribute("order", this.order);
		return "creaOrdine"; 
		}
	}


//	public String createOrderLine() {
//
//		OrderLine orderLine= this.orderFacade.createOrderLine(this.idProdotto,this.quantity);
//		List<OrderLine> list=new LinkedList<>();
//		//		list.add(orderLine);
//		FacesContext context = FacesContext.getCurrentInstance();
//		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//		Order o=(Order) session.getAttribute("order");
//		if(o.getOrderLines()==null){
//			//			List<OrderLine> list=new LinkedList<>();
//			list.add(orderLine);
//		}
//		else{
//			list=o.getOrderLines();
//			list.add(orderLine);
//		}
//		o.setOrderLines(list);
//		session.setAttribute("order", o);
//		return "riga";
//
//	}

//	public String findProduct() {
//		this.product = orderFacade.getProduct(idProdotto);
//		return "productO";
//	}
	public String findOrder() {
		this.order = orderFacade.getOrder(id);
		return "#";
	}


	public String confirmOrder() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		this.orderFacade.confirmOrder((Order) session.getAttribute("order"));

		return "ordine";

	}

	public String annullOrder() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.removeAttribute("order");
		return "homepage.html";
	}

//	public String findOrder(Long id) {
//		this.orderFacade.getOrder(id);
//		return "order.jsp";
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Long idProdotto) {
		this.idProdotto = idProdotto;
	}


	public List<Product> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Product> catalogo) {
		this.catalogo = catalogo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductController getProductController() {
		return productController;
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Date getClosingDate() {
		return closingDate;
	}


	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}


	public Date getEvasionDate() {
		return EvasionDate;
	}


	public void setEvasionDate(Date evasionDate) {
		EvasionDate = evasionDate;
	}






}
