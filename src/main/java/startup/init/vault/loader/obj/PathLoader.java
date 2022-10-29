package startup.init.vault.loader.obj;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "path_loader")
@XmlType(propOrder = {"id", "tvdrPath", "txtlPath", "sdttPath", "topoPath"})
//@XmlAccessorType(XmlAccessType.FIELD)
public class PathLoader {
    private Long id;
    private String tvdrPath;
    private String txtlPath;
    private String sdttPath;
    private String topoPath;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "tvdr_project")
    public void setTvdrPath(String tvdrPath) {
        this.tvdrPath = tvdrPath;
    }

    @XmlElement(name = "txtl_project")
    public void setTxtlPath(String txtlPath) {
        this.txtlPath = txtlPath;
    }

    @XmlElement(name = "sdtt_project")
    public void setSdttPath(String sdttPath) {
        this.sdttPath = sdttPath;
    }

    @XmlElement(name = "topo_project")
    public void setTopoPath(String topoPath) {
        this.topoPath = topoPath;
    }

    public String getTvdrPath() {
        return tvdrPath;
    }

    public String getTxtlPath() {
        return txtlPath;
    }

    public String getSdttPath() {
        return sdttPath;
    }

    public String getTopoPath() {
        return topoPath;
    }

    @Override
    public String toString() {
        return "PathLoader{" +
                "id=" + id +
                ", tvdrPath='" + tvdrPath + '\'' +
                ", txtlPath='" + txtlPath + '\'' +
                ", sdttPath='" + sdttPath + '\'' +
                ", topoPath='" + topoPath + '\'' +
                '}';
    }

    /*
    @XmlRootElement: The name of the root XML element is derived from the class name, and we can also specify the name of the root element of the XML using its name attribute.
    @XmlType: define the order in which the fields are written in the XML file
    @XmlElement: define the actual XML element name that will be used
    @XmlAttribute: define the id field is mapped as an attribute instead of an element
    @XmlTransient: annotate fields that we don't want to be included in XML
     */
}
