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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nicolas Kircun
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findByIdcontact", query = "SELECT c FROM Contact c WHERE c.idcontact = :idcontact")
    , @NamedQuery(name = "Contact.findByLogin", query = "SELECT c FROM Contact c WHERE c.login = :login")
    , @NamedQuery(name = "Contact.findByPassword", query = "SELECT c FROM Contact c WHERE c.password = :password")
    , @NamedQuery(name = "Contact.findByIsClient", query = "SELECT c FROM Contact c WHERE c.isClient = :isClient")
    , @NamedQuery(name = "Contact.findByIsTeam", query = "SELECT c FROM Contact c WHERE c.isTeam = :isTeam")
    , @NamedQuery(name = "Contact.findByIsAdmin", query = "SELECT c FROM Contact c WHERE c.isAdmin = :isAdmin")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontact")
    private Integer idcontact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "isClient")
    private Boolean isClient;
    @Column(name = "isTeam")
    private Boolean isTeam;
    @Column(name = "isAdmin")
    private Boolean isAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmember")
    private Collection<ProjectTeam> projectTeamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private Collection<ProjectClient> projectClientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contact")
    private Collection<ProjectManager> projectManagerCollection;

    public Contact() {
    }

    public Contact(Integer idcontact) {
        this.idcontact = idcontact;
    }

    public Contact(Integer idcontact, String login, String password) {
        this.idcontact = idcontact;
        this.login = login;
        this.password = password;
    }

    public Integer getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(Integer idcontact) {
        this.idcontact = idcontact;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsClient() {
        return isClient;
    }

    public void setIsClient(Boolean isClient) {
        this.isClient = isClient;
    }

    public Boolean getIsTeam() {
        return isTeam;
    }

    public void setIsTeam(Boolean isTeam) {
        this.isTeam = isTeam;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @XmlTransient
    public Collection<ProjectTeam> getProjectTeamCollection() {
        return projectTeamCollection;
    }

    public void setProjectTeamCollection(Collection<ProjectTeam> projectTeamCollection) {
        this.projectTeamCollection = projectTeamCollection;
    }

    @XmlTransient
    public Collection<ProjectClient> getProjectClientCollection() {
        return projectClientCollection;
    }

    public void setProjectClientCollection(Collection<ProjectClient> projectClientCollection) {
        this.projectClientCollection = projectClientCollection;
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
        hash += (idcontact != null ? idcontact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.idcontact == null && other.idcontact != null) || (this.idcontact != null && !this.idcontact.equals(other.idcontact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contact[ idcontact=" + idcontact + " ]";
    }
    
}
