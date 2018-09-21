package com.markit.DigitalAutomationFramework.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



/**
 * This class provides the functionality to interact with the xml files.
 * 
 * @author sonam.chhetri
 *
 */
public class XMLParser {

	// Create document object
	Document doc;

	ArrayList<String> list;

	// Create XPath object
	XPath xpath;
	
	DocumentBuilderFactory dbf ;
	DocumentBuilder db ;
 
	private Logger log = Logger.getLogger(XMLParser.class.getSimpleName());
	

	/**
	 * Constructor of the XMLParser which takes file path as parameter and parses the content of the param .
	 * 
	 * @param file :file name as a string
	 * @throws SAXException 
	 */
	public XMLParser(String file) throws SAXException { 
		DOMConfigurator.configure("log4j.xml");
		log.info("XML Parser executing...");
		// Get the DOM Builder Factory
		dbf = DocumentBuilderFactory.newInstance();

		try {
			//Getting the instance of document builder
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			log.error("Unable to create document builder.. ");
			e.printStackTrace();
		}

		// Load and Parse the content of file as an XML doc and return a new DOM doc obj
		try {
			doc = db.parse(file);
		} catch ( IOException e) {

			log.error("unable to parse file..");
			e.printStackTrace();
		}
		
		doc.getDocumentElement().normalize();

		// Create XPathFactory object
		XPathFactory xpathFactory = XPathFactory.newInstance();

		//Crating a new instance of an xpath
		xpath = xpathFactory.newXPath();

	}

	/**
	 * Constructor of the XMLParser which takes input Source as parameter and parses the content of the given input source as an XML document.
	 * 
	 * @param is :Input Source
	 * @throws SAXException
	 * @throws IOException
	 */
	public XMLParser(InputSource is) throws SAXException, IOException
	{
		
		dbf=DocumentBuilderFactory.newInstance();
		
		try {
			db=dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		doc=db.parse(is);
		doc.getDocumentElement().normalize();
		  
	}
	
	
		
	
	// ----------------------------------------------------------------

	/**
	 * Returns the root node of the document.
	 * 
	 * @return the root node.Type-node
	 */
	public Node getRootElement() {

		return doc.getDocumentElement();
	}

	// ----------------------------------------------------------------
	/**
	 * Returns the occurrence of node .
	 * 
	 * @param tagName
	 * @return count of node
	 */
	public int getNodeCount(String tagName) {

		NodeList nl = doc.getElementsByTagName(tagName);

		return nl.getLength();
	}

	
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * Gets the first occurrence of node when supplied with the tag name of the node
	 * as parameter.
	 * 
	 * @param tagName
	 *            tag name of the node.
	 * @return node if present else null
	 */

		public Node getNode(String tagName) {
			NodeList nl = doc.getElementsByTagName(tagName);
			for (int x = 0; x < nl.getLength(); x++) {
				Node node = nl.item(x);
				if (node.getNodeName().equalsIgnoreCase(tagName)) {
					return node;
				}
			}

			return null;
		}

		// -----------------------------------------------------------------------------------------

	/**
	 * Gets the first occurrence of node by tag name and attribute name.
	 * 
	 * @param tagName
	 *            :tag name of the node
	 * 
	 * @param attribName
	 *            : Attribute name of that node
	 * 
	 * @return node if present else null
	 */
		public Node getNode(String tagName, String attribName) {

			NodeList nl = doc.getElementsByTagName(tagName);
			
		
			
			for (int x = 0; x < nl.getLength(); x++) {
				Node node = nl.item(x);
				NamedNodeMap attrbs = node.getAttributes();
				Node attr1=attrbs.getNamedItem(attribName);
				if (node.getNodeName().equalsIgnoreCase(tagName)
						&& attr1.getNodeName().equalsIgnoreCase(attribName)) {
					return node;
				}
			}

			return null;
		}
	// ----------------------------------------------------------------

	
	
	/**
	 * Returns the attribute value of the node by tag name and attribute name of
	 * the node.<br>
	 * 
	 * @param n
	 *            : node of the document from which the attribute value is to be
	 *            fetched.
	 * @param tagName
	 *            : tag name of the node for which attribute value is to be
	 *            fetched.
	 * @param attribName
	 *            : attribute name of the node.
	 * @return attribute value: type-String
	 */

	public String getAttributeValue(Node n, String tagName, String attribName) {

		String attributeValue = null;
		if (n==null){
			return null;
		}
		else{
			List<Node> cl = traverse(n);
			for (int i = 0; i < cl.size(); i++) {
	
				Node cn = cl.get(i);
				String nodeName = cl.get(i).getNodeName();
				if (nodeName.equalsIgnoreCase(tagName))
	
				{
					
					if (cn.hasAttributes()) {
						Attr attr = (Attr) cn.getAttributes().getNamedItem(
								attribName);
						if (attr != null) {
							if (attr.getName().equalsIgnoreCase(attribName)) {
								attributeValue = attr.getValue();
								return attributeValue;
							}
							
						}
					}
				}
			}
		}
		return attributeValue;
	}

	// ----------------------------------------------------------------
	/**
	 * Returns the list of attribute value by tag name and attribute name of the
	 * node.<br>
	 * 
	 * @param n
	 *            :node of the document from which the attribute value is to be
	 *            fetched.
	 * @param tagName
	 *            :tag name of the node for which attribute value is to be
	 *            fetched.
	 * @param attribName
	 *            : attribute name of the node.
	 * @return list of attribute value
	 */
	public ArrayList<String> getAttributeValueList(Node n, String tagName,
			String attribName) {

		ArrayList<String> attributeValueList = new ArrayList<String>();

		List<Node> cl = traverse(n);
		for (int i = 0; i < cl.size(); i++) {

			Node cn = cl.get(i);
			String nodeName = cl.get(i).getNodeName();
			if (nodeName.equalsIgnoreCase(tagName))

			{
				
				if (cn.hasAttributes()) {
					Attr attr = (Attr) cn.getAttributes().getNamedItem(
							attribName);
					if (attr != null) {
						if (attr.getName().equalsIgnoreCase(attribName)) {
							String attributeValue = attr.getValue();
							attributeValueList.add(attributeValue);
							
						}
						
					}
				}
			}

		}
	
		return attributeValueList;
	}

	// ---------------------------------------------------------------------------------------------------------------

	/**
	 * Traverses the node and returns the list of nodes(child nodes) within that
	 * node
	 * 
	 * @param n
	 *            Node to be traversed
	 * @return List of nodes
	 */
	public List<Node> traverse(Node n) {
		return traverse(Arrays.asList(n));
	}

	// ---------------------------------------------------------------------------------------------------------------

	/**
	 * Traverses the list of nodes and returns the visited list of node.
	 * 
	 * @param n
	 *            : node to get traversed.
	 * @return List of visited nodes.
	 */
	public List<Node> traverse(List<Node> n) {
		
		//collection type:(node)  currently visiting node
		List<Node> open = new LinkedList<Node>(n);

		List<Node> visited = new LinkedList<Node>();
		ListIterator<Node> it = open.listIterator();

		while (it.hasNext() || it.hasPrevious()) {
			Node unvisited;

			if (it.hasNext())
				unvisited = it.next();
			else
				unvisited = it.previous();
			it.remove();
			List<Node> children = getChildren(unvisited);
			for (Node child : children)

				it.add(child);
			visited.add(unvisited);
		}
		
		return visited;
	}

	/**
	 * Gets the list of child nodes
	 * 
	 * @param n
	 *            :node to traverse
	 * @return Lists of child nodes
	 */
	public List<Node> getChildren(Node n) {

		List<Node> children = aSList(n.getChildNodes());
		Iterator<Node> it = children.iterator();
		while (it.hasNext())
			if (it.next().getNodeType() != Node.ELEMENT_NODE)
				it.remove();
	

		return children;

	}
	
	/**Returns child node of a node based on its attribute name and attribute value.
	 * 
	 * @param n
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	public Node getChildNode(Node n,String attributeName, String attributeValue)
	{
		List<Node> Children=getChildren(n);		//get children of node.
		int index=0;
		
		for(Node c:Children)
		{
			String tagName=c.getNodeName();		//taking tag name of child node.
			
			
			// if attribute value found of child tag is equal to attribute value expected then break out of loop :
			if(getAttributeValue(c,tagName, attributeName).equals(attributeValue))
				break;
			else						//else increment index value
				index++;
			
			
		}
		
		if(Children.size()==index)		//If no child node matches description than return
			index=-1;					//child by index -1 which will raise null pointer exception
	
		//return child node if matched.
		return Children.get(index);		//return child node of n 
		
	}
	
	
	

	// ---------------------------------------------------------------------------------------------------------------
	/**
	 * Returns the list of node
	 * 
	 * @param nl NodeList
	 * @return list of node
	 */
	private static List<Node> aSList(NodeList nl) {

		List<Node> list = new ArrayList<Node>(nl.getLength());

		for (int i = 0; i < nl.getLength(); i++) {
			list.add(nl.item(i));

		}
	
		return list;
	}

	// ---------------------------------------------------------------------------------------------------------------

	/**
	 * Gets the text context of the node by its tag name
	 * 
	 * @param n
	 *           Node in which tag to be searched. Type:Node
	 * @param tag
	 *            Tag name from which text to be fetched. Type:String
	 * @return Text context of the tag
	 */
	public String getNodeText(Node n, String tag) {

		String textContext = null;
		String text = null;
		List<Node> cl = traverse(n);
		for (int i = 0; i < cl.size(); i++) {
			String tagName = cl.get(i).getNodeName();
			textContext = cl.get(i).getTextContent();
			if (tagName.equalsIgnoreCase(tag)) {
				text = textContext;
			}
		}

		return text;
	}

	// ---------------------------------------------------------------------------------------------------------------
	
	/**
	 * Returns the list of text of a node by its tag name.
	 * 
	 * @param n :node in which tag to be searched
	 * @param tag :tag from which text to be fetched
	 * @return tag text
	 */
	public ArrayList<String> getAllNodeText(Node n, String tag) {

		ArrayList<String> textList = new ArrayList<String>();
		String textContext = null;

		List<Node> cl = traverse(n);
		for (int i = 0; i < cl.size(); i++) {
			String tagName = cl.get(i).getNodeName();
			textContext = cl.get(i).getTextContent();
			if (tagName.equalsIgnoreCase(tag)) {
				textList.add(textContext);
				
			}
		}
	
		return textList;
	}

	

	// -----------------------------------------------------------------------------------------
	
	/**
	 * Gets the list of node present inside the document when supplied with the
	 * tag name of node as parameter.
	 * 
	 * @param tagName
	 *            :tag name of the node
	 * 
	 * @return nodelist ArrayList of type node
	 */

	public ArrayList<Node> getAllNode(String tagName) {

		ArrayList<Node> nodelist = new ArrayList<Node>();
		NodeList nl = doc.getElementsByTagName(tagName);
		for (int x = 0; x < nl.getLength(); x++) {
			Node node = nl.item(x);
			if (node.getNodeName().equalsIgnoreCase(tagName)) {
				
				nodelist.add(node);
			}
		}

		return nodelist;
	}

	// -----------------------------------------------------------------------------------------

	
	/**
	 * Gets the list of nodes by tag name and attribute name.
	 * 
	 * @param tagName
	 *            : tag name of node.
	 * 
	 * @param attribName
	 *            : attribute name of node
	 * 
	 * @return list of node
	 */
	public ArrayList<Node> getAllNodes(String tagName, String attribName) {

		NodeList nodeList = doc.getElementsByTagName(tagName);

		ArrayList<Node> nodeLists = new ArrayList<Node>();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			if (node.hasAttributes()) {

				Attr attr = (Attr) node.getAttributes()
						.getNamedItem(attribName);
				if (attr != null) {
					nodeLists.add(node);
					
				}
			}

		}

		return nodeLists;
	}

	// -----------------------------------------------------------------------------------------
	/**
	 * 
	 * 
	 * @param tagName
	 *            
	 * @param attribName
	 *            Attribute name of that node
	 * @return node if present else null
	 */
	/**
	 * Gets the node by tag name, attribute name and attribute value.
	 * 
	 * @param tagName 
	 * 			String-Node/element name
	 * @param attribName
	 * 			 String-Attribute name of that node
	 * @param attribValue
	 * 			 String-Attribute value of that node
	 * @return Node 
	 * 
	 */
	public Node getNode(String tagName, String attribName, String attribValue) {

		NodeList nl = doc.getElementsByTagName(tagName);
		for (int x = 0; x < nl.getLength(); x++) {
			Node node = nl.item(x);
			if (node.hasAttributes()) {
				Attr attr = (Attr) node.getAttributes()
						.getNamedItem(attribName);
				if (attr != null && attr.getValue().equals(attribValue)) {
					return node;

				}
			}
		}

		return null;
	}

	// -----------------------------------------------------------------------------------------
	/**
	 * Gets the list of nodes by tag name ,attribute name, attribute value.
	 * 
	 * @param tagName
	 *            tag name of the node
	 * @param attribName
	 *            : attribute name node
	 * @param attribValue
	 *            : attribute value of the node
	 * @return list of nodes
	 */
	public ArrayList<Node> getAllNodes(String tagName, String attribName,
			String attribValue) {

		NodeList nodeList = doc.getElementsByTagName(tagName);

		ArrayList<Node> nodeLists = new ArrayList<Node>();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			if (node.hasAttributes()) {

				Attr attr = (Attr) node.getAttributes()
						.getNamedItem(attribName);
				if (attr != null && attr.getValue().equals(attribValue)) {
					nodeLists.add(node);
					
				}
			}

		}

		return nodeLists;
	}

	// ----------------------------BY XPATH METHOD----------------------

	/**
	 * Traverses through the document and returns the required data when
	 * supplied with xpath as param.
	 * 
	 * 
	 * @param expr
	 *            : xpath of the node
	 * @return :the node value
	 * @throws XPathExpressionException
	 */
	public String getValueByXpath(String expr) throws XPathExpressionException {
		
		//Compiles the expression to get a XPathExpression object
		XPathExpression xexpr = xpath.compile(expr);
	
		//Evaluates and return the expression against the XML Document to get the result.
		return (String) xexpr.evaluate(doc, XPathConstants.STRING);
	}

	// -----------------------------------------------------------------------------------------
	
	/**
	 * Returns the node by using xpath expression. 
	 * <p>
	 * Takes the xpath expression as a parameter evaluates it.
	 * 
	 * @param expr xpath expression
	 * @return n node 
	 * @throws XPathExpressionException
	 */
	public Node getNodeByXpath(String expr) throws XPathExpressionException
	{
		
		
		Node n = (Node)xpath.evaluate(expr,doc.getDocumentElement(), XPathConstants.NODE);
		
		return n;
	}
	//---------------------------------------------------------------------------------------------
	
	/**
	 * Returns the array list of node by using xpath.
	 * <p>
	 * Takes the xpath expression as a parameter and evaluates it to its specific type
	 * @param expr xpath expressions
	 * @return nodelist ArrayList of node 
	 * @throws XPathExpressionException
	 */
	public ArrayList<Node> getAllNodeByXpath(String expr) throws XPathExpressionException
	{

		ArrayList<Node> nodelist = new ArrayList<Node>();
		NodeList nl = (NodeList)xpath.evaluate(expr,doc.getDocumentElement(), XPathConstants.NODESET);
		
		nodelist=(ArrayList<Node>) aSList(nl);
		
		return nodelist;
       }

		
	
	
	
	

}
