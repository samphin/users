package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户组查询对象")
public class SysUserGroupQueryDto extends PageParam {

    @ApiModelProperty(value = "用户组名称", notes = "用户组名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}