package resources;

/**
 * @author raptor
 *         date: 10.03.16
 */
public class ResourceServer {
    private TestResource testResource;

    public ResourceServer() {
        this.testResource = new TestResource();
    }

    public ResourceServer(TestResource testResource) {
        this.testResource = testResource;
    }

    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }

    public String getName() {
        return testResource.getName();
    }

    public int getAge() {
        return testResource.getAge();
    }
}
