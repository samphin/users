package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysPermission;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SysPermissionListVo {

    private Integer id;

    private String name;

    private Boolean state;

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

    public static SysPermissionListVo buildVo(SysPermission sysPermission){
        SysPermissionListVo vo = new SysPermissionListVo();
        BeanUtils.copyProperties(sysPermission,vo);
        vo.setId(sysPermission.getId());
        return vo;
    }

    public static List<SysPermissionListVo> buildVoList(List<SysPermission> sysPermissionList){
        List<SysPermissionListVo> voList = Lists.transform(sysPermissionList, new Function<SysPermission, SysPermissionListVo>() {
            @Override
            public SysPermissionListVo apply(SysPermission sysPermission) {
                return buildVo(sysPermission);
            }
        });
        return voList;
    }
}