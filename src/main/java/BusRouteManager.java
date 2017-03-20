import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 20/03/17.
 *
 * This class is responsible for holding the
 * data structure of all the station Nodes.
 *
 * Station Nodes are in the form of parent child
 * relationship, where the relationship is established
 * based on the bus route they are on and if they are connected.
 *
 */
public class BusRouteManager {

    static Map<Integer,StationNode> stationNodeMap = new HashMap<>();
    static final String BUS_ROUTE_SEPARATOR = " ";

    public static Map<Integer, StationNode> getStationNodeMap() {
        return stationNodeMap;
    }

    public static void setStationNodeMap(Map<Integer, StationNode> stationNodeMap) {
        BusRouteManager.stationNodeMap = stationNodeMap;
    }

    /**
     *
     * @param fileName FileName to load data fro
     * @throws Exception
     */
    public static void initManager(String fileName) throws Exception {
        BufferedReader bi = new BufferedReader(new FileReader(fileName));
        int testCases = Integer.parseInt(bi.readLine());
        while (testCases-- > 0){
            String busRoute = bi.readLine();
            populateStationMap(busRoute,stationNodeMap);
        }
    }

    /**
     *
     * @param busRoute busRoute string with bus route id and the station ids
     * @param stationNodeMap The map of all the station nodes
     */
    public static void populateStationMap(String busRoute,Map<Integer,StationNode> stationNodeMap){
        if (busRoute!=null && !busRoute.isEmpty()){
            String[] busStations = busRoute.split(BUS_ROUTE_SEPARATOR);
            Integer busRouteId = Integer.valueOf(busStations[0]);
            for (int i=2;i<busStations.length;i++){
                Integer fromStationId = Integer.valueOf(busStations[i-1]);
                Integer toStationId = Integer.valueOf(busStations[i]);
                StationNode fromStation = stationNodeMap.get(fromStationId);
                StationNode toStation = stationNodeMap.get(toStationId);
                if (fromStation == null) {
                    fromStation = new StationNode(fromStationId);
                    stationNodeMap.put(fromStationId,fromStation);
                }
                if (toStation == null) {
                    toStation = new StationNode(toStationId);
                    stationNodeMap.put(toStationId,toStation);
                }
                fromStation.getRouteStationMap().put(busRouteId,toStation);
            }
        }
    }
}
