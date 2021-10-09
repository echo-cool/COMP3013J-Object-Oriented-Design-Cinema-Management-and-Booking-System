package com.model;

public class Ticket {
    private Integer id;

    private Integer orderID;

    private Integer customerID;

    private Integer arrangementID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getArrangementID() {
        return arrangementID;
    }

    public void setArrangementID(Integer arrangementID) {
        this.arrangementID = arrangementID;
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
        sb.append(", orderID=").append(orderID);
        sb.append(", customerID=").append(customerID);
        sb.append(", arrangementID=").append(arrangementID);
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
        Ticket other = (Ticket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderID() == null ? other.getOrderID() == null : this.getOrderID().equals(other.getOrderID()))
            && (this.getCustomerID() == null ? other.getCustomerID() == null : this.getCustomerID().equals(other.getCustomerID()))
            && (this.getArrangementID() == null ? other.getArrangementID() == null : this.getArrangementID().equals(other.getArrangementID()));
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
        result = prime * result + ((getOrderID() == null) ? 0 : getOrderID().hashCode());
        result = prime * result + ((getCustomerID() == null) ? 0 : getCustomerID().hashCode());
        result = prime * result + ((getArrangementID() == null) ? 0 : getArrangementID().hashCode());
        return result;
    }
}