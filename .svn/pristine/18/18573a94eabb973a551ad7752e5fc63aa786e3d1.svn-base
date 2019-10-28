package com.neuedu.crm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ServiceExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(Integer value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(Integer value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(Integer value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(Integer value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(Integer value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(Integer value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<Integer> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<Integer> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(Integer value1, Integer value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(Integer value1, Integer value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andContactWayIsNull() {
            addCriterion("contact_way is null");
            return (Criteria) this;
        }

        public Criteria andContactWayIsNotNull() {
            addCriterion("contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andContactWayEqualTo(String value) {
            addCriterion("contact_way =", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotEqualTo(String value) {
            addCriterion("contact_way <>", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayGreaterThan(String value) {
            addCriterion("contact_way >", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("contact_way >=", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLessThan(String value) {
            addCriterion("contact_way <", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLessThanOrEqualTo(String value) {
            addCriterion("contact_way <=", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayLike(String value) {
            addCriterion("contact_way like", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotLike(String value) {
            addCriterion("contact_way not like", value, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayIn(List<String> values) {
            addCriterion("contact_way in", values, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotIn(List<String> values) {
            addCriterion("contact_way not in", values, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayBetween(String value1, String value2) {
            addCriterion("contact_way between", value1, value2, "contactWay");
            return (Criteria) this;
        }

        public Criteria andContactWayNotBetween(String value1, String value2) {
            addCriterion("contact_way not between", value1, value2, "contactWay");
            return (Criteria) this;
        }

        public Criteria andRequestIsNull() {
            addCriterion("request is null");
            return (Criteria) this;
        }

        public Criteria andRequestIsNotNull() {
            addCriterion("request is not null");
            return (Criteria) this;
        }

        public Criteria andRequestEqualTo(String value) {
            addCriterion("request =", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotEqualTo(String value) {
            addCriterion("request <>", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestGreaterThan(String value) {
            addCriterion("request >", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestGreaterThanOrEqualTo(String value) {
            addCriterion("request >=", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLessThan(String value) {
            addCriterion("request <", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLessThanOrEqualTo(String value) {
            addCriterion("request <=", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLike(String value) {
            addCriterion("request like", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotLike(String value) {
            addCriterion("request not like", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestIn(List<String> values) {
            addCriterion("request in", values, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotIn(List<String> values) {
            addCriterion("request not in", values, "request");
            return (Criteria) this;
        }

        public Criteria andRequestBetween(String value1, String value2) {
            addCriterion("request between", value1, value2, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotBetween(String value1, String value2) {
            addCriterion("request not between", value1, value2, "request");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Integer value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Integer value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Integer value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Integer value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Integer value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Integer> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Integer> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Integer value1, Integer value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Integer value1, Integer value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andHandleIsNull() {
            addCriterion("handle is null");
            return (Criteria) this;
        }

        public Criteria andHandleIsNotNull() {
            addCriterion("handle is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEqualTo(String value) {
            addCriterion("handle =", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotEqualTo(String value) {
            addCriterion("handle <>", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThan(String value) {
            addCriterion("handle >", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleGreaterThanOrEqualTo(String value) {
            addCriterion("handle >=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThan(String value) {
            addCriterion("handle <", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLessThanOrEqualTo(String value) {
            addCriterion("handle <=", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleLike(String value) {
            addCriterion("handle like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotLike(String value) {
            addCriterion("handle not like", value, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleIn(List<String> values) {
            addCriterion("handle in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotIn(List<String> values) {
            addCriterion("handle not in", values, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleBetween(String value1, String value2) {
            addCriterion("handle between", value1, value2, "handle");
            return (Criteria) this;
        }

        public Criteria andHandleNotBetween(String value1, String value2) {
            addCriterion("handle not between", value1, value2, "handle");
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

        public Criteria andSatisfactionIsNull() {
            addCriterion("satisfaction is null");
            return (Criteria) this;
        }

        public Criteria andSatisfactionIsNotNull() {
            addCriterion("satisfaction is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfactionEqualTo(Integer value) {
            addCriterion("satisfaction =", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionNotEqualTo(Integer value) {
            addCriterion("satisfaction <>", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionGreaterThan(Integer value) {
            addCriterion("satisfaction >", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionGreaterThanOrEqualTo(Integer value) {
            addCriterion("satisfaction >=", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionLessThan(Integer value) {
            addCriterion("satisfaction <", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionLessThanOrEqualTo(Integer value) {
            addCriterion("satisfaction <=", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionIn(List<Integer> values) {
            addCriterion("satisfaction in", values, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionNotIn(List<Integer> values) {
            addCriterion("satisfaction not in", values, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionBetween(Integer value1, Integer value2) {
            addCriterion("satisfaction between", value1, value2, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionNotBetween(Integer value1, Integer value2) {
            addCriterion("satisfaction not between", value1, value2, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("`result` is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("`result` is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("`result` =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("`result` <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("`result` >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("`result` >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("`result` <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("`result` <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("`result` like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("`result` not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("`result` in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("`result` not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("`result` between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("`result` not between", value1, value2, "result");
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

        public Criteria andCommentIsNull() {
            addCriterion("`comment` is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("`comment` is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("`comment` =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("`comment` <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("`comment` >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("`comment` >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("`comment` <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("`comment` <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("`comment` like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("`comment` not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("`comment` in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("`comment` not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("`comment` between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("`comment` not between", value1, value2, "comment");
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