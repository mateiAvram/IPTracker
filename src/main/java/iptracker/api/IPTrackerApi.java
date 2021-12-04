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

import iptracker.model.BaseResponse;
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

	@GET
	@Path("/getIp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public IPResponse getIp() {

		IPResponse resp = new IPResponse();

		try {

			resp.setIp(httpRequest.getRemoteAddr());
			
		} catch (Exception e) {

			resp.setErrorByException(e);
		}

		return resp;
	}

}
