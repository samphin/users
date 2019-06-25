package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysButtonUpdateDto extends SysButtonDto {

    @ApiModelProperty(value = "按钮ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "数据版本号", required = true)
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