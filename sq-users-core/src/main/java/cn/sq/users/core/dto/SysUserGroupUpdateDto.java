package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户组更新对象")
public class SysUserGroupUpdateDto extends SysUserGroupDto {

    @ApiModelProperty(value = "用户组ID",notes = "用户组ID",required = true)
    private Integer id;

    @ApiModelProperty(value = "用户组数据更新版本号",notes = "用户组数据更新版本号", required = true)
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