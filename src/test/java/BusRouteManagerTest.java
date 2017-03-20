import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 21/03/17.
 */
public class BusRouteManagerTest {

    @Test
    public void testBusRouteData(){
        String busRoute1 = "0 0 1 2 3 4";
        String busRoute2 = "1 3 1 6 5";
        Map<Integer,StationNode> stationNodeMap = new HashMap<>();
        BusRouteManager.populateStationMap(busRoute1,stationNodeMap);
        BusRouteManager.populateStationMap(busRoute2,stationNodeMap);

        StationNode stationNode = stationNodeMap.get(1);
        // if 1 is connected to 2 on route id 0
        Assert.assertTrue(stationNode.getRouteStationMap().get(0).getStationId().equals(2));
        // if 1 is connected to 6 on route id 1
        Assert.assertTrue(stationNode.getRouteStationMap().get(1).getStationId().equals(6));

    }
}
