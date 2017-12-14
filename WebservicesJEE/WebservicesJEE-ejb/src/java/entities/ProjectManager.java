/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicolas Kircun
 */
@Entity
@Table(name = "project_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectManager.findAll", query = "SELECT p FROM ProjectManager p")
    , @NamedQuery(name = "ProjectManager.findByIdproject", query = "SELECT p FROM ProjectManager p WHERE p.projectManagerPK.idproject = :idproject")
    , @NamedQuery(name = "ProjectManager.findByIdmanager", query = "SELECT p FROM ProjectManager p WHERE p.projectManagerPK.idmanager = :idmanager")
    , @NamedQuery(name = "ProjectManager.findByStartdate", query = "SELECT p FROM ProjectManager p WHERE p.startdate = :startdate")})
public class ProjectManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectManagerPK projectManagerPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @JoinColumn(name = "idmanager", referencedColumnName = "idcontact", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contact contact;
    @JoinColumn(name = "idproject", referencedColumnName = "idproject", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public ProjectManager() {
    }

    public ProjectManager(ProjectManagerPK projectManagerPK) {
        this.projectManagerPK = projectManagerPK;
    }

    public ProjectManager(ProjectManagerPK projectManagerPK, Date startdate) {
        this.projectManagerPK = projectManagerPK;
        this.startdate = startdate;
    }

    public ProjectManager(int idproject, int idmanager) {
        this.projectManagerPK = new ProjectManagerPK(idproject, idmanager);
    }

    public ProjectManagerPK getProjectManagerPK() {
        return projectManagerPK;
    }

    public void setProjectManagerPK(ProjectManagerPK projectManagerPK) {
        this.projectManagerPK = projectManagerPK;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectManagerPK != null ? projectManagerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectManager)) {
            return false;
        }
        ProjectManager other = (ProjectManager) object;
        if ((this.projectManagerPK == null && other.projectManagerPK != null) || (this.projectManagerPK != null && !this.projectManagerPK.equals(other.projectManagerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProjectManager[ projectManagerPK=" + projectManagerPK + " ]";
    }
    
}
