package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModelProperty;

public class SysButtonDto {

    @ApiModelProperty(value = "按钮名称", notes = "按钮名称", required = true)
    private String name;

    private String icon;

    @ApiModelProperty(value = "按钮所属菜单ID", notes = "按钮所属菜单ID", required = true)
    private Integer menuId;

    @ApiModelProperty(value = "按钮状态", notes = "按钮状态", allowableValues = "true,false")
    private boolean enabled = true; //默认为启用状态

    @ApiModelProperty(value = "请求类型", notes = "请求类型", allowableValues = "GET,POST")
    private String requestType = "GET";//默认为GET类型菜单 GET或POST

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

}