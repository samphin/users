package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class SysUserGroupPkDto implements Serializable {

    @ApiModelProperty(value = "用户组ID",required = true)
    private Integer groupId;

    @ApiModelProperty(value = "用户ID字符串集合",example = "1,2,3",required = true)
    private String userIds;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }

}