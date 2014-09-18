/*******************************************************************************
*
* © Copyright by Endava 2014.
*
* All Rights Reserved
*
* Endava – Internal Use Only
*
*******************************************************************************/
package net.club.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2890866858893746226L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public AbstractModel() {
        super();
    }

    @Override
    public String toString() {
        return "AbstractModel [id=" + id + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractModel other = (AbstractModel) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
