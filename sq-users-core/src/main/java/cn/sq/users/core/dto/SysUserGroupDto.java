package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class SysUserGroupDto implements Serializable {

    @ApiModelProperty(value = "用户组名称",notes = "用户组名称",required = true)
    private String name;

    @ApiModelProperty(value = "用户组描述",notes = "用户组描述")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}