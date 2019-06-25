package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class SysRolePermissionPkDto implements Serializable {

    @ApiModelProperty(value = "角色ID",required = true)
    private Integer roleId;

    @ApiModelProperty(value = "权限ID字符串集合",example = "1,2,3",required = true)
    private String permissionIds;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }
}
