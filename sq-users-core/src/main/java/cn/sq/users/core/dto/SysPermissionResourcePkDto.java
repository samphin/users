package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 权限资源关联数据传值
 */
@ApiModel
public class SysPermissionResourcePkDto {

    @ApiModelProperty(value = "权限ID")
    private Integer permissionId;

    @ApiModelProperty(value = "资源类型",allowableValues = "Menu,Button")
    private String resourceType;

    @ApiModelProperty(value = "资源ID字符串集",example = "1,2,3")
    private String resourceIds;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }
}
