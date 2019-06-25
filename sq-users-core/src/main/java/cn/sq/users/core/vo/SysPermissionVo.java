package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysPermission;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SysPermissionVo{

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

    public static SysPermissionVo buildVo(SysPermission sysPermission){
        SysPermissionVo vo = new SysPermissionVo();
        BeanUtils.copyProperties(sysPermission,vo);
        vo.setId(sysPermission.getId());
        return vo;
    }

    public static List<SysPermissionVo> buildVoList(List<SysPermission> sysPermissionList){
        List<SysPermissionVo> voList = Lists.transform(sysPermissionList, new Function<SysPermission, SysPermissionVo>() {
            @Override
            public SysPermissionVo apply(SysPermission sysPermission) {
                return buildVo(sysPermission);
            }
        });
        return voList;
    }
}