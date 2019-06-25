package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysPermissionDto;
import cn.sq.users.core.dto.SysPermissionQueryDto;
import cn.sq.users.core.dto.SysPermissionStateDto;
import cn.sq.users.core.dto.SysPermissionUpdateDto;
import cn.sq.users.core.util.Data2LongSerizlizer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class SysPermission extends BaseOperatorPo<Integer>{

    private String name;

    private String description;

    private Boolean state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    //保存：转换Dto-->Po
    public SysPermission buildSysPermission(SysPermissionDto saveDto){
        BeanUtils.copyProperties(saveDto,this);
        this.setCreateTime(new Date());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //保存：转换Dto-->Po
    public SysPermission buildSysPermission(SysPermissionUpdateDto updateDto){
        BeanUtils.copyProperties(updateDto,this);
        this.setId(updateDto.getId());
        this.setLastUpdateTime(new Date());
        return this;
    }

    /**
     * 查询：Dto-->Po
     * @param queryDto
     * @return
     */
    public SysPermission buildSysPermission(SysPermissionQueryDto queryDto){
        this.setName(queryDto.getName());
        this.setState(queryDto.getState());
        return this;
    }

    public SysPermission buildSysPermission(SysPermissionStateDto stateDto){
        this.setId(stateDto.getId());
        this.setState(stateDto.getState());
        return this;
    }
}