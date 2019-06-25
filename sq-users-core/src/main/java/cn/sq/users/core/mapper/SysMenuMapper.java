package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {

    /**
     * 分页查询
     *
     * @param po
     * @return
     */
    List<SysMenu> selectPageList(SysMenu po);

    /**
     * 根据数据版本来更新更改的数据
     *
     * @param po
     * @return
     */
    int updateByPrimaryKeyAndVersionSelective(SysMenu po);
}