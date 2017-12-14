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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "project_team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectTeam.findAll", query = "SELECT p FROM ProjectTeam p")
    , @NamedQuery(name = "ProjectTeam.findByDatestart", query = "SELECT p FROM ProjectTeam p WHERE p.datestart = :datestart")
    , @NamedQuery(name = "ProjectTeam.findByDateend", query = "SELECT p FROM ProjectTeam p WHERE p.dateend = :dateend")
    , @NamedQuery(name = "ProjectTeam.findById", query = "SELECT p FROM ProjectTeam p WHERE p.id = :id")})
public class ProjectTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datestart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datestart;
    @Column(name = "dateend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateend;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idmember", referencedColumnName = "idcontact")
    @ManyToOne(optional = false)
    private Contact idmember;
    @JoinColumn(name = "idproject", referencedColumnName = "idproject")
    @ManyToOne(optional = false)
    private Project idproject;
    @JoinColumn(name = "idtask", referencedColumnName = "idtask")
    @ManyToOne(optional = false)
    private Task idtask;
    @JoinColumn(name = "status", referencedColumnName = "code_status")
    @ManyToOne(optional = false)
    private Status status;

    public ProjectTeam() {
    }

    public ProjectTeam(Integer id) {
        this.id = id;
    }

    public ProjectTeam(Integer id, Date datestart) {
        this.id = id;
        this.datestart = datestart;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contact getIdmember() {
        return idmember;
    }

    public void setIdmember(Contact idmember) {
        this.idmember = idmember;
    }

    public Project getIdproject() {
        return idproject;
    }

    public void setIdproject(Project idproject) {
        this.idproject = idproject;
    }

    public Task getIdtask() {
        return idtask;
    }

    public void setIdtask(Task idtask) {
        this.idtask = idtask;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectTeam)) {
            return false;
        }
        ProjectTeam other = (ProjectTeam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProjectTeam[ id=" + id + " ]";
    }
    
}
