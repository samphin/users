package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysUserRolePk;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserRolePkMapper extends Mapper<SysUserRolePk> {

    /**
     * 给用户设置角色
     *
     * @param userRolePkList
     * @return
     */
    int saveBatch(List<SysUserRolePk> userRolePkList);
}