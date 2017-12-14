/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicolas Kircun
 */
@Entity
@Table(name = "project_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectClient.findAll", query = "SELECT p FROM ProjectClient p")
    , @NamedQuery(name = "ProjectClient.findByIdproject", query = "SELECT p FROM ProjectClient p WHERE p.projectClientPK.idproject = :idproject")
    , @NamedQuery(name = "ProjectClient.findByIdclient", query = "SELECT p FROM ProjectClient p WHERE p.projectClientPK.idclient = :idclient")})
public class ProjectClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectClientPK projectClientPK;
    @JoinColumn(name = "idclient", referencedColumnName = "idcontact", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contact contact;
    @JoinColumn(name = "idproject", referencedColumnName = "idproject", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;
    @JoinColumn(name = "idrelease", referencedColumnName = "idrelease")
    @ManyToOne
    private Release idrelease;

    public ProjectClient() {
    }

    public ProjectClient(ProjectClientPK projectClientPK) {
        this.projectClientPK = projectClientPK;
    }

    public ProjectClient(int idproject, int idclient) {
        this.projectClientPK = new ProjectClientPK(idproject, idclient);
    }

    public ProjectClientPK getProjectClientPK() {
        return projectClientPK;
    }

    public void setProjectClientPK(ProjectClientPK projectClientPK) {
        this.projectClientPK = projectClientPK;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Release getIdrelease() {
        return idrelease;
    }

    public void setIdrelease(Release idrelease) {
        this.idrelease = idrelease;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectClientPK != null ? projectClientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectClient)) {
            return false;
        }
        ProjectClient other = (ProjectClient) object;
        if ((this.projectClientPK == null && other.projectClientPK != null) || (this.projectClientPK != null && !this.projectClientPK.equals(other.projectClientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProjectClient[ projectClientPK=" + projectClientPK + " ]";
    }
    
}
