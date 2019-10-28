package com.neuedu.crm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BusinessPlanExample() {
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

        public Criteria andRecordDateIsNull() {
            addCriterion("record_date is null");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNotNull() {
            addCriterion("record_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDateEqualTo(Date value) {
            addCriterion("record_date =", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotEqualTo(Date value) {
            addCriterion("record_date <>", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThan(Date value) {
            addCriterion("record_date >", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanOrEqualTo(Date value) {
            addCriterion("record_date >=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThan(Date value) {
            addCriterion("record_date <", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanOrEqualTo(Date value) {
            addCriterion("record_date <=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateIn(List<Date> values) {
            addCriterion("record_date in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotIn(List<Date> values) {
            addCriterion("record_date not in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateBetween(Date value1, Date value2) {
            addCriterion("record_date between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotBetween(Date value1, Date value2) {
            addCriterion("record_date not between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andPlanIsNull() {
            addCriterion("`plan` is null");
            return (Criteria) this;
        }

        public Criteria andPlanIsNotNull() {
            addCriterion("`plan` is not null");
            return (Criteria) this;
        }

        public Criteria andPlanEqualTo(String value) {
            addCriterion("`plan` =", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotEqualTo(String value) {
            addCriterion("`plan` <>", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanGreaterThan(String value) {
            addCriterion("`plan` >", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanGreaterThanOrEqualTo(String value) {
            addCriterion("`plan` >=", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanLessThan(String value) {
            addCriterion("`plan` <", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanLessThanOrEqualTo(String value) {
            addCriterion("`plan` <=", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanLike(String value) {
            addCriterion("`plan` like", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotLike(String value) {
            addCriterion("`plan` not like", value, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanIn(List<String> values) {
            addCriterion("`plan` in", values, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotIn(List<String> values) {
            addCriterion("`plan` not in", values, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanBetween(String value1, String value2) {
            addCriterion("`plan` between", value1, value2, "plan");
            return (Criteria) this;
        }

        public Criteria andPlanNotBetween(String value1, String value2) {
            addCriterion("`plan` not between", value1, value2, "plan");
            return (Criteria) this;
        }

        public Criteria andEffectIsNull() {
            addCriterion("effect is null");
            return (Criteria) this;
        }

        public Criteria andEffectIsNotNull() {
            addCriterion("effect is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEqualTo(String value) {
            addCriterion("effect =", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotEqualTo(String value) {
            addCriterion("effect <>", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectGreaterThan(String value) {
            addCriterion("effect >", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectGreaterThanOrEqualTo(String value) {
            addCriterion("effect >=", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLessThan(String value) {
            addCriterion("effect <", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLessThanOrEqualTo(String value) {
            addCriterion("effect <=", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLike(String value) {
            addCriterion("effect like", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotLike(String value) {
            addCriterion("effect not like", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectIn(List<String> values) {
            addCriterion("effect in", values, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotIn(List<String> values) {
            addCriterion("effect not in", values, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectBetween(String value1, String value2) {
            addCriterion("effect between", value1, value2, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotBetween(String value1, String value2) {
            addCriterion("effect not between", value1, value2, "effect");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdIsNull() {
            addCriterion("business_chance_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdIsNotNull() {
            addCriterion("business_chance_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdEqualTo(Integer value) {
            addCriterion("business_chance_id =", value, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdNotEqualTo(Integer value) {
            addCriterion("business_chance_id <>", value, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdGreaterThan(Integer value) {
            addCriterion("business_chance_id >", value, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_chance_id >=", value, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdLessThan(Integer value) {
            addCriterion("business_chance_id <", value, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_chance_id <=", value, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdIn(List<Integer> values) {
            addCriterion("business_chance_id in", values, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdNotIn(List<Integer> values) {
            addCriterion("business_chance_id not in", values, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdBetween(Integer value1, Integer value2) {
            addCriterion("business_chance_id between", value1, value2, "businessChanceId");
            return (Criteria) this;
        }

        public Criteria andBusinessChanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_chance_id not between", value1, value2, "businessChanceId");
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