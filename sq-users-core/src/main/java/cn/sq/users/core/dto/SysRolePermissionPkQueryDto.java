package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "角色权限查询对象")
public class SysRolePermissionPkQueryDto {

    @ApiModelProperty(value = "角色ID", notes = "角色ID", required = true)
    private Integer roleId;

    @ApiModelProperty(value = "权限名称", notes = "权限名称")
    private String name;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
