package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysPermissionDto {

    @ApiModelProperty(value = "权限名称", required = true, dataType = "String")
    private String name;

    @ApiModelProperty(value = "权限状态", allowableValues = "true,false")
    private boolean state = true; //默认权限是启用状态

    @ApiModelProperty(value = "权限描述")
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