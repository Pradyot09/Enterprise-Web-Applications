import java.io.*;
public class Mostsoldzip
{
String zipcode ;
String count;


public  Mostsoldzip(String zipcode,String count)
{
	
	this.zipcode = zipcode ;
    this.count = count;
}


public String getZipcode(){
 return zipcode;
}

public String getCount () {
 return count;
}
}