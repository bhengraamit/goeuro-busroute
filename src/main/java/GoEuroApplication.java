import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by amit.bhengra on 20/03/17.
 *
 * This Application's starting class which initializes jetty and jersey implementation etc
 */
public class GoEuroApplication extends Application<GoEuroConfiguration> {

    static String busRouteFile;

    public static void main(String[] args) throws Exception {
        busRouteFile = args[2];
        new GoEuroApplication().run(args[0],args[1]);

    }

    /**
     * This method initialises the REST endpoints, also loads data for bus routes
     * @param configuration Default Configuration picked from config.yml
     * @param environment
     * @throws Exception
     */
    @Override
    public void run(GoEuroConfiguration configuration, Environment environment) throws Exception {
        final BusRouteResource busRouteResource = new BusRouteResource();
        environment.jersey().register(busRouteResource);
        BusRouteManager.initManager(busRouteFile);
    }
}
