package com.neuedu.crm.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * service
 * @author 
 */
public class Service implements Serializable {
    private Integer id;

    private Integer clientId;

    private Integer type;

    private String content;

    private Integer linkman;

    private String contactWay;

    private String request;

    private Integer creator;

    private Date createTime;

    private Integer assigner;

    private Date assignTime;

    private String handle;

    private Integer handler;

    private Date handleTime;

    private Integer satisfaction;

    private String result;

    private Integer status;

    private String comment;
    
    
    //关联到客户
    private Client client;
    
    //关联到服务类型
    ServiceType serviceType;
    
    //关联到用户表
    User creatorUser;

    //关联到用户表
    User assignerUser;
    
    //关联到用户表
    User handlerUser;

    private static final long serialVersionUID = 1L;
    
    

    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public User getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(User creatorUser) {
		this.creatorUser = creatorUser;
	}

	public User getAssignerUser() {
		return assignerUser;
	}

	public void setAssignerUser(User assignerUser) {
		this.assignerUser = assignerUser;
	}

	public User getHandlerUser() {
		return handlerUser;
	}

	public void setHandlerUser(User handlerUser) {
		this.handlerUser = handlerUser;
	}

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLinkman() {
        return linkman;
    }

    public void setLinkman(Integer linkman) {
        this.linkman = linkman;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
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

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        Service other = (Service) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getLinkman() == null ? other.getLinkman() == null : this.getLinkman().equals(other.getLinkman()))
            && (this.getContactWay() == null ? other.getContactWay() == null : this.getContactWay().equals(other.getContactWay()))
            && (this.getRequest() == null ? other.getRequest() == null : this.getRequest().equals(other.getRequest()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAssigner() == null ? other.getAssigner() == null : this.getAssigner().equals(other.getAssigner()))
            && (this.getAssignTime() == null ? other.getAssignTime() == null : this.getAssignTime().equals(other.getAssignTime()))
            && (this.getHandle() == null ? other.getHandle() == null : this.getHandle().equals(other.getHandle()))
            && (this.getHandler() == null ? other.getHandler() == null : this.getHandler().equals(other.getHandler()))
            && (this.getHandleTime() == null ? other.getHandleTime() == null : this.getHandleTime().equals(other.getHandleTime()))
            && (this.getSatisfaction() == null ? other.getSatisfaction() == null : this.getSatisfaction().equals(other.getSatisfaction()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getLinkman() == null) ? 0 : getLinkman().hashCode());
        result = prime * result + ((getContactWay() == null) ? 0 : getContactWay().hashCode());
        result = prime * result + ((getRequest() == null) ? 0 : getRequest().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAssigner() == null) ? 0 : getAssigner().hashCode());
        result = prime * result + ((getAssignTime() == null) ? 0 : getAssignTime().hashCode());
        result = prime * result + ((getHandle() == null) ? 0 : getHandle().hashCode());
        result = prime * result + ((getHandler() == null) ? 0 : getHandler().hashCode());
        result = prime * result + ((getHandleTime() == null) ? 0 : getHandleTime().hashCode());
        result = prime * result + ((getSatisfaction() == null) ? 0 : getSatisfaction().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", linkman=").append(linkman);
        sb.append(", contactWay=").append(contactWay);
        sb.append(", request=").append(request);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", assigner=").append(assigner);
        sb.append(", assignTime=").append(assignTime);
        sb.append(", handle=").append(handle);
        sb.append(", handler=").append(handler);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", satisfaction=").append(satisfaction);
        sb.append(", result=").append(result);
        sb.append(", status=").append(status);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}