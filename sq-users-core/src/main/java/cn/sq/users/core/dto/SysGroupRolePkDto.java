package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户组与角色关联数据传值
 */
@ApiModel(value = "用户组与角色关联数据传值")
public class SysGroupRolePkDto implements Serializable {

    @ApiModelProperty(value = "用户组ID",required = true)
    private Integer groupId;

    @ApiModelProperty(value = "角色ID字符串集合",example = "1,2,3",required = true)
    private String roleIds;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }
}