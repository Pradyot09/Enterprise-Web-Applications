import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Inventory")



public class Inventory extends HttpServlet{
	
	private String producttype;
	private String id;
	private String name;
	private double price;
	private String image;
	private String retailer;
	private String condition;
	private double discount;
	private int solditems;
	private double totalsales;
	private String daydate;
	private String productonsale;
	private int productquantity;
	public Inventory(String producttype,String id,String name, double price, String image, String retailer, String condition,double discount,String productonsale,int productquantity){
		
		this.producttype=producttype;
		this.id=id;
		this.name=name;
		this.price=price;
		this.image=image;
		this.condition=condition;
		this.discount = discount;
		this.retailer = retailer;
		this.productonsale = productonsale;
		this.productquantity = productquantity;
	}
	public Inventory(String name, double price, int solditems, double totalsales){
		
		this.name=name;
		this.price=price;
		this.solditems=solditems;
		this.totalsales=totalsales;

	}
	public Inventory(String daydate,double totalsales){
		
		this.daydate=daydate;
		this.totalsales=totalsales;

	}
	
	public Inventory(){
		
	}
	
	public String getproductType(){
		return producttype; 
	}
	
	public void setproductType(String producttype){
		this.producttype = producttype;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getsoldItems() {
		return solditems;
	}

	public void setsoldItems(int solditems) {
		this.solditems = solditems;
	}
	public double gettotalSales() {
		return totalsales;
	}

	public void settotalSales(double totalsales) {
		this.totalsales = totalsales;
	}
	public String getdayDate() {
		return daydate;
	}

	public void setdayDate(String daydate) {
		this.daydate = daydate;
	}
	public int getproductQuantity() {
		return productquantity;
	}

	public void setproductQuantity(int productquantity) {
		this.productquantity = productquantity;
	}
	public String getproductOnSale() {
		return productonsale;
	}

	public void setproductOnSale(String productonsale) {
		this.productonsale = productonsale;
	}
}
