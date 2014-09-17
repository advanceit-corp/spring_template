package org.advanceit.calcv2.template;

import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpException;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * OauthSessionProvider class
 * 
 * <P>Used as an auth tool to do the requests to SFDC
 *    
 * @author MPyvovarov
 */
public class OauthSessionProvider {
    
    /**
     * Returns a String that contains an access_token needed to do further authorized requests to SFDC
     * 
     * @param       String loginHost - end_point for auth. In the case of sandbox - https://test.salesforce.com/services/oauth2/token, prod - https://login.salesforce.com/services/oauth2/token
     *              String username - SFDC username
     *              String password - SFDC password
     *              String clientId - consumer_key created during creation of connected app of SFDC
     *              String secret - consumer_secret created during creation of connected app of SFDC
     *              String securityToken - security token for a specific user on SFDC
     *              
     * @return      String access_token
    */
    public static String sendRequestAndGetAccessToken(String loginHost, String username,
        String password, String clientId, String secret, String securityToken) //
        throws HttpException, IOException, JSONException {
      
      PostMethod method = new PostMethod(loginHost);
      
      HttpMethodParams params = new HttpMethodParams();

      StringBuilder content = new StringBuilder();
      content.append("grant_type=password");
      content.append("&client_id=" + clientId);
      content.append("&client_secret=" + secret);
      content.append("&username=" + username);
      content.append("&password=" + password + securityToken);

      method.setRequestEntity(new StringRequestEntity(content.toString(), "text/plain", "UTF-8"));
      method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

      HttpClient client = new HttpClient();
      client.executeMethod(method);
      
      byte[] responseBody = method.getResponseBody();
      JSONObject obj = new JSONObject();
      
      try {
        obj = new JSONObject(new String(responseBody));
      } catch (JSONException e) {
        e.printStackTrace();
      }
      
      return obj.getString("access_token");
    }
    
    /**
     * Returns a String that contains an HttpResponse body
     * 
     * @param       String accessToken
     *              String end_point
     *              
     * @return      String responseBody
    */
    public static String sendRequestWithAccessToken(String accessToken, String end_point) throws org.apache.commons.httpclient.HttpException, IOException, JSONException {
      
      PostMethod method = new PostMethod(end_point);
      
      HttpMethodParams params = new HttpMethodParams();

      StringBuilder content = new StringBuilder();

      method.setRequestEntity(new StringRequestEntity(content.toString(), "text/plain", "UTF-8"));
      method.setRequestHeader("Authorization", "OAuth " + accessToken);

      HttpClient client = new HttpClient();
      client.executeMethod(method);
      
      byte[] responseBody = method.getResponseBody();
      
      return new String(responseBody);
    }
}