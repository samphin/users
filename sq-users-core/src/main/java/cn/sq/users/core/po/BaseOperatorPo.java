package cn.sq.users.core.po;


import cn.sq.users.core.util.Data2LongSerizlizer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * 1、提供版本控制
 * 2、为主业务表添加创建人ID、创建时间、最后修改人ID、最后修改时间字段
 *
 * @param <ID>
 */
public class BaseOperatorPo<ID extends Serializable> implements Serializable {

    @Id
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    /**
     * 控制提交版本，防止重复提交
     */
    @Version
    private Integer version;

    /***************操作记录信息*****************/
    private Integer createUserId;

    @JsonSerialize(using = Data2LongSerizlizer.class)
    private Date createTime;

    private Integer lastUpdateUserId;

    @JsonSerialize(using = Data2LongSerizlizer.class)
    private Date lastUpdateTime;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
