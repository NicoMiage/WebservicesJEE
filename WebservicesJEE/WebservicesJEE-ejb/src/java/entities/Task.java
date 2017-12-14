/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nicolas Kircun
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
    , @NamedQuery(name = "Task.findByIdtask", query = "SELECT t FROM Task t WHERE t.idtask = :idtask")
    , @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtask")
    private Integer idtask;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "taskCollection")
    private Collection<Release> releaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtask")
    private Collection<ProjectTeam> projectTeamCollection;
    @JoinColumn(name = "idproject", referencedColumnName = "idproject")
    @ManyToOne(optional = false)
    private Project idproject;
    @JoinColumn(name = "status", referencedColumnName = "code_status")
    @ManyToOne(optional = false)
    private Status status;

    public Task() {
    }

    public Task(Integer idtask) {
        this.idtask = idtask;
    }

    public Integer getIdtask() {
        return idtask;
    }

    public void setIdtask(Integer idtask) {
        this.idtask = idtask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Release> getReleaseCollection() {
        return releaseCollection;
    }

    public void setReleaseCollection(Collection<Release> releaseCollection) {
        this.releaseCollection = releaseCollection;
    }

    @XmlTransient
    public Collection<ProjectTeam> getProjectTeamCollection() {
        return projectTeamCollection;
    }

    public void setProjectTeamCollection(Collection<ProjectTeam> projectTeamCollection) {
        this.projectTeamCollection = projectTeamCollection;
    }

    public Project getIdproject() {
        return idproject;
    }

    public void setIdproject(Project idproject) {
        this.idproject = idproject;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtask != null ? idtask.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.idtask == null && other.idtask != null) || (this.idtask != null && !this.idtask.equals(other.idtask))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Task[ idtask=" + idtask + " ]";
    }
    
}
