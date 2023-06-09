package com.application.db.dao;

public class MovieDAO {
    //This is a database access object for the Movie table
    //This object is a direct mapping for the row in the database and only used in mappers for query.
    //The reason we have this class is that DAO is required for the using of mybatis.
    //The real model and persistent models are in the model package
    private Integer id;

    private String name;

    private Integer duration;

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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
        sb.append(", duration=").append(duration);
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
        MovieDAO other = (MovieDAO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()));
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
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        return result;
    }
}