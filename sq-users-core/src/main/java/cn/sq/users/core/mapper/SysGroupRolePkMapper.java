package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysGroupRolePk;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysGroupRolePkMapper extends Mapper<SysGroupRolePk> {

    /**
     * 给用户组设置角色
     *
     * @param groupRolePkList
     * @return
     */
    int saveBatch(List<SysGroupRolePk> groupRolePkList);
}