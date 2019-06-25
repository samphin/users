package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysButton;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysButtonMapper extends Mapper<SysButton> {

    /**
     * 查询菜单按钮列表
     *
     * @param menuId
     * @return
     */
    List<SysButton> selectButtonsByMenuId(@Param("menuId") Integer menuId);

    /**
     * 分页查询
     * @param po
     * @return
     */
    List<SysButton> selectPageList(SysButton po);

    /**
     * 根据数据版本进行数据修改
     */
    int updateByPrimaryKeyAndVersionSelective(SysButton po);

}