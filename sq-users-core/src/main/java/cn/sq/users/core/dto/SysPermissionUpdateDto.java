package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysPermissionUpdateDto extends SysPermissionDto {

    @ApiModelProperty(value = "权限ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "权限数据更新版本号", required = true)
    private int version = 1;//默认数据版本号为1

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}