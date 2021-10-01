package com.model;

import java.util.ArrayList;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIDIsNull() {
            addCriterion("OrderID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIDIsNotNull() {
            addCriterion("OrderID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIDEqualTo(Integer value) {
            addCriterion("OrderID =", value, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDNotEqualTo(Integer value) {
            addCriterion("OrderID <>", value, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDGreaterThan(Integer value) {
            addCriterion("OrderID >", value, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderID >=", value, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDLessThan(Integer value) {
            addCriterion("OrderID <", value, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDLessThanOrEqualTo(Integer value) {
            addCriterion("OrderID <=", value, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDIn(List<Integer> values) {
            addCriterion("OrderID in", values, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDNotIn(List<Integer> values) {
            addCriterion("OrderID not in", values, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDBetween(Integer value1, Integer value2) {
            addCriterion("OrderID between", value1, value2, "orderID");
            return (Criteria) this;
        }

        public Criteria andOrderIDNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderID not between", value1, value2, "orderID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDIsNull() {
            addCriterion("CustomerID is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIDIsNotNull() {
            addCriterion("CustomerID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIDEqualTo(Integer value) {
            addCriterion("CustomerID =", value, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDNotEqualTo(Integer value) {
            addCriterion("CustomerID <>", value, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDGreaterThan(Integer value) {
            addCriterion("CustomerID >", value, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("CustomerID >=", value, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDLessThan(Integer value) {
            addCriterion("CustomerID <", value, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDLessThanOrEqualTo(Integer value) {
            addCriterion("CustomerID <=", value, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDIn(List<Integer> values) {
            addCriterion("CustomerID in", values, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDNotIn(List<Integer> values) {
            addCriterion("CustomerID not in", values, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDBetween(Integer value1, Integer value2) {
            addCriterion("CustomerID between", value1, value2, "customerID");
            return (Criteria) this;
        }

        public Criteria andCustomerIDNotBetween(Integer value1, Integer value2) {
            addCriterion("CustomerID not between", value1, value2, "customerID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDIsNull() {
            addCriterion("ArrangementID is null");
            return (Criteria) this;
        }

        public Criteria andArrangementIDIsNotNull() {
            addCriterion("ArrangementID is not null");
            return (Criteria) this;
        }

        public Criteria andArrangementIDEqualTo(Integer value) {
            addCriterion("ArrangementID =", value, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDNotEqualTo(Integer value) {
            addCriterion("ArrangementID <>", value, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDGreaterThan(Integer value) {
            addCriterion("ArrangementID >", value, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ArrangementID >=", value, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDLessThan(Integer value) {
            addCriterion("ArrangementID <", value, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDLessThanOrEqualTo(Integer value) {
            addCriterion("ArrangementID <=", value, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDIn(List<Integer> values) {
            addCriterion("ArrangementID in", values, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDNotIn(List<Integer> values) {
            addCriterion("ArrangementID not in", values, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDBetween(Integer value1, Integer value2) {
            addCriterion("ArrangementID between", value1, value2, "arrangementID");
            return (Criteria) this;
        }

        public Criteria andArrangementIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ArrangementID not between", value1, value2, "arrangementID");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}