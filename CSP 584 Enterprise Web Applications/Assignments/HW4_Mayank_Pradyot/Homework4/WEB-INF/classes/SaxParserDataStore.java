import org.xml.sax.InputSource;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserDataStore extends DefaultHandler {
    WearableTech wearabletech;
    Phone phone;
    Laptop laptop;
    VoiceAssistant voiceassistant;
    static HashMap<String,WearableTech> wearabletechs;
    static HashMap<String,Phone> phones;
    static HashMap<String,Laptop> laptops;
    static HashMap<String,VoiceAssistant> voiceassistants;
    String consoleXmlFileName;
	// HashMap<String,String> accessoryHashMap;
    String elementValueRead;
	String currentElement="";
    public SaxParserDataStore()
	{
	}
	public SaxParserDataStore(String consoleXmlFileName) {
    // this.consoleXmlFileName = consoleXmlFileName;
	this.consoleXmlFileName = consoleXmlFileName;
    wearabletechs = new HashMap<String, WearableTech>();
	phones=new  HashMap<String, Phone>();
	laptops=new HashMap<String, Laptop>();
	voiceassistants=new HashMap<String, VoiceAssistant>();
	// accessoryHashMap=new HashMap<String,String>();
	parseDocument();
    }

   //parse the xml using sax parser to get the data
    private void parseDocument() 
	{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try 
		{
	    SAXParser parser = factory.newSAXParser();
	    parser.parse(consoleXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
	}

   
	
	// when xml start element is parsed store the id into respective hashmap for wearabletech,phones etc 
    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("wearabletech")) 
		{
			currentElement="wearabletech";
			wearabletech = new WearableTech();
            wearabletech.setId(attributes.getValue("id"));
		}
        else if (elementName.equalsIgnoreCase("laptop"))
		{
			currentElement="laptop";
			laptop = new Laptop();
            laptop.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("phone"))
		{
			currentElement="phone";
			phone= new Phone();
            phone.setId(attributes.getValue("id"));
        }
		if (elementName.equals("voiceassistant"))
		{
			currentElement="voiceassistant";
			voiceassistant=new VoiceAssistant();
			voiceassistant.setId(attributes.getValue("id"));
	    }

    }
	// when xml end element is parsed store the data into respective hashmap for wearabletech,phones etc respectively
    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {
 
        if (element.equals("wearabletech")) {
			wearabletechs.put(wearabletech.getId(),wearabletech);
			return;
        }
 
        if (element.equals("laptop")) {	
			laptops.put(laptop.getId(),laptop);
			return;
        }
        if (element.equals("phone")) {	  
			phones.put(phone.getId(),phone);
			return;
        }
        if (element.equals("voiceassistant")){
			voiceassistants.put(voiceassistant.getId(),voiceassistant);       
			return; 
        }

        if (element.equalsIgnoreCase("image")) {
		    if(currentElement.equals("wearabletech"))
				wearabletech.setImage(elementValueRead);
        	if(currentElement.equals("phone"))
				phone.setImage(elementValueRead);
            if(currentElement.equals("laptop"))
				laptop.setImage(elementValueRead);
            if(currentElement.equals("voiceassistant"))
				voiceassistant.setImage(elementValueRead);          
			return;
        }
        

		if (element.equalsIgnoreCase("discount")) {
            if(currentElement.equals("wearabletech"))
				wearabletech.setDiscount(Double.parseDouble(elementValueRead));
        	if(currentElement.equals("phone"))
				phone.setDiscount(Double.parseDouble(elementValueRead));
            if(currentElement.equals("laptop"))
				laptop.setDiscount(Double.parseDouble(elementValueRead));
            if(currentElement.equals("voiceassistant"))
				voiceassistant.setDiscount(Double.parseDouble(elementValueRead));          
			return;
	    }


		if (element.equalsIgnoreCase("condition")) {
            if(currentElement.equals("wearabletech"))
				wearabletech.setCondition(elementValueRead);
        	if(currentElement.equals("phone"))
				phone.setCondition(elementValueRead);
            if(currentElement.equals("laptop"))
				laptop.setCondition(elementValueRead);
            if(currentElement.equals("voiceassistant"))
				voiceassistant.setCondition(elementValueRead);          
			return;  
		}

		if (element.equalsIgnoreCase("manufacturer")) {
            if(currentElement.equals("wearabletech"))
				wearabletech.setRetailer(elementValueRead);
        	if(currentElement.equals("phone"))
				phone.setRetailer(elementValueRead);
            if(currentElement.equals("laptop"))
				laptop.setRetailer(elementValueRead);
            if(currentElement.equals("voiceassistant"))
				voiceassistant.setRetailer(elementValueRead);          
			return;
		}

        if (element.equalsIgnoreCase("name")) {
            if(currentElement.equals("wearabletech"))
				wearabletech.setName(elementValueRead);
        	if(currentElement.equals("phone"))
				phone.setName(elementValueRead);
            if(currentElement.equals("laptop"))
				laptop.setName(elementValueRead);
            if(currentElement.equals("voiceassistant"))
				voiceassistant.setName(elementValueRead);          
			return;
	    }
	
        if(element.equalsIgnoreCase("price")){
			if(currentElement.equals("wearabletech"))
				wearabletech.setPrice(Double.parseDouble(elementValueRead));
        	if(currentElement.equals("phone"))
				phone.setPrice(Double.parseDouble(elementValueRead));
            if(currentElement.equals("laptop"))
				laptop.setPrice(Double.parseDouble(elementValueRead));
            if(currentElement.equals("voiceassistant"))
				voiceassistant.setPrice(Double.parseDouble(elementValueRead));          
			return;
        }

	}
	//get each element in xml tag
    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }


    /////////////////////////////////////////
    // 	     Kick-Start SAX in main       //
    ////////////////////////////////////////
	
//call the constructor to parse the xml and get product details
 public static void addHashmap() {
		String TOMCAT_HOME = System.getProperty("catalina.home");	
		new SaxParserDataStore(TOMCAT_HOME+"\\webapps\\Homework4\\ProductCatalog.xml");
    } 
}
