package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysButtonDto;
import cn.sq.users.core.dto.SysButtonQueryDto;
import cn.sq.users.core.dto.SysButtonUpdateDto;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class SysButton extends BaseOperatorPo<Integer> {

    private String name;

    private String icon;

    private Integer menuId;

    private String requestType;

    private Boolean enabled;

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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    //保存：转换Dto-->Po
    public SysButton buildSysButton(SysButtonDto dto) {
        BeanUtils.copyProperties(dto, this);
        this.setCreateTime(new Date());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //修改：转换Dto-->Po
    public SysButton buildSysButton(SysButtonUpdateDto dto) {
        BeanUtils.copyProperties(dto, this);
        this.setId(dto.getId());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //查询：转换Dto-->Po
    public SysButton buildSysButton(SysButtonQueryDto queryDto) {
        BeanUtils.copyProperties(queryDto, this);
        return this;
    }

}