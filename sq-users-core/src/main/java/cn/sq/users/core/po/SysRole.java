package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysRoleDto;
import cn.sq.users.core.dto.SysRoleQueryDto;
import cn.sq.users.core.dto.SysRoleUpdateDto;
import cn.sq.users.core.util.Data2LongSerizlizer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class SysRole extends BaseOperatorPo<Integer> {

    private String name;

    private Boolean state;

    private String description;

    public SysRole() {
    }

    public SysRole(String name, Boolean state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    //保存：转换Dto-->Po
    public SysRole buildSysRole(SysRoleDto saveDto) {
        BeanUtils.copyProperties(saveDto, this);
        this.setCreateTime(new Date());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //修改：转换Dto-->Po
    public SysRole buildSysRole(SysRoleUpdateDto updateDto) {
        BeanUtils.copyProperties(updateDto, this);
        this.setId(updateDto.getId());
        this.setLastUpdateTime(new Date());
        return this;
    }

    public SysRole buildSysRole(SysRoleQueryDto sysRoleQueryDto) {
        BeanUtils.copyProperties(sysRoleQueryDto, this);
        return this;
    }
}