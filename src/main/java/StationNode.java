import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 20/03/17.
 *
 * Bean class for holding the Station Node Data
 *
 * RouteStationMap is for storing bus route id to station id
 */

public class StationNode {

    Integer stationId;
    Map<Integer,StationNode> routeStationMap = new HashMap<>();

    public StationNode(Integer id) {
        this.stationId = id;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Map<Integer, StationNode> getRouteStationMap() {
        return routeStationMap;
    }

    public void setRouteStationMap(Map<Integer, StationNode> routeStationMap) {
        this.routeStationMap = routeStationMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StationNode that = (StationNode) o;

        if (!stationId.equals(that.stationId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return stationId.hashCode();
    }
}
