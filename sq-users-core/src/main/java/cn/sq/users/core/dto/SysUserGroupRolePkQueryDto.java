package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户组角色查询对象")
public class SysUserGroupRolePkQueryDto {

    @ApiModelProperty(value = "用户组ID", notes = "用户组ID", required = true)
    private Integer groupId;

    @ApiModelProperty(value = "角色名称", notes = "角色名称")
    private String name;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}