/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nicolas Kircun
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.findByIdproject", query = "SELECT p FROM Project p WHERE p.idproject = :idproject")
    , @NamedQuery(name = "Project.findByCode", query = "SELECT p FROM Project p WHERE p.code = :code")
    , @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description")
    , @NamedQuery(name = "Project.findByStartdate", query = "SELECT p FROM Project p WHERE p.startdate = :startdate")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproject")
    private Integer idproject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproject")
    private Collection<ProjectTeam> projectTeamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproject")
    private Collection<Task> taskCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<ProjectClient> projectClientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproject")
    private Collection<Release> releaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<ProjectManager> projectManagerCollection;

    public Project() {
    }

    public Project(Integer idproject) {
        this.idproject = idproject;
    }

    public Project(Integer idproject, String code) {
        this.idproject = idproject;
        this.code = code;
    }

    public Integer getIdproject() {
        return idproject;
    }

    public void setIdproject(Integer idproject) {
        this.idproject = idproject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @XmlTransient
    public Collection<ProjectTeam> getProjectTeamCollection() {
        return projectTeamCollection;
    }

    public void setProjectTeamCollection(Collection<ProjectTeam> projectTeamCollection) {
        this.projectTeamCollection = projectTeamCollection;
    }

    @XmlTransient
    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

    @XmlTransient
    public Collection<ProjectClient> getProjectClientCollection() {
        return projectClientCollection;
    }

    public void setProjectClientCollection(Collection<ProjectClient> projectClientCollection) {
        this.projectClientCollection = projectClientCollection;
    }

    @XmlTransient
    public Collection<Release> getReleaseCollection() {
        return releaseCollection;
    }

    public void setReleaseCollection(Collection<Release> releaseCollection) {
        this.releaseCollection = releaseCollection;
    }

    @XmlTransient
    public Collection<ProjectManager> getProjectManagerCollection() {
        return projectManagerCollection;
    }

    public void setProjectManagerCollection(Collection<ProjectManager> projectManagerCollection) {
        this.projectManagerCollection = projectManagerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproject != null ? idproject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idproject == null && other.idproject != null) || (this.idproject != null && !this.idproject.equals(other.idproject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Project[ idproject=" + idproject + " ]";
    }
    
}
