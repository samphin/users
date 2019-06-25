package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysPermissionMapper extends Mapper<SysPermission> {

    /**
     * 修改权限状态
     * @param po
     * @return
     */
    int updateState(SysPermission po);

    /**
     * 根据数版本来修改已变更的数据
     * @param po
     * @return
     */
    int updateByPrimaryKeyAndVersionSelective(SysPermission po);

    /**
     * 查询角色拥有的权限信息
     *
     * @param roleId
     * @return
     */
    List<SysPermission> selectRoleHavePermissions(@Param("roleId") Integer roleId);

    /**
     * 查询角色未拥有的权限信息
     *
     * @param roleId
     * @param name
     * @return
     */
    List<SysPermission> selectRoleHaveNoPermissions(@Param("roleId") Integer roleId, @Param("name") String name);
}