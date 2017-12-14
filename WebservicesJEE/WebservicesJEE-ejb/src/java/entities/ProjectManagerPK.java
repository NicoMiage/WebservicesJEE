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
public class ProjectManagerPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idproject")
    private int idproject;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmanager")
    private int idmanager;

    public ProjectManagerPK() {
    }

    public ProjectManagerPK(int idproject, int idmanager) {
        this.idproject = idproject;
        this.idmanager = idmanager;
    }

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public int getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(int idmanager) {
        this.idmanager = idmanager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproject;
        hash += (int) idmanager;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectManagerPK)) {
            return false;
        }
        ProjectManagerPK other = (ProjectManagerPK) object;
        if (this.idproject != other.idproject) {
            return false;
        }
        if (this.idmanager != other.idmanager) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProjectManagerPK[ idproject=" + idproject + ", idmanager=" + idmanager + " ]";
    }
    
}
