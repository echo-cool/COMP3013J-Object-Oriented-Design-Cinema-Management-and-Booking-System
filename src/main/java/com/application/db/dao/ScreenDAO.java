package com.application.db.dao;

public class ScreenDAO {
    //This is a database access object for the Movie table
    //This object is a direct mapping for the row in the database and only used in mappers for query.
    //The reason we have this class is that DAO is required for the using of mybatis.
    //The real model and persistent models are in the model package
    private Integer id;

    private String name;

    private Integer capacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * toString
     *
     * @return String String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", capacity=").append(capacity);
        sb.append("]");
        return sb.toString();
    }

    /**
     * equals
     *
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
        ScreenDAO other = (ScreenDAO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getCapacity() == null ? other.getCapacity() == null : this.getCapacity().equals(other.getCapacity()));
    }

    /**
     * hashCode
     *
     * @return int int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCapacity() == null) ? 0 : getCapacity().hashCode());
        return result;
    }
}