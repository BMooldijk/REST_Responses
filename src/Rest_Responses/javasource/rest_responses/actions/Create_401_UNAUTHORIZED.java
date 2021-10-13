// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package rest_responses.actions;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import rest_responses.RESTResponseProvider;
import java.util.UUID;

/**
 * The authentication credentials are missing, or if supplied are not valid or not sufficient to access the resource.
 */
public class Create_401_UNAUTHORIZED extends CustomJavaAction<IMendixObject>
{
	private java.lang.String WWWAuthenticate;
	private IMendixObject __HTTPResponse;
	private system.proxies.HttpResponse HTTPResponse;
	private java.lang.String Details;

	public Create_401_UNAUTHORIZED(IContext context, java.lang.String WWWAuthenticate, IMendixObject HTTPResponse, java.lang.String Details)
	{
		super(context);
		this.WWWAuthenticate = WWWAuthenticate;
		this.__HTTPResponse = HTTPResponse;
		this.Details = Details;
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		this.HTTPResponse = __HTTPResponse == null ? null : system.proxies.HttpResponse.initialize(getContext(), __HTTPResponse);

		// BEGIN USER CODE
		String instance = UUID.randomUUID().toString();
		Integer status = 401;
		
		
		String jsonResult = rest_responses.proxies.microflows.Microflows.getProblemResponseAsJSON(getContext(), "Unauthorized", this.Details, Integer.toUnsignedLong(status), null,null, instance); 
		
		Core.getLogger("ProblemJSONModule").warn("401 " + this.Details + " (instance:" + instance + ")");
		
		RESTResponseProvider rp = new RESTResponseProvider(this.context(), __HTTPResponse, status, jsonResult, "Unauthorized");
		rp.addHttpHeader("Content-type", "application/json");
		rp.addHttpHeader("WWW-Authenticate", this.WWWAuthenticate);
		
		return rp.getResponse();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Create_401_UNAUTHORIZED";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}