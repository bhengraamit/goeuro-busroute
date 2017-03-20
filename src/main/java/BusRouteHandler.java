import java.util.Map;

/**
 * Created by amit.bhengra on 20/03/17.
 *
 * This class is responsible for handling all the requests of depart and
 * arrival station.
 *
 * Given a Map of station Nodes it returns if the depart and arrival station ids
 * are directly connected in a bus route
 */
public class BusRouteHandler {


    /**
     *
     * @param departId Id of Depart Station
     * @param arrivalId Id of Arrival Station
     * @param stationNodeMap Map of stations
     * @return true if directly connected else false
     */
    public static Boolean hasDirectConnection(Integer departId, Integer arrivalId, Map<Integer,StationNode> stationNodeMap){
        if (departId!=null && arrivalId!=null){
            if (!stationNodeMap.containsKey(departId))
                return false;
            if (!stationNodeMap.containsKey(arrivalId))
                return false;
            if (departId.equals(arrivalId))
                return true;
            StationNode departStation = stationNodeMap.get(departId);
            StationNode arrivalStation = stationNodeMap.get(arrivalId);
            return hasDirectConnection(departStation,arrivalStation);
        }
        return false;
    }

    /**
     *
     * @param departStation Depart Station Node
     * @param arrivalStation Arrival Station Node
     * @return true if directly connected else false
     */
    public static Boolean hasDirectConnection(StationNode departStation, StationNode arrivalStation) {
        if (departStation!=null && arrivalStation!=null){
            Map<Integer,StationNode> routeStationMap = departStation.getRouteStationMap();
            for (Map.Entry<Integer,StationNode> routeStation:routeStationMap.entrySet()){
                Boolean isConnected = isConnected(routeStation.getKey(),routeStation.getValue(),arrivalStation);
                if (isConnected)
                    return isConnected;
            }
        }
        return false;
    }

    /**
     *
     * @param key This is the bus route Id
     * @param departStation Depart Station Node
     * @param arrivalStation Arrival Station Node
     * @return true if directly connected in the same bus route else false
     */
    public static Boolean isConnected(Integer key, StationNode departStation, StationNode arrivalStation) {
        if (key!=null && departStation!=null && arrivalStation!=null){
            if (departStation.equals(arrivalStation)){
                return true;
            }
            else {
                return isConnected(key,departStation.getRouteStationMap().get(key),arrivalStation);
            }
        }
        return false;
    }
}
