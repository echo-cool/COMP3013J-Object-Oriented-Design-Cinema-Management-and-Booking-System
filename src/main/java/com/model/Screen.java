package com.model;

import java.io.Serializable;

public class Screen implements Serializable {
    private Integer id;

    private Integer numOfSeates;

    private String location;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumOfSeates() {
        return numOfSeates;
    }

    public void setNumOfSeates(Integer numOfSeates) {
        this.numOfSeates = numOfSeates;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
    * toString
    * @return String String
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", numOfSeates=").append(numOfSeates);
        sb.append(", location=").append(location);
        sb.append("]");
        return sb.toString();
    }

    /**
    * equals
    * @param that that
    * @return boolean boolean
    */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Screen other = (Screen) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNumOfSeates() == null ? other.getNumOfSeates() == null : this.getNumOfSeates().equals(other.getNumOfSeates()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()));
    }

    /**
    * hashCode
    * @return int int
    */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNumOfSeates() == null) ? 0 : getNumOfSeates().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        return result;
    }
}