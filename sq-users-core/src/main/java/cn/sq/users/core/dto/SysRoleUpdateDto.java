package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysRoleUpdateDto extends SysRoleDto {

    @ApiModelProperty(value = "角色ID", notes = "角色ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "角色数据更新版本号", notes = "角色数据更新版本号", required = true)
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