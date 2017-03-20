import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 20/03/17.
 */

public class BusRouteHandlerTest {

    StationNode stationNode1;
    StationNode stationNode2;
    StationNode stationNode3;

    Map<Integer,StationNode> stationNodeMap;

    @Before
    public void init(){
        StationNode stationNode1 = new StationNode(1);
        StationNode stationNode2 = new StationNode(2);
        StationNode stationNode3 = new StationNode(3);

        Map<Integer,StationNode> routeStationMap1 = new HashMap<>();
        routeStationMap1.put(1,stationNode2);
        stationNode1.setRouteStationMap(routeStationMap1);

        Map<Integer,StationNode> routeStationMap2 = new HashMap<>();
        routeStationMap2.put(1,stationNode3);
        stationNode2.setRouteStationMap(routeStationMap2);

        this.stationNode1 = stationNode1;
        this.stationNode2 = stationNode2;
        this.stationNode3 = stationNode3;
        stationNodeMap = new HashMap<>();
        stationNodeMap.put(1,stationNode1);
        stationNodeMap.put(2,stationNode2);
        stationNodeMap.put(3,stationNode3);
    }

    @Test
    public void testIsConnected(){


        Assert.assertTrue(BusRouteHandler.isConnected(1,stationNode1,stationNode3));
        stationNode2.getRouteStationMap().clear();
        // negative test case
        Assert.assertFalse(BusRouteHandler.isConnected(1,stationNode1,stationNode3));

    }


    @Test
    public void testDirectConnectedNodes(){
        Assert.assertTrue(BusRouteHandler.hasDirectConnection(stationNode1,stationNode3));
        Assert.assertFalse(BusRouteHandler.hasDirectConnection(stationNode3, stationNode1));
    }


    @Test
    public void hasDirectConnectionId(){
        Assert.assertTrue(BusRouteHandler.hasDirectConnection(1,3,stationNodeMap));
        Assert.assertFalse(BusRouteHandler.hasDirectConnection(3,2,stationNodeMap));
    }
}
