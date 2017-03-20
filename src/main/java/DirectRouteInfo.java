import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by amit.bhengra on 20/03/17.
 *
 * Bean class for holding the depId, arrId and isConnected info
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectRouteInfo {

    @JsonProperty("dep_sid")
    Integer departStationId;

    @JsonProperty("arr_sid")
    Integer arrivalStationId;

    @JsonProperty("direct_bus_route")
    Boolean directBusRoute;

    public DirectRouteInfo(Integer depId, Integer arrId, Boolean hasDirectConnection) {
        this.departStationId = depId;
        this.arrivalStationId = arrId;
        this.directBusRoute = hasDirectConnection;
    }

    public Integer getArrivalStationId() {
        return arrivalStationId;
    }

    public void setArrivalStationId(Integer arrivalStationId) {
        this.arrivalStationId = arrivalStationId;
    }

    public Integer getDepartStationId() {
        return departStationId;
    }

    public void setDepartStationId(Integer departStationId) {
        this.departStationId = departStationId;
    }

    public Boolean getDirectBusRoute() {
        return directBusRoute;
    }

    public void setDirectBusRoute(Boolean directBusRoute) {
        this.directBusRoute = directBusRoute;
    }
}
