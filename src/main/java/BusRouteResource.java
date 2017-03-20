import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by amit.bhengra on 20/03/17.
 *
 * This class exposes the REST api
 */


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class BusRouteResource {


    final static String DEPART_SID = "dep_sid";
    final static String ARRIVAL_SID = "arr_sid";

    /**
     *
     * @param httpRequest HttpRequest object which holds all the http context
     * @return DirectRouteInfo which contains departid, arrivalid and if connected
     */
    @GET
    @Path("/direct")
    public DirectRouteInfo directConnection(@Context HttpServletRequest httpRequest) {
        String departSid = httpRequest.getParameter(DEPART_SID);
        String arrivalSid = httpRequest.getParameter(ARRIVAL_SID);

        Integer depId = null;
        Integer arrId = null;
        try {
            depId = Integer.valueOf(departSid);
            arrId = Integer.valueOf(arrivalSid);
            Boolean hasDirectConnection = BusRouteHandler.hasDirectConnection(depId, arrId, BusRouteManager.getStationNodeMap());
            DirectRouteInfo directRouteInfo = new DirectRouteInfo(depId, arrId, hasDirectConnection);
            return directRouteInfo;
        } catch (Exception e) {

        }
        return new DirectRouteInfo(depId, arrId,false);
    }
}
