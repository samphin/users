package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户角色关联表数据传值")
public class SysUserRolePkDto implements Serializable {

    @ApiModelProperty(value = "用户ID",required = true)
    private Integer userId;

    @ApiModelProperty(value = "角色ID字符串集合",example = "1,2,3",required = true)
    private String roleIds;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }
}