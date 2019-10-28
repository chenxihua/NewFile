package com.neuedu.crm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * outflow
 * @author 
 */
public class Outflow implements Serializable {
    private Integer id;

    private Integer clientId;

    private Integer assigner;

    private Date assignTime;

    private Integer handler;

    private Date handleTime;

    private Date lastOrderTime;

    private Date outflowTime;

    private String deferMeasure;

    private String reason;

    private Integer status;
    
    private Client client;
    
    private User handlerUser;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getAssigner() {
        return assigner;
    }

    public void setAssigner(Integer assigner) {
        this.assigner = assigner;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Integer getHandler() {
        return handler;
    }

    public void setHandler(Integer handler) {
        this.handler = handler;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Date getLastOrderTime() {
        return lastOrderTime;
    }

    public void setLastOrderTime(Date lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    public Date getOutflowTime() {
        return outflowTime;
    }

    public void setOutflowTime(Date outflowTime) {
        this.outflowTime = outflowTime;
    }

    public String getDeferMeasure() {
        return deferMeasure;
    }

    public void setDeferMeasure(String deferMeasure) {
        this.deferMeasure = deferMeasure;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getHandlerUser() {
		return handlerUser;
	}

	public void setHandlerUser(User handlerUser) {
		this.handlerUser = handlerUser;
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
        Outflow other = (Outflow) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getAssigner() == null ? other.getAssigner() == null : this.getAssigner().equals(other.getAssigner()))
            && (this.getAssignTime() == null ? other.getAssignTime() == null : this.getAssignTime().equals(other.getAssignTime()))
            && (this.getHandler() == null ? other.getHandler() == null : this.getHandler().equals(other.getHandler()))
            && (this.getHandleTime() == null ? other.getHandleTime() == null : this.getHandleTime().equals(other.getHandleTime()))
            && (this.getLastOrderTime() == null ? other.getLastOrderTime() == null : this.getLastOrderTime().equals(other.getLastOrderTime()))
            && (this.getOutflowTime() == null ? other.getOutflowTime() == null : this.getOutflowTime().equals(other.getOutflowTime()))
            && (this.getDeferMeasure() == null ? other.getDeferMeasure() == null : this.getDeferMeasure().equals(other.getDeferMeasure()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getAssigner() == null) ? 0 : getAssigner().hashCode());
        result = prime * result + ((getAssignTime() == null) ? 0 : getAssignTime().hashCode());
        result = prime * result + ((getHandler() == null) ? 0 : getHandler().hashCode());
        result = prime * result + ((getHandleTime() == null) ? 0 : getHandleTime().hashCode());
        result = prime * result + ((getLastOrderTime() == null) ? 0 : getLastOrderTime().hashCode());
        result = prime * result + ((getOutflowTime() == null) ? 0 : getOutflowTime().hashCode());
        result = prime * result + ((getDeferMeasure() == null) ? 0 : getDeferMeasure().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
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
        sb.append(", clientId=").append(clientId);
        sb.append(", assigner=").append(assigner);
        sb.append(", assignTime=").append(assignTime);
        sb.append(", handler=").append(handler);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", lastOrderTime=").append(lastOrderTime);
        sb.append(", outflowTime=").append(outflowTime);
        sb.append(", deferMeasure=").append(deferMeasure);
        sb.append(", reason=").append(reason);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}