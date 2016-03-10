package resources;

/**
 * Created by raptor on 10.03.16.
 */
public class ResourceServerController implements ResourceServerControllerMBean {
    private final ResourceServer resourceServer;

    public ResourceServerController(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getName() {
        return resourceServer.getName();
    }

    @Override
    public int getAge() {
        return resourceServer.getAge();
    }
}
