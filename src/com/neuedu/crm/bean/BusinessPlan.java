package com.neuedu.crm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * business_plan
 * @author 
 */
public class BusinessPlan implements Serializable {
    private Integer id;

    private Date recordDate;

    private String plan;

    private String effect;

    private Integer businessChanceId;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Integer getBusinessChanceId() {
        return businessChanceId;
    }

    public void setBusinessChanceId(Integer businessChanceId) {
        this.businessChanceId = businessChanceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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
        BusinessPlan other = (BusinessPlan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRecordDate() == null ? other.getRecordDate() == null : this.getRecordDate().equals(other.getRecordDate()))
            && (this.getPlan() == null ? other.getPlan() == null : this.getPlan().equals(other.getPlan()))
            && (this.getEffect() == null ? other.getEffect() == null : this.getEffect().equals(other.getEffect()))
            && (this.getBusinessChanceId() == null ? other.getBusinessChanceId() == null : this.getBusinessChanceId().equals(other.getBusinessChanceId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRecordDate() == null) ? 0 : getRecordDate().hashCode());
        result = prime * result + ((getPlan() == null) ? 0 : getPlan().hashCode());
        result = prime * result + ((getEffect() == null) ? 0 : getEffect().hashCode());
        result = prime * result + ((getBusinessChanceId() == null) ? 0 : getBusinessChanceId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", plan=").append(plan);
        sb.append(", effect=").append(effect);
        sb.append(", businessChanceId=").append(businessChanceId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}