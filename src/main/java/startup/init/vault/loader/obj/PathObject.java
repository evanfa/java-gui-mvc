package startup.init.vault.loader.obj;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "",namespace="http://www.eclipse.org/eclipselink/xsds/persistence/oxm")
// order of the fields in XML
//@XmlType(propOrder = {"price", "name"})
@XmlType(propOrder = {"id", "path","project","depto","description"})
//@XmlType(name="", propOrder={"error"})
@XmlAccessorType(XmlAccessType.FIELD)
public class PathObject {

    @XmlAttribute
    int id;
    @XmlElement(name = "path_location")
    String path;
    @XmlElement(name = "project")
    String project;
    @XmlElement(name = "depto")
    String depto;
    @XmlElement(name = "desc")
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PathObject{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", project='" + project + '\'' +
                ", depto='" + depto + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}