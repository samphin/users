package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysUserGroupDto;
import cn.sq.users.core.dto.SysUserGroupQueryDto;
import cn.sq.users.core.dto.SysUserGroupUpdateDto;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class SysUserGroup extends BaseOperatorPo<Integer>{

    private String name;

    private String description;

    public SysUserGroup(){}

    public SysUserGroup(String name) {
        this.name = name;
    }

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

    //保存：转换Dto-->Po
    public SysUserGroup buildSysGroup(SysUserGroupDto saveDto){
        BeanUtils.copyProperties(saveDto,this);
        this.setCreateTime(new Date());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //修改：转换Dto-->Po
    public SysUserGroup buildSysGroup(SysUserGroupUpdateDto updateDto){
        BeanUtils.copyProperties(updateDto,this);
        this.setId(updateDto.getId());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //查询：转换Dto-->Po
    public SysUserGroup buildSysGroup(SysUserGroupQueryDto dto){
        BeanUtils.copyProperties(dto,this);
        return this;
    }

}