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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "release")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Release.findAll", query = "SELECT r FROM Release r")
    , @NamedQuery(name = "Release.findByIdrelease", query = "SELECT r FROM Release r WHERE r.idrelease = :idrelease")
    , @NamedQuery(name = "Release.findByDaterelease", query = "SELECT r FROM Release r WHERE r.daterelease = :daterelease")
    , @NamedQuery(name = "Release.findByVersion", query = "SELECT r FROM Release r WHERE r.version = :version")})
public class Release implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelease")
    private Integer idrelease;
    @Column(name = "daterelease")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daterelease;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "version")
    private String version;
    @JoinTable(name = "sprint", joinColumns = {
        @JoinColumn(name = "idrelease", referencedColumnName = "idrelease")}, inverseJoinColumns = {
        @JoinColumn(name = "idtask", referencedColumnName = "idtask")})
    @ManyToMany
    private Collection<Task> taskCollection;
    @OneToMany(mappedBy = "idrelease")
    private Collection<ProjectClient> projectClientCollection;
    @JoinColumn(name = "idproject", referencedColumnName = "idproject")
    @ManyToOne(optional = false)
    private Project idproject;

    public Release() {
    }

    public Release(Integer idrelease) {
        this.idrelease = idrelease;
    }

    public Release(Integer idrelease, String version) {
        this.idrelease = idrelease;
        this.version = version;
    }

    public Integer getIdrelease() {
        return idrelease;
    }

    public void setIdrelease(Integer idrelease) {
        this.idrelease = idrelease;
    }

    public Date getDaterelease() {
        return daterelease;
    }

    public void setDaterelease(Date daterelease) {
        this.daterelease = daterelease;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public Project getIdproject() {
        return idproject;
    }

    public void setIdproject(Project idproject) {
        this.idproject = idproject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelease != null ? idrelease.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Release)) {
            return false;
        }
        Release other = (Release) object;
        if ((this.idrelease == null && other.idrelease != null) || (this.idrelease != null && !this.idrelease.equals(other.idrelease))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Release[ idrelease=" + idrelease + " ]";
    }
    
}
