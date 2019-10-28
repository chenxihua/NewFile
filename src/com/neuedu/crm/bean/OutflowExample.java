package com.neuedu.crm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutflowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public OutflowExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Integer value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Integer value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Integer value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Integer value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Integer value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Integer> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Integer> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Integer value1, Integer value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andAssignerIsNull() {
            addCriterion("assigner is null");
            return (Criteria) this;
        }

        public Criteria andAssignerIsNotNull() {
            addCriterion("assigner is not null");
            return (Criteria) this;
        }

        public Criteria andAssignerEqualTo(Integer value) {
            addCriterion("assigner =", value, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerNotEqualTo(Integer value) {
            addCriterion("assigner <>", value, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerGreaterThan(Integer value) {
            addCriterion("assigner >", value, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerGreaterThanOrEqualTo(Integer value) {
            addCriterion("assigner >=", value, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerLessThan(Integer value) {
            addCriterion("assigner <", value, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerLessThanOrEqualTo(Integer value) {
            addCriterion("assigner <=", value, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerIn(List<Integer> values) {
            addCriterion("assigner in", values, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerNotIn(List<Integer> values) {
            addCriterion("assigner not in", values, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerBetween(Integer value1, Integer value2) {
            addCriterion("assigner between", value1, value2, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignerNotBetween(Integer value1, Integer value2) {
            addCriterion("assigner not between", value1, value2, "assigner");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIsNull() {
            addCriterion("assign_time is null");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIsNotNull() {
            addCriterion("assign_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssignTimeEqualTo(Date value) {
            addCriterion("assign_time =", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotEqualTo(Date value) {
            addCriterion("assign_time <>", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeGreaterThan(Date value) {
            addCriterion("assign_time >", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("assign_time >=", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeLessThan(Date value) {
            addCriterion("assign_time <", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeLessThanOrEqualTo(Date value) {
            addCriterion("assign_time <=", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIn(List<Date> values) {
            addCriterion("assign_time in", values, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotIn(List<Date> values) {
            addCriterion("assign_time not in", values, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeBetween(Date value1, Date value2) {
            addCriterion("assign_time between", value1, value2, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotBetween(Date value1, Date value2) {
            addCriterion("assign_time not between", value1, value2, "assignTime");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNull() {
            addCriterion("`handler` is null");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNotNull() {
            addCriterion("`handler` is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerEqualTo(Integer value) {
            addCriterion("`handler` =", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotEqualTo(Integer value) {
            addCriterion("`handler` <>", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThan(Integer value) {
            addCriterion("`handler` >", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThanOrEqualTo(Integer value) {
            addCriterion("`handler` >=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThan(Integer value) {
            addCriterion("`handler` <", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThanOrEqualTo(Integer value) {
            addCriterion("`handler` <=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerIn(List<Integer> values) {
            addCriterion("`handler` in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotIn(List<Integer> values) {
            addCriterion("`handler` not in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerBetween(Integer value1, Integer value2) {
            addCriterion("`handler` between", value1, value2, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotBetween(Integer value1, Integer value2) {
            addCriterion("`handler` not between", value1, value2, "handler");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("handle_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("handle_time =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("handle_time <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("handle_time >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handle_time >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("handle_time <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("handle_time <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("handle_time in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("handle_time not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("handle_time between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("handle_time not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeIsNull() {
            addCriterion("last_order_time is null");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeIsNotNull() {
            addCriterion("last_order_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeEqualTo(Date value) {
            addCriterion("last_order_time =", value, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeNotEqualTo(Date value) {
            addCriterion("last_order_time <>", value, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeGreaterThan(Date value) {
            addCriterion("last_order_time >", value, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_order_time >=", value, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeLessThan(Date value) {
            addCriterion("last_order_time <", value, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_order_time <=", value, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeIn(List<Date> values) {
            addCriterion("last_order_time in", values, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeNotIn(List<Date> values) {
            addCriterion("last_order_time not in", values, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeBetween(Date value1, Date value2) {
            addCriterion("last_order_time between", value1, value2, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andLastOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_order_time not between", value1, value2, "lastOrderTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeIsNull() {
            addCriterion("outflow_time is null");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeIsNotNull() {
            addCriterion("outflow_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeEqualTo(Date value) {
            addCriterion("outflow_time =", value, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeNotEqualTo(Date value) {
            addCriterion("outflow_time <>", value, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeGreaterThan(Date value) {
            addCriterion("outflow_time >", value, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("outflow_time >=", value, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeLessThan(Date value) {
            addCriterion("outflow_time <", value, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeLessThanOrEqualTo(Date value) {
            addCriterion("outflow_time <=", value, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeIn(List<Date> values) {
            addCriterion("outflow_time in", values, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeNotIn(List<Date> values) {
            addCriterion("outflow_time not in", values, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeBetween(Date value1, Date value2) {
            addCriterion("outflow_time between", value1, value2, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andOutflowTimeNotBetween(Date value1, Date value2) {
            addCriterion("outflow_time not between", value1, value2, "outflowTime");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureIsNull() {
            addCriterion("defer_measure is null");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureIsNotNull() {
            addCriterion("defer_measure is not null");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureEqualTo(String value) {
            addCriterion("defer_measure =", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureNotEqualTo(String value) {
            addCriterion("defer_measure <>", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureGreaterThan(String value) {
            addCriterion("defer_measure >", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureGreaterThanOrEqualTo(String value) {
            addCriterion("defer_measure >=", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureLessThan(String value) {
            addCriterion("defer_measure <", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureLessThanOrEqualTo(String value) {
            addCriterion("defer_measure <=", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureLike(String value) {
            addCriterion("defer_measure like", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureNotLike(String value) {
            addCriterion("defer_measure not like", value, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureIn(List<String> values) {
            addCriterion("defer_measure in", values, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureNotIn(List<String> values) {
            addCriterion("defer_measure not in", values, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureBetween(String value1, String value2) {
            addCriterion("defer_measure between", value1, value2, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andDeferMeasureNotBetween(String value1, String value2) {
            addCriterion("defer_measure not between", value1, value2, "deferMeasure");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     */
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