package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysUser;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class SysUserGroupPkVo {

    private Integer userId;

    private String realName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public static SysUserGroupPkVo buildSysUserVo(SysUser sysUser){
        SysUserGroupPkVo vo = new SysUserGroupPkVo();
        vo.setUserId(sysUser.getId());
        vo.setRealName(sysUser.getRealName());
        return vo;
    }

    public static List<SysUserGroupPkVo> buildSysUserGroupVoList(List<SysUser> sysUserList){
        if(CollectionUtils.isEmpty(sysUserList)){
            return null;
        }
        List<SysUserGroupPkVo> sysUserVoList = Lists.transform(sysUserList,new Function<SysUser, SysUserGroupPkVo>(){
            @Override
            public SysUserGroupPkVo apply(@Nullable SysUser sysUser) {
                return buildSysUserVo(sysUser);
            }
        });
        return sysUserVoList;
    }
}
