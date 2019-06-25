package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {

    /**
     * 分页查询
     *
     * @param po
     * @return
     */
    List<SysUser> selectPageList(SysUser po);

    /**
     * 根据数据版本进行数据修改
     */
    int updateByPrimaryKeyAndVersionSelective(SysUser po);

    /**
     * 根据组ID，查询当前组下面所有用户信息
     *
     * @param groupId
     * @return
     */
    List<SysUser> selectGroupHaveUsers(@Param("groupId") Integer groupId);

    /**
     * 根据组ID，以及用户姓名来查询用户信息
     *
     * @param groupId
     * @param realName
     * @return
     */
    List<SysUser> selectGroupHaveNoUsers(@Param("groupId") Integer groupId, @Param("realName") String realName);
}
