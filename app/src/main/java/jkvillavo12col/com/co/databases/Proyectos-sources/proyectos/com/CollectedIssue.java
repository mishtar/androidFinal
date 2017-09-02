
package mishtar.proyectos.com;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollectedIssue {

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public CollectedIssue withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CollectedIssue withName(String name) {
        this.name = name;
        return this;
    }

}
