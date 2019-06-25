package cn.sq.users.core.service.impl;

import cn.sq.users.core.dto.SysMenuDto;
import cn.sq.users.core.dto.SysMenuQueryDto;
import cn.sq.users.core.dto.SysMenuUpdateDto;
import cn.sq.users.core.mapper.SysButtonMapper;
import cn.sq.users.core.mapper.SysMenuMapper;
import cn.sq.users.core.po.SysButton;
import cn.sq.users.core.po.SysMenu;
import cn.sq.users.core.service.ISysMenuService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysButtonListVo;
import cn.sq.users.core.vo.SysMenuListVo;
import cn.sq.users.core.vo.SysMenuVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SysMenuService implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Resource
    private SysButtonMapper sysButtonMapper;

    @Override
    public PageBean<SysMenuListVo> queryPageList(SysMenuQueryDto dto) {

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        SysMenu po = new SysMenu().buildSysMenu(dto);

        List<SysMenu> poList = this.sysMenuMapper.selectPageList(po);

        List<SysMenuListVo> voList = SysMenuListVo.buildSysMenuList(poList);

        PageBean<SysMenuListVo> pageBean = new PageBean<SysMenuListVo>(voList);

        return pageBean;
    }

    @Override
    public SysMenuVo queryOne(Integer id) {

        SysMenu po = this.sysMenuMapper.selectByPrimaryKey(id);

        SysMenuVo vo = SysMenuVo.buildSysMenu(po);

        return vo;

    }

    @Override
    public List<SysMenuListVo> queryList() {

        List<SysMenu> poList = this.sysMenuMapper.select(null);

        List<SysMenuListVo> voList = SysMenuListVo.buildSysMenuList(poList);

        //将菜单列表，格式化成树型结构显示
        List<SysMenuListVo> menuVoList = queryOneLevelMenu(voList);

        return menuVoList;
    }

    @Override
    public List<SysButtonListVo> queryMenuButtons(Integer id) {

        List<SysButton> buttonPoList = sysButtonMapper.selectButtonsByMenuId(id);

        List<SysButtonListVo> buttonVoList = SysButtonListVo.buildSysButtonVoList(buttonPoList);

        return buttonVoList;
    }

    /**
     * 获取所有一级菜单
     *
     * @return
     */
    private List<SysMenuListVo> queryOneLevelMenu(List<SysMenuListVo> sysMenuVos) {
        List<SysMenuListVo> oneLevelMenus = new ArrayList<>();
        for (SysMenuListVo oneVO : sysMenuVos) {
            //过滤出所有一级菜单
            if (oneVO.getParentId() == 0 && oneVO.getLevel() == 1)
                oneLevelMenus.add(oneVO);
        }

        //非一级菜单
        List<SysMenuListVo> noOneLevelMenus = queryNoOneLevelMenu(sysMenuVos);

        //循环一级菜单，将所有一级菜单对应的子菜单都循环遍历
        for (SysMenuListVo oneVo : oneLevelMenus) {
            oneVo.setChildren(queryChildren(oneVo.getId(), noOneLevelMenus));
        }
        return oneLevelMenus;
    }

    /**
     * 过滤出所有非一级菜单
     *
     * @param sysMenuVos
     * @return
     */
    private List<SysMenuListVo> queryNoOneLevelMenu(List<SysMenuListVo> sysMenuVos) {
        Iterator<SysMenuListVo> it = sysMenuVos.iterator();
        while (it.hasNext()) {
            SysMenuListVo vo = it.next();
            if (vo.getParentId() == 0 && vo.getLevel() == 1) {
                it.remove();
            }
        }
        return sysMenuVos;
    }

    /**
     * 递归查询所有子菜单
     *
     * @param parentId
     * @param noOneLevelMenus
     * @return
     */
    private List<SysMenuListVo> queryChildren(Integer parentId, List<SysMenuListVo> noOneLevelMenus) {
        List<SysMenuListVo> menuList = new ArrayList<>();
        for (SysMenuListVo menuVO : noOneLevelMenus) {
            //如果当前菜单ID与子菜单的parentId相同，则将这些子菜单汇总到上级菜单的children属性中
            if (parentId == menuVO.getParentId()) {
                if (menuVO.getLeaf() == false) {
                    menuVO.setChildren(queryChildren(menuVO.getId(), noOneLevelMenus));
                }
                menuList.add(menuVO);
            }
        }
        return menuList;
    }


    @Override
    public boolean save(SysMenuDto dto) {
        SysMenu po = new SysMenu().buildSysMenu(dto);
        return this.sysMenuMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean update(SysMenuUpdateDto dto) {
        SysMenu po = new SysMenu().buildSysMenu(dto);
        return this.sysMenuMapper.updateByPrimaryKeyAndVersionSelective(po) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return this.sysMenuMapper.deleteByPrimaryKey(id) > 0;
    }
}
