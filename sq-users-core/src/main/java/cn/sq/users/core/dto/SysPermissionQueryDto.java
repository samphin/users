package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysPermissionQueryDto extends PageParam {

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限状态",allowableValues = "true,false")
    private Boolean state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}