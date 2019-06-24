import java.sql.*;
import java.util.*;
                	
public class MySqlDataStoreUtilities
{
static Connection conn = null;
static String message;
public static String getConnection()
{

	try
	{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartportables","root","Brlpm1210k");							
	message="Successfull";
	return message;
	}
	catch(SQLException e)
	{
		message="unsuccessful";
		     return message;
	}
	catch(Exception e)
	{
		message=e.getMessage();
		return message;
	}
}

public static HashMap<String,Inventory> getDailyTransactions()
{
	HashMap<String,Inventory> hm=new HashMap<String,Inventory>();
	try {
		
		
		getConnection();
		Statement stmt=conn.createStatement();
		String selectDailyTransactionsQurey="select dayDate,sum(orderPrice) as totalSales from smartportables.customerorders group by dayDate";
		ResultSet rs = stmt.executeQuery(selectDailyTransactionsQurey);
		
		while(rs.next())
		{	
			Inventory inventoryItems = new Inventory(rs.getString("dayDate"),rs.getDouble("totalSales"));
			
				hm.put(rs.getString("dayDate"), inventoryItems);
		}
	}
	catch(Exception e)
	{
	}
	return hm;
}
public static HashMap<String,Inventory> getSoldProducts()
{
	HashMap<String,Inventory> hm=new HashMap<String,Inventory>();
	try {
		
		
		getConnection();
		Statement stmt=conn.createStatement();
		String selectSoldProductsQurey="select orderName,orderPrice,count(orderName) as itemsSold,(orderPrice * count(orderName)) as totalSales from customerorders group by orderName";
		ResultSet rs = stmt.executeQuery(selectSoldProductsQurey);
		
		while(rs.next())
		{	
			Inventory inventoryItems = new Inventory(rs.getString("orderName"),rs.getDouble("orderPrice"),rs.getInt("itemsSold"),rs.getDouble("totalSales"));
			
				hm.put(rs.getString("orderName"), inventoryItems);
		}
	}
	catch(Exception e)
	{
	}
	return hm;
}

public static HashMap<String,Inventory> getAllProducts()
{
	HashMap<String,Inventory> hm=new HashMap<String,Inventory>();
	try {
		
		
		getConnection();
		Statement stmt=conn.createStatement();
		String selectProductQurey="Select *from Productdetails";
		ResultSet rs = stmt.executeQuery(selectProductQurey);
		while(rs.next())
		{	
			Inventory inventoryItems = new Inventory(rs.getString("ProductType"),rs.getString("Id"),rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"),rs.getString("productOnSale"),rs.getInt("productQuantity"));
			
				hm.put(rs.getString("ProductType"), inventoryItems);
		}
	}
	catch(Exception e)
	{
	}
	return hm;
}
public static HashMap<String,Inventory> getOnRebateProducts()
{
	HashMap<String,Inventory> hm=new HashMap<String,Inventory>();
	try {
		
		
		getConnection();
		Statement stmt=conn.createStatement();
		String selectProductQurey="select * from smartportables.productdetails where productDiscount <>0";
		ResultSet rs = stmt.executeQuery(selectProductQurey);
	
		while(rs.next())
		{	
			Inventory inventoryItems = new Inventory(rs.getString("ProductType"),rs.getString("Id"),rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"),rs.getString("productOnSale"),rs.getInt("productQuantity"));
			
				hm.put(rs.getString("ProductType"), inventoryItems);
		}
	}
	catch(Exception e)
	{
	}
	return hm;
}
public static HashMap<String,Inventory> getOnSaleProducts()
{
	HashMap<String,Inventory> hm=new HashMap<String,Inventory>();
	try {
		
		
		getConnection();
		Statement stmt=conn.createStatement();
		String selectProductQurey="select * from smartportables.productdetails where productOnSale='YES';";
		ResultSet rs = stmt.executeQuery(selectProductQurey);
	
		while(rs.next())
		{	
			Inventory inventoryItems = new Inventory(rs.getString("ProductType"),rs.getString("Id"),rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"),rs.getString("productOnSale"),rs.getInt("productQuantity"));
			
				hm.put(rs.getString("ProductType"), inventoryItems);
		}
	}
	catch(Exception e)
	{
	}
	return hm;
}
public static void Insertproducts()
{
	try{
		
		getConnection();
		
		
		String truncatetableacc = "delete from Product_accessories;";
		PreparedStatement pstt = conn.prepareStatement(truncatetableacc);
		pstt.executeUpdate();
		
		String truncatetableprod = "delete from  Productdetails;";
		PreparedStatement psttprod = conn.prepareStatement(truncatetableprod);
		psttprod.executeUpdate();
		
				
		
		String insertProductQurey = "INSERT INTO  Productdetails(ProductType,Id,productName,productPrice,productImage,productManufacturer,productCondition,productDiscount)" +
		"VALUES (?,?,?,?,?,?,?,?);";
		for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wearabletechs.entrySet())
		{   
			String name = "wearabletechs";
	        WearableTech wearabletech = entry.getValue();
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,wearabletech.getId());
			pst.setString(3,wearabletech.getName());
			pst.setDouble(4,wearabletech.getPrice());
			pst.setString(5,wearabletech.getImage());
			pst.setString(6,wearabletech.getRetailer());
			pst.setString(7,wearabletech.getCondition());
			pst.setDouble(8,wearabletech.getDiscount());
			
			pst.executeUpdate();
			
			
		}
		
		for(Map.Entry<String,Phone> entry : SaxParserDataStore.phones.entrySet())
		{   
	        Phone phone = entry.getValue();
			String name = "phones";		
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,phone.getId());
			pst.setString(3,phone.getName());
			pst.setDouble(4,phone.getPrice());
			pst.setString(5,phone.getImage());
			pst.setString(6,phone.getRetailer());
			pst.setString(7,phone.getCondition());
			pst.setDouble(8,phone.getDiscount());
			
			pst.executeUpdate();
		}
		for(Map.Entry<String,Laptop> entry : SaxParserDataStore.laptops.entrySet())
		{   
			String name = "laptops";
	        Laptop laptop = entry.getValue();
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,laptop.getId());
			pst.setString(3,laptop.getName());
			pst.setDouble(4,laptop.getPrice());
			pst.setString(5,laptop.getImage());
			pst.setString(6,laptop.getRetailer());
			pst.setString(7,laptop.getCondition());
			pst.setDouble(8,laptop.getDiscount());
			
			pst.executeUpdate();
			
		}
		for(Map.Entry<String,VoiceAssistant> entry : SaxParserDataStore.voiceassistants.entrySet())
		{   
			String name = "voiceassistants";
	        VoiceAssistant voiceassistant = entry.getValue();
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,voiceassistant.getId());
			pst.setString(3,voiceassistant.getName());
			pst.setDouble(4,voiceassistant.getPrice());
			pst.setString(5,voiceassistant.getImage());
			pst.setString(6,voiceassistant.getRetailer());
			pst.setString(7,voiceassistant.getCondition());
			pst.setDouble(8,voiceassistant.getDiscount());
			
			pst.executeUpdate();
			
			
		}
		
	}catch(Exception e)
	{
  		e.printStackTrace();
	}
} 

public static HashMap<String,Phone> getPhones()
{	
	HashMap<String,Phone> hm=new HashMap<String,Phone>();
	try 
	{
		getConnection();
		
		String selectPhone="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectPhone);
		pst.setString(1,"phones");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	Phone phone = new Phone(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"));
				hm.put(rs.getString("Id"), phone);
				phone.setId(rs.getString("Id"));									
		}
	}
	catch(Exception e)
	{
	}
	return hm;				
}

public static HashMap<String,VoiceAssistant> getVoiceAssistants()
{	
	HashMap<String,VoiceAssistant> hm=new HashMap<String,VoiceAssistant>();
	try 
	{
		getConnection();
		
		String selectVoiceAssistant="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectVoiceAssistant);
		pst.setString(1,"voiceassistants");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	VoiceAssistant voicesssistant = new VoiceAssistant(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"));
				hm.put(rs.getString("Id"), voicesssistant);
				voicesssistant.setId(rs.getString("Id"));

		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

public static HashMap<String,Laptop> getLaptops()
{	
	HashMap<String,Laptop> hm=new HashMap<String,Laptop>();
	try 
	{
		getConnection();
		
		String selectLaptop="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectLaptop);
		pst.setString(1,"laptops");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	Laptop laptop = new Laptop(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"));
				hm.put(rs.getString("Id"), laptop);
				laptop.setId(rs.getString("Id"));
		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

public static HashMap<String,WearableTech> getWearableTechs()
{	
	HashMap<String,WearableTech> hm=new HashMap<String,WearableTech>();
	try 
	{
		getConnection();
		
		String selectWearableTech="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectWearableTech);
		pst.setString(1,"wearabletechs");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	
	WearableTech wearabletech = new WearableTech(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"));
				hm.put(rs.getString("Id"), wearabletech);
				wearabletech.setId(rs.getString("Id"));

		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

public static String addproducts(String producttype,String productId,String productName,double productPrice,String productImage,String productManufacturer,String productCondition,double productDiscount,String prod)
{
	String msg = "Product is added successfully";
	try{
		
		getConnection();
		String addProductQurey = "INSERT INTO  Productdetails(ProductType,Id,productName,productPrice,productImage,productManufacturer,productCondition,productDiscount)" +
		"VALUES (?,?,?,?,?,?,?,?);";
		   
			String name = producttype;
	        			
			PreparedStatement pst = conn.prepareStatement(addProductQurey);
			pst.setString(1,name);
			pst.setString(2,productId);
			pst.setString(3,productName);
			pst.setDouble(4,productPrice);
			pst.setString(5,productImage);
			pst.setString(6,productManufacturer);
			pst.setString(7,productCondition);
			pst.setDouble(8,productDiscount);
			
			pst.executeUpdate();
			try{
				if (!prod.isEmpty())
				{
					String addaprodacc =  "INSERT INTO  Product_accessories(productName,accessoriesName)" +
					"VALUES (?,?);";
					PreparedStatement pst1 = conn.prepareStatement(addaprodacc);
					pst1.setString(1,prod);
					pst1.setString(2,productId);
					pst1.executeUpdate();
					
				}
			}catch(Exception e)
			{
				msg = "Erro while adding the product";
				e.printStackTrace();
		
			}
			
			
		
	}
	catch(Exception e)
	{
		msg = "Erro while adding the product";
		e.printStackTrace();
		
	}
	return msg;
}
public static String updateproducts(String producttype,String productId,String productName,double productPrice,String productImage,String productManufacturer,String productCondition,double productDiscount)
{ 
    String msg = "Product is updated successfully";
	try{
		
		getConnection();
		String updateProductQurey = "UPDATE Productdetails SET productName=?,productPrice=?,productImage=?,productManufacturer=?,productCondition=?,productDiscount=? where Id =?;" ;
		
		   
				        			
			PreparedStatement pst = conn.prepareStatement(updateProductQurey);
			
			pst.setString(1,productName);
			pst.setDouble(2,productPrice);
			pst.setString(3,productImage);
			pst.setString(4,productManufacturer);
			pst.setString(5,productCondition);
			pst.setDouble(6,productDiscount);
			pst.setString(7,productId);
			pst.executeUpdate();
			
			
		
	}
	catch(Exception e)
	{
		msg = "Product cannot be updated";
		e.printStackTrace();
		
	}
 return msg;	
}
public static String deleteproducts(String productId)
{   String msg = "Product is deleted successfully";
	try
	{
		
		getConnection();
		String deleteproductsQuery ="Delete from Productdetails where Id=?";
		PreparedStatement pst = conn.prepareStatement(deleteproductsQuery);
		pst.setString(1,productId);
		
		pst.executeUpdate();
	}
	catch(Exception e)
	{
			msg = "Proudct cannot be deleted";
	}
	return msg;
}

public static void deleteOrder(int orderId,String orderName)
{
	try
	{
		
		getConnection();
		String deleteOrderQuery ="Delete from customerorders where OrderId=? and orderName=?";
		PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
		pst.setInt(1,orderId);
		pst.setString(2,orderName);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
			
	}
}

public static void insertOrder(int orderId,String userName,String orderName,double orderPrice,String userAddress,String creditCardNo)
{
	try
	{
	
		getConnection();
		
		String insertIntoCustomerOrderQuery = "INSERT INTO customerOrders(OrderId,UserName,OrderName,OrderPrice,userAddress,creditCardNo) "
		+ "VALUES (?,?,?,?,?,?);";	
			
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		//set the parameter for each column and execute the prepared statement
		pst.setInt(1,orderId);
		pst.setString(2,userName);
		pst.setString(3,orderName);
		pst.setDouble(4,orderPrice);
		pst.setString(5,userAddress);
		pst.setString(6,creditCardNo);
		pst.execute();
	}
	catch(Exception e)
	{
	
	}		
}

public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder()
{	

	HashMap<Integer, ArrayList<OrderPayment>> orderPayments=new HashMap<Integer, ArrayList<OrderPayment>>();
		
	try
	{					

		getConnection();
        //select the table 
		String selectOrderQuery ="select * from customerorders";			
		PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
		ResultSet rs = pst.executeQuery();	
		ArrayList<OrderPayment> orderList=new ArrayList<OrderPayment>();
		while(rs.next())
		{
			if(!orderPayments.containsKey(rs.getInt("OrderId")))
			{	
				ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
				orderPayments.put(rs.getInt("orderId"), arr);
			}
			ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));		
			

			//add to orderpayment hashmap
			OrderPayment order= new OrderPayment(rs.getInt("OrderId"),rs.getString("userName"),rs.getString("orderName"),rs.getDouble("orderPrice"),rs.getString("userAddress"),rs.getString("creditCardNo"));
			listOrderPayment.add(order);
					
		}
				
					
	}
	catch(Exception e)
	{
		
	}
	return orderPayments;
}


public static void insertUser(String username,String password,String repassword,String usertype)
{
	try
	{	

		getConnection();
		String insertIntoCustomerRegisterQuery = "INSERT INTO Registration(username,password,repassword,usertype) "
		+ "VALUES (?,?,?,?);";	
				
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
		pst.setString(1,username);
		pst.setString(2,password);
		pst.setString(3,repassword);
		pst.setString(4,usertype);
		pst.execute();
	}
	catch(Exception e)
	{
	
	}	
}

public static HashMap<String,User> selectUser()
{	
	HashMap<String,User> hm=new HashMap<String,User>();
	try 
	{
		getConnection();
		Statement stmt=conn.createStatement();
		String selectCustomerQuery="select * from  Registration";
		ResultSet rs = stmt.executeQuery(selectCustomerQuery);
		while(rs.next())
		{	User user = new User(rs.getString("username"),rs.getString("password"),rs.getString("usertype"));
				hm.put(rs.getString("username"), user);
		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

	
}	