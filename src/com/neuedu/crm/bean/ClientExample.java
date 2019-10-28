package com.neuedu.crm.bean;

import java.util.ArrayList;
import java.util.List;

public class ClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ClientExample() {
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

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdIsNull() {
            addCriterion("client_class_id is null");
            return (Criteria) this;
        }

        public Criteria andClientClassIdIsNotNull() {
            addCriterion("client_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientClassIdEqualTo(Integer value) {
            addCriterion("client_class_id =", value, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdNotEqualTo(Integer value) {
            addCriterion("client_class_id <>", value, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdGreaterThan(Integer value) {
            addCriterion("client_class_id >", value, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_class_id >=", value, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdLessThan(Integer value) {
            addCriterion("client_class_id <", value, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("client_class_id <=", value, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdIn(List<Integer> values) {
            addCriterion("client_class_id in", values, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdNotIn(List<Integer> values) {
            addCriterion("client_class_id not in", values, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdBetween(Integer value1, Integer value2) {
            addCriterion("client_class_id between", value1, value2, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andClientClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("client_class_id not between", value1, value2, "clientClassId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andClientManagerIsNull() {
            addCriterion("client_manager is null");
            return (Criteria) this;
        }

        public Criteria andClientManagerIsNotNull() {
            addCriterion("client_manager is not null");
            return (Criteria) this;
        }

        public Criteria andClientManagerEqualTo(Integer value) {
            addCriterion("client_manager =", value, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerNotEqualTo(Integer value) {
            addCriterion("client_manager <>", value, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerGreaterThan(Integer value) {
            addCriterion("client_manager >", value, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_manager >=", value, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerLessThan(Integer value) {
            addCriterion("client_manager <", value, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerLessThanOrEqualTo(Integer value) {
            addCriterion("client_manager <=", value, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerIn(List<Integer> values) {
            addCriterion("client_manager in", values, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerNotIn(List<Integer> values) {
            addCriterion("client_manager not in", values, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerBetween(Integer value1, Integer value2) {
            addCriterion("client_manager between", value1, value2, "clientManager");
            return (Criteria) this;
        }

        public Criteria andClientManagerNotBetween(Integer value1, Integer value2) {
            addCriterion("client_manager not between", value1, value2, "clientManager");
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

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Integer value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Integer value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Integer value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Integer value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Integer value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Integer> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Integer> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Integer value1, Integer value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postcode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postcode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postcode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postcode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postcode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postcode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postcode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postcode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postcode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postcode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postcode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postcode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postcode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phone_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phone_num =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phone_num <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phone_num >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phone_num >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phone_num <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phone_num <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phone_num like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phone_num not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phone_num in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phone_num not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phone_num between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phone_num not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andInternetAddrIsNull() {
            addCriterion("internet_addr is null");
            return (Criteria) this;
        }

        public Criteria andInternetAddrIsNotNull() {
            addCriterion("internet_addr is not null");
            return (Criteria) this;
        }

        public Criteria andInternetAddrEqualTo(String value) {
            addCriterion("internet_addr =", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrNotEqualTo(String value) {
            addCriterion("internet_addr <>", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrGreaterThan(String value) {
            addCriterion("internet_addr >", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrGreaterThanOrEqualTo(String value) {
            addCriterion("internet_addr >=", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrLessThan(String value) {
            addCriterion("internet_addr <", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrLessThanOrEqualTo(String value) {
            addCriterion("internet_addr <=", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrLike(String value) {
            addCriterion("internet_addr like", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrNotLike(String value) {
            addCriterion("internet_addr not like", value, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrIn(List<String> values) {
            addCriterion("internet_addr in", values, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrNotIn(List<String> values) {
            addCriterion("internet_addr not in", values, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrBetween(String value1, String value2) {
            addCriterion("internet_addr between", value1, value2, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andInternetAddrNotBetween(String value1, String value2) {
            addCriterion("internet_addr not between", value1, value2, "internetAddr");
            return (Criteria) this;
        }

        public Criteria andLicenceNumIsNull() {
            addCriterion("licence_num is null");
            return (Criteria) this;
        }

        public Criteria andLicenceNumIsNotNull() {
            addCriterion("licence_num is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceNumEqualTo(String value) {
            addCriterion("licence_num =", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumNotEqualTo(String value) {
            addCriterion("licence_num <>", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumGreaterThan(String value) {
            addCriterion("licence_num >", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumGreaterThanOrEqualTo(String value) {
            addCriterion("licence_num >=", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumLessThan(String value) {
            addCriterion("licence_num <", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumLessThanOrEqualTo(String value) {
            addCriterion("licence_num <=", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumLike(String value) {
            addCriterion("licence_num like", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumNotLike(String value) {
            addCriterion("licence_num not like", value, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumIn(List<String> values) {
            addCriterion("licence_num in", values, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumNotIn(List<String> values) {
            addCriterion("licence_num not in", values, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumBetween(String value1, String value2) {
            addCriterion("licence_num between", value1, value2, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andLicenceNumNotBetween(String value1, String value2) {
            addCriterion("licence_num not between", value1, value2, "licenceNum");
            return (Criteria) this;
        }

        public Criteria andCorporationIsNull() {
            addCriterion("corporation is null");
            return (Criteria) this;
        }

        public Criteria andCorporationIsNotNull() {
            addCriterion("corporation is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationEqualTo(String value) {
            addCriterion("corporation =", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotEqualTo(String value) {
            addCriterion("corporation <>", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationGreaterThan(String value) {
            addCriterion("corporation >", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationGreaterThanOrEqualTo(String value) {
            addCriterion("corporation >=", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationLessThan(String value) {
            addCriterion("corporation <", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationLessThanOrEqualTo(String value) {
            addCriterion("corporation <=", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationLike(String value) {
            addCriterion("corporation like", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotLike(String value) {
            addCriterion("corporation not like", value, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationIn(List<String> values) {
            addCriterion("corporation in", values, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotIn(List<String> values) {
            addCriterion("corporation not in", values, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationBetween(String value1, String value2) {
            addCriterion("corporation between", value1, value2, "corporation");
            return (Criteria) this;
        }

        public Criteria andCorporationNotBetween(String value1, String value2) {
            addCriterion("corporation not between", value1, value2, "corporation");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIsNull() {
            addCriterion("reg_capital is null");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIsNotNull() {
            addCriterion("reg_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRegCapitalEqualTo(Long value) {
            addCriterion("reg_capital =", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotEqualTo(Long value) {
            addCriterion("reg_capital <>", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThan(Long value) {
            addCriterion("reg_capital >", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalGreaterThanOrEqualTo(Long value) {
            addCriterion("reg_capital >=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThan(Long value) {
            addCriterion("reg_capital <", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalLessThanOrEqualTo(Long value) {
            addCriterion("reg_capital <=", value, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalIn(List<Long> values) {
            addCriterion("reg_capital in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotIn(List<Long> values) {
            addCriterion("reg_capital not in", values, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalBetween(Long value1, Long value2) {
            addCriterion("reg_capital between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andRegCapitalNotBetween(Long value1, Long value2) {
            addCriterion("reg_capital not between", value1, value2, "regCapital");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverIsNull() {
            addCriterion("annual_turnover is null");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverIsNotNull() {
            addCriterion("annual_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverEqualTo(Long value) {
            addCriterion("annual_turnover =", value, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverNotEqualTo(Long value) {
            addCriterion("annual_turnover <>", value, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverGreaterThan(Long value) {
            addCriterion("annual_turnover >", value, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverGreaterThanOrEqualTo(Long value) {
            addCriterion("annual_turnover >=", value, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverLessThan(Long value) {
            addCriterion("annual_turnover <", value, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverLessThanOrEqualTo(Long value) {
            addCriterion("annual_turnover <=", value, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverIn(List<Long> values) {
            addCriterion("annual_turnover in", values, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverNotIn(List<Long> values) {
            addCriterion("annual_turnover not in", values, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverBetween(Long value1, Long value2) {
            addCriterion("annual_turnover between", value1, value2, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andAnnualTurnoverNotBetween(Long value1, Long value2) {
            addCriterion("annual_turnover not between", value1, value2, "annualTurnover");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNull() {
            addCriterion("deposit_bank is null");
            return (Criteria) this;
        }

        public Criteria andDepositBankIsNotNull() {
            addCriterion("deposit_bank is not null");
            return (Criteria) this;
        }

        public Criteria andDepositBankEqualTo(String value) {
            addCriterion("deposit_bank =", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotEqualTo(String value) {
            addCriterion("deposit_bank <>", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThan(String value) {
            addCriterion("deposit_bank >", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankGreaterThanOrEqualTo(String value) {
            addCriterion("deposit_bank >=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThan(String value) {
            addCriterion("deposit_bank <", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLessThanOrEqualTo(String value) {
            addCriterion("deposit_bank <=", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankLike(String value) {
            addCriterion("deposit_bank like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotLike(String value) {
            addCriterion("deposit_bank not like", value, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankIn(List<String> values) {
            addCriterion("deposit_bank in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotIn(List<String> values) {
            addCriterion("deposit_bank not in", values, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankBetween(String value1, String value2) {
            addCriterion("deposit_bank between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andDepositBankNotBetween(String value1, String value2) {
            addCriterion("deposit_bank not between", value1, value2, "depositBank");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumIsNull() {
            addCriterion("land_tax_num is null");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumIsNotNull() {
            addCriterion("land_tax_num is not null");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumEqualTo(String value) {
            addCriterion("land_tax_num =", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumNotEqualTo(String value) {
            addCriterion("land_tax_num <>", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumGreaterThan(String value) {
            addCriterion("land_tax_num >", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumGreaterThanOrEqualTo(String value) {
            addCriterion("land_tax_num >=", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumLessThan(String value) {
            addCriterion("land_tax_num <", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumLessThanOrEqualTo(String value) {
            addCriterion("land_tax_num <=", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumLike(String value) {
            addCriterion("land_tax_num like", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumNotLike(String value) {
            addCriterion("land_tax_num not like", value, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumIn(List<String> values) {
            addCriterion("land_tax_num in", values, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumNotIn(List<String> values) {
            addCriterion("land_tax_num not in", values, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumBetween(String value1, String value2) {
            addCriterion("land_tax_num between", value1, value2, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andLandTaxNumNotBetween(String value1, String value2) {
            addCriterion("land_tax_num not between", value1, value2, "landTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumIsNull() {
            addCriterion("national_tax_num is null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumIsNotNull() {
            addCriterion("national_tax_num is not null");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumEqualTo(String value) {
            addCriterion("national_tax_num =", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumNotEqualTo(String value) {
            addCriterion("national_tax_num <>", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumGreaterThan(String value) {
            addCriterion("national_tax_num >", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumGreaterThanOrEqualTo(String value) {
            addCriterion("national_tax_num >=", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumLessThan(String value) {
            addCriterion("national_tax_num <", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumLessThanOrEqualTo(String value) {
            addCriterion("national_tax_num <=", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumLike(String value) {
            addCriterion("national_tax_num like", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumNotLike(String value) {
            addCriterion("national_tax_num not like", value, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumIn(List<String> values) {
            addCriterion("national_tax_num in", values, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumNotIn(List<String> values) {
            addCriterion("national_tax_num not in", values, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumBetween(String value1, String value2) {
            addCriterion("national_tax_num between", value1, value2, "nationalTaxNum");
            return (Criteria) this;
        }

        public Criteria andNationalTaxNumNotBetween(String value1, String value2) {
            addCriterion("national_tax_num not between", value1, value2, "nationalTaxNum");
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