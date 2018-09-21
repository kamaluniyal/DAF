package com.markit.DigitalAutomationFramework.utilities;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.xml.sax.InputSource;

import com.markit.DigitalAutomationFramework.common.PropertyReader;


/**Class contains implementation of HTTP methods GET, POST and PUT.
 * All methods return integer value of response code from server.
 * Response content, response status line and InputSource equivalent can be accessed separately.
 * 
 * @author priyesh.tuli
 *
 */
public class HTTPOperations {
	
	/**Used for sending requests to server.
	 * 
	 */
    CloseableHttpClient httpclient = createHttpClient_AcceptsUntrustedCerts();
    
    /**Server status line message.
     * 
     */
    public String statusLine;
    
    /**InputSource equivalent of response content.
     * 
     */
    public InputSource inputsource;
    
    /**String response of server response.
     * 
     */
    public String outputString;
    
	
	/**HTTP GET method.
	 * 
	 */
	private HttpGet httpGet;
	
	/**HTTP POST method.
	 * 
	 */
	private HttpPost httpPost;
	
	/**HTTP PUT method.
	 * 
	 */
	private HttpPut httpPut;
	
	/**HTTP Response method.
	 * 
	 */
	private HttpResponse response;

	/**Method bypasses the security certificate requirement for the requested link.
	 * 
	 * @return CloseableHttpClient that can be used to bypass cert checks
	 */
	private CloseableHttpClient createHttpClient_AcceptsUntrustedCerts() {
	    HttpClientBuilder b = HttpClientBuilder.create();
	 
	    // setup a Trust Strategy that allows all certificates.
	    //
	    SSLContext sslContext = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			    public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			        return true;
			    }
			}).build();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.setSslcontext(sslContext);
	    
		
	    // don't check Hostnames, either.
	    //      -- use SSLConnectionSocketFactory.getDefaultHostnameVerifier(), if you don't want to weaken
	    HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
	    
	    // here's the special part:
	    //      -- need to create an SSL Socket Factory, to use our weakened "trust strategy";
	    //      -- and create a Registry, to register it.
	    //
	    SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
	    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
	            .register("http", PlainConnectionSocketFactory.getSocketFactory())
	            .register("https", sslSocketFactory)
	            .build();
	    
	    // now, we create connection-manager using our Registry.
	    //      -- allows multi-threaded use
	    PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager( socketFactoryRegistry);
	    b.setConnectionManager( connMgr);
	 
	    // finally, build the HttpClient;
	    //      -- done!
	    CloseableHttpClient client = b.build();
	    return client;
	}
	
	/**This method handles HTTP GET requests and returns status code.
	 * 
	 * @param requestURL : Url for server location where GET request is required to be made.
	 * @return Response code of Get request.
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int handleGET(String requestURL) throws ClientProtocolException, IOException{
								
					
		httpGet = new HttpGet(requestURL);		
						
		inputsource=null;
			
		outputString="";
		
		//taking response by executing http GET object
		CloseableHttpResponse response = httpclient.execute(httpGet);		
	
		/* 
		 * 	The underlying HTTP connection is still held by the response object
			to allow the response content to be streamed directly from the network socket.
			In order to ensure correct deallocation of system resources
			the user MUST call CloseableHttpResponse.close() from a finally clause.
			Please note that if response content is not fully consumed the underlying
			connection cannot be safely re-used and will be shut down and discarded
			by the connection manager.
		 */
		
			statusLine= response.getStatusLine().toString();		//status line
			
			HttpEntity entity1 = response.getEntity();				//getting response entity from server response 	
					
			BufferedReader br=new BufferedReader(new InputStreamReader(entity1.getContent()));

			String line;
			while((line=br.readLine())!=null)
			{
				outputString=outputString+line.toString();
	        }
			
			//removing spaces around server response string.
			outputString.trim();									
			
			//converting server response string into InputSource.
			inputsource = new InputSource(new StringReader(outputString));	
			
			// and ensure it is fully consumed
			EntityUtils.consume(entity1);			//consuming entity.
			response.close();						//closing response.
			br.close();								//closing buffered reader
			
			//returning response code
			return response.getStatusLine().getStatusCode();
	
	}
	
	/**Method saves the file in requested format (example: txt, xml) at location supplied in property file. 
	 * Also returns a file object of the same
	 * 
	 * @param fileExtension : Extension of file in which it has to be saved without prefixing '.'.
	 * 
	 * @return Returns file object of file created.
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public File saveFile(String fileExtension) throws UnsupportedEncodingException, FileNotFoundException, IOException
	{
		Date date = new Date();												// date object created, used in naming file as time stamp.
		SimpleDateFormat ft = new SimpleDateFormat ("MM_dd HH mm ss");		// setting format
		String fileName="serverResponse_"+ft.format(date)+"."+fileExtension;//setting file name.			 
		String location = PropertyReader.getFieldValue("xmlFileLocation");	//getting location from properties file
		File file=new File(location+fileName);							//file object of newly saved file.
		if (!file.exists()) 
			file.createNewFile();
		
		
		outputString.trim();				//removing white spaces around server response.
				
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(outputString);				//writing content to file.
		bw.close();							//closing buffered reader.
		
		return file;						//returning file object of xml file.
	}
	
	/**This method send request to server using HTTP POST method.
	 * 
	 * @param contentPayload : Text of payload that has to be sent.
	 * @param contentType : Content-Type header. (Example: application/xml).
	 * @param requestURL : Location at server.
	 * 
	 * @return Response code of processed request.
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int handlePOST(String contentPayload, String contentType, String requestURL) throws ClientProtocolException, IOException{
		
		inputsource=null;
		outputString="";
		
		httpPost = new HttpPost(requestURL);				//http POST object
		httpPost.setHeader("Content-Type", contentType);	//setting content type
		
		// payload
		HttpEntity entity = new ByteArrayEntity(contentPayload.getBytes("UTF-8"));
		httpPost.setEntity(entity);
		
		response = httpclient.execute(httpPost);			//response object to capture response by executing httpPost.
		
		//response entity
	    HttpEntity resEntity = response.getEntity();
	    
	    BufferedReader br=new BufferedReader(new InputStreamReader(resEntity.getContent()));
	 	String line;
	 	statusLine= response.getStatusLine().toString();	//status line
	 	
	 	//saving response from server in outputString
	 	while((line=br.readLine())!=null)
	 	{
	 		outputString=outputString+line.toString();
	 	}
	 	outputString.trim();
	 	inputsource = new InputSource(new StringReader(outputString));
	 	br.close();				//close the buffered reader
	 	
	 	//returns status code
	    return response.getStatusLine().getStatusCode();
	}
	
	/**Executes PUT method. 
	 * Takes an xml payload on the requested server and performs put method.
	 * 
	 * @param contentPayload : Payload content.
	 * @param contentType : Type of content.
	 * @param requestURL : Location on server.
	 * 
	 * @return Response code from server after executing method.
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int handlePUT(String contentPayload, String contentType, String requestURL) throws ClientProtocolException, IOException{
		
		inputsource=null;
		
		outputString=""; 
		
		httpPut = new HttpPut(requestURL);						// http PUT object
		httpPut.setHeader("Content-Type", contentType);			// setting content type
		
		//xml payload
		HttpEntity entity = new ByteArrayEntity(contentPayload.getBytes("UTF-8"));
		httpPut.setEntity(entity);
		
		// creating response object to capture response from server.
		response = httpclient.execute(httpPut);							
		
		//response entity
	    HttpEntity resEntity = response.getEntity();
	    statusLine= response.getStatusLine().toString();		//status line
	    BufferedReader br=new BufferedReader(new InputStreamReader(resEntity.getContent()));
	 	String line;
	 	
	 	//saving response from server in outputString
	 	while((line=br.readLine())!=null)
	 	{
	 		outputString=outputString+line.toString();
	 	}
	 	outputString.trim();
	 	inputsource = new InputSource(new StringReader(outputString));
	 	br.close();												//close the buffered reader
	 	
	 	//returns status code
	    return response.getStatusLine().getStatusCode();
		
	}
			
	/**Performs delete operation using HTTP Delete method.
	 * 
	 * @param requestURL : location on server.
	 * @return : returns integer value of http response. 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int handleDelete(String requestURL) throws ClientProtocolException, IOException{
												
		inputsource=null;
	
		HttpDelete del=new HttpDelete(requestURL);				//initialising delete object
		response=httpclient.execute(del);						//executing deletion operation on url
		
		statusLine= response.getStatusLine().toString();		//status line
		
		HttpEntity entity1 = response.getEntity();				//getting response entity from server response 	
		
		//getting content from entity of response.
		BufferedReader br=new BufferedReader(new InputStreamReader(entity1.getContent()));
		
		String line;
		while((line=br.readLine())!=null)
		{
			outputString=outputString+line.toString();
        }
		
		//removing spaces around server response string.
		outputString.trim();
		
		//converting server response string into InputSource.
		inputsource = new InputSource(new StringReader(outputString));
		
		// and ensure it is fully consumed
		EntityUtils.consume(entity1);			//consuming entity.
		br.close();								//closing buffered reader
		
		return response.getStatusLine().getStatusCode();
	}
	
	/**Returns string equivalent of status line of the last executed request.
	 * 
	 * @return : Returns status line
	 */
	public String getStatusLine() {
		
		return statusLine;
	
	}
	
	/**Returns input source of response of the last executed request.
	 * @return 
	 * 
	 * @return : Returns InputSource of latest server response.
	 */
	public InputSource getInputSource() {
		
		return inputsource;
	
	}
	
	/**Returns string equivalent of response of the last executed request.
	 * 
	 * @return : Returns server response in string.
	 */
	public String getoutputString() {
		return outputString;
	}
	
}
