package cn.sq.users.core.vo;

import cn.sq.users.core.dto.SysRoleDto;
import cn.sq.users.core.po.BasePo;
import cn.sq.users.core.po.SysRole;
import cn.sq.users.core.util.Data2LongSerizlizer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

public class SysRoleVo{

    private Integer id;

    private String name;

    private Boolean state;

    private String description;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    //转换Po-->Vo
    public static SysRoleVo buildSysRole(SysRole sysRole) {
        SysRoleVo vo = new SysRoleVo();
        BeanUtils.copyProperties(sysRole, vo);
        vo.setId(sysRole.getId());
        return vo;
    }

    //转换List<Po>-->List<Vo>
    public static List<SysRoleVo> buildSysRoleList(List<SysRole> sysRoles){
        if(CollectionUtils.isEmpty(sysRoles)){
            return null;
        }
        List<SysRoleVo> voList = Lists.transform(sysRoles, new Function<SysRole,SysRoleVo>(){
            @Override
            public SysRoleVo apply(SysRole sysRole) {
                return buildSysRole(sysRole);
            }
        });
        return voList;
    }
}