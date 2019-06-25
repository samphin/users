package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysUserGroup;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserGroupMapper extends Mapper<SysUserGroup> {

    /**
     * 分页查询
     *
     * @param po
     * @return
     */
    List<SysUserGroup> selectPageList(SysUserGroup po);

    /**
     * 根据数据版本修改已变更数据
     *
     * @param po
     * @return
     */
    int updateByPrimaryKeyAndVersionSelective(SysUserGroup po);
}