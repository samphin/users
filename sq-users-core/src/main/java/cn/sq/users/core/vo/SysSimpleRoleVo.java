package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysRole;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户或用户组--->角色列表
 */
public class SysSimpleRoleVo {

    private Integer id;

    private String name;

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
        this.name = name;
    }

    public static List<SysSimpleRoleVo> buildSysGroupRoleVoList(List<SysRole> roleList){
        if(CollectionUtils.isEmpty(roleList)){
            return null;
        }
        List<SysSimpleRoleVo> sysGroupRoleVoList = Lists.transform(roleList, new Function<SysRole, SysSimpleRoleVo>() {
            @Override
            public SysSimpleRoleVo apply(SysRole sysRole) {
                SysSimpleRoleVo vo = new SysSimpleRoleVo();
                vo.setId(sysRole.getId());
                vo.setName(sysRole.getName());
                return vo;
            }
        });
        return sysGroupRoleVoList;
    }
}
