package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SysButtonQueryDto extends PageParam {

    @ApiModelProperty(value = "按钮名称", notes = "按钮名称")
    private String name;

    @ApiModelProperty(value = "按钮状态", notes = "按钮状态", allowableValues = "true,false")
    private Boolean enabled;

    @ApiModelProperty(value = "请求类型", notes = "请求类型", allowableValues = "GET,POST")
    private String requestType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }
}