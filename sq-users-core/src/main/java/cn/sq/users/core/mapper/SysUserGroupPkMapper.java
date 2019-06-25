package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysUserGroupPk;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户与组管理接口
 */
public interface SysUserGroupPkMapper extends Mapper<SysUserGroupPk> {

    /**
     * 向用户组批量保存用户
     *
     * @param pos
     * @return
     */
    int saveBatch(List<SysUserGroupPk> pos);


    /**
     * 解散用户组
     *
     * @param groupId
     * @return
     */
    int dismissGroup(@Param("groupId") Integer groupId);

}