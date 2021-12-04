package iptracker.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iptracker.business.IPResponseManager;
import iptracker.model.BaseResponse;
import iptracker.model.IPRequest;
import iptracker.model.IPResponse;

@Path("/app")
public class IPTrackerApi {

	@Context
	private HttpServletRequest httpRequest;
	@Context
	private HttpServletResponse httpResponse;

	/**
	 * API that tests the connection to the server
	 * 
	 * @return BaseResponse
	 */
	@POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse test() {

		BaseResponse resp = new BaseResponse();

		try {

		} catch (Exception e) {

			resp.setErrorByException(e);
		}

		return resp;
	}

	@POST
	@Path("/getIp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public IPResponse getIp(IPRequest req) {

		IPResponse resp = new IPResponse();
		IPResponseManager iprm = new IPResponseManager();

		try {
			
			if(req.getIp() == "") {
				
				resp.setIp(httpRequest.getRemoteAddr());
			} else {
				
				resp.setIp(req.getIp());
			}
			
			resp = iprm.getUserIpInfo(resp);
			
		} catch (Exception e) {

			resp.setErrorByException(e);
		}

		return resp;
	}

}
