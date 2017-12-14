/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nicolas Kircun
 */
@Embeddable
public class ProjectClientPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idproject")
    private int idproject;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclient")
    private int idclient;

    public ProjectClientPK() {
    }

    public ProjectClientPK(int idproject, int idclient) {
        this.idproject = idproject;
        this.idclient = idclient;
    }

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproject;
        hash += (int) idclient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectClientPK)) {
            return false;
        }
        ProjectClientPK other = (ProjectClientPK) object;
        if (this.idproject != other.idproject) {
            return false;
        }
        if (this.idclient != other.idclient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProjectClientPK[ idproject=" + idproject + ", idclient=" + idclient + " ]";
    }
    
}
