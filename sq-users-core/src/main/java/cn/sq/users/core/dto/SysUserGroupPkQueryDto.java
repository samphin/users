package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysUserGroupPkQueryDto extends PageParam {

    @ApiModelProperty(value = "用户组ID", notes = "用户组ID", required = true)
    private Integer groupId;

    @ApiModelProperty(value = "用户真实姓名", notes = "用户真实姓名")
    private String realName;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }
}