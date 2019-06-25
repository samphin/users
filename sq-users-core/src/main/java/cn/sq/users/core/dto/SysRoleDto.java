package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class SysRoleDto implements Serializable {

    @ApiModelProperty(value = "角色名称",notes = "角色名称")
    private String name;

    @ApiModelProperty(value = "菜单状态", allowableValues = "true,false")
    private boolean state = true;//默认激活状态 true或false

    @ApiModelProperty(value = "角色描述",notes = "角色描述")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}