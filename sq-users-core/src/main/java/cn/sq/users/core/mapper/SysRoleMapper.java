package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {

    /**
     * 分页查询
     *
     * @param po
     * @return
     */
    List<SysRole> selectPageList(SysRole po);

    /**
     * 根据数据版本修改已变更数据
     * @param po
     * @return
     */
    int updateByPrimaryKeyAndVersionSelective(SysRole po);

    /**
     * 查询用户组已拥有的角色信息
     *
     * @param userGroupId
     * @return
     */
    List<SysRole> selectUserGroupHaveRoles(@Param("userGroupId") Integer userGroupId);


    /**
     * 查询用户组未拥有的角色信息
     *
     * @param userGroupId
     * @param name
     * @return
     */
    List<SysRole> selectUserGroupHaveNoRoles(@Param("userGroupId") Integer userGroupId, @Param("name") String name);

    /**
     * 查询用户已拥有的角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> selectUserHaveRoles(@Param("userId") Integer userId);

    /**
     * 查询用户未拥有的角色信息
     *
     * @param userId
     * @param name
     * @return
     */
    List<SysRole> selectUserHaveNoRoles(@Param("userId") Integer userId, @Param("name") String name);
}