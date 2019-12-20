/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollPACKAGE;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sandaru
 */
@Entity
@Table(name = "finalsaldet", catalog = "manojtyre", schema = "")
@NamedQueries({
    @NamedQuery(name = "Finalsaldet.findAll", query = "SELECT f FROM Finalsaldet f"),
    @NamedQuery(name = "Finalsaldet.findByEmployeeID", query = "SELECT f FROM Finalsaldet f WHERE f.employeeID = :employeeID"),
    @NamedQuery(name = "Finalsaldet.findByMonth", query = "SELECT f FROM Finalsaldet f WHERE f.month = :month"),
    @NamedQuery(name = "Finalsaldet.findByETFrate", query = "SELECT f FROM Finalsaldet f WHERE f.eTFrate = :eTFrate"),
    @NamedQuery(name = "Finalsaldet.findByEPFrate", query = "SELECT f FROM Finalsaldet f WHERE f.ePFrate = :ePFrate"),
    @NamedQuery(name = "Finalsaldet.findByExistingETFEPF", query = "SELECT f FROM Finalsaldet f WHERE f.existingETFEPF = :existingETFEPF"),
    @NamedQuery(name = "Finalsaldet.findBySalary", query = "SELECT f FROM Finalsaldet f WHERE f.salary = :salary")})
public class Finalsaldet implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeID")
    private Integer employeeID;
    @Basic(optional = false)
    @Column(name = "month")
    private String month;
    @Basic(optional = false)
    @Column(name = "ETF_rate")
    private int eTFrate;
    @Basic(optional = false)
    @Column(name = "EPF_rate")
    private int ePFrate;
    @Column(name = "Existing_ETF_EPF")
    private Integer existingETFEPF;
    @Basic(optional = false)
    @Column(name = "Salary")
    private int salary;

    public Finalsaldet() {
    }

    public Finalsaldet(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Finalsaldet(Integer employeeID, String month, int eTFrate, int ePFrate, int salary) {
        this.employeeID = employeeID;
        this.month = month;
        this.eTFrate = eTFrate;
        this.ePFrate = ePFrate;
        this.salary = salary;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        Integer oldEmployeeID = this.employeeID;
        this.employeeID = employeeID;
        changeSupport.firePropertyChange("employeeID", oldEmployeeID, employeeID);
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        String oldMonth = this.month;
        this.month = month;
        changeSupport.firePropertyChange("month", oldMonth, month);
    }

    public int getETFrate() {
        return eTFrate;
    }

    public void setETFrate(int eTFrate) {
        int oldETFrate = this.eTFrate;
        this.eTFrate = eTFrate;
        changeSupport.firePropertyChange("ETFrate", oldETFrate, eTFrate);
    }

    public int getEPFrate() {
        return ePFrate;
    }

    public void setEPFrate(int ePFrate) {
        int oldEPFrate = this.ePFrate;
        this.ePFrate = ePFrate;
        changeSupport.firePropertyChange("EPFrate", oldEPFrate, ePFrate);
    }

    public Integer getExistingETFEPF() {
        return existingETFEPF;
    }

    public void setExistingETFEPF(Integer existingETFEPF) {
        Integer oldExistingETFEPF = this.existingETFEPF;
        this.existingETFEPF = existingETFEPF;
        changeSupport.firePropertyChange("existingETFEPF", oldExistingETFEPF, existingETFEPF);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        int oldSalary = this.salary;
        this.salary = salary;
        changeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finalsaldet)) {
            return false;
        }
        Finalsaldet other = (Finalsaldet) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "payrollPACKAGE.Finalsaldet[ employeeID=" + employeeID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
