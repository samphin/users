package cn.sq.users.core.service.impl;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.mapper.SysPermissionMapper;
import cn.sq.users.core.mapper.SysRoleMapper;
import cn.sq.users.core.mapper.SysRolePermissionPkMapper;
import cn.sq.users.core.po.SysPermission;
import cn.sq.users.core.po.SysRole;
import cn.sq.users.core.po.SysRolePermissionPk;
import cn.sq.users.core.service.ISysRoleService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysPermissionListVo;
import cn.sq.users.core.vo.SysRoleVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SysRoleService implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRolePermissionPkMapper sysRolePermissionPkMapper;

    @Resource
    private SysPermissionMapper permissionMapper;

    @Override
    public boolean save(SysRoleDto dto) {
        SysRole po = new SysRole().buildSysRole(dto);
        return sysRoleMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean update(SysRoleUpdateDto dto) {
        SysRole sysRole = new SysRole().buildSysRole(dto);
        return sysRoleMapper.updateByPrimaryKeyAndVersionSelective(sysRole) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return sysRoleMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public PageBean<SysRoleVo> queryPageList(SysRoleQueryDto dto) {

        //开启分页
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        //组装查询条件
        SysRole po = new SysRole().buildSysRole(dto);

        //返回查询结果
        List<SysRole> poList = this.sysRoleMapper.selectPageList(po);

        //将poList转换成voList
        List<SysRoleVo> voList = SysRoleVo.buildSysRoleList(poList);

        //封装查询结果到PageBean
        PageBean<SysRoleVo> pageBean = new PageBean<SysRoleVo>(voList);

        return pageBean;
    }

    @Override
    public SysRoleVo queryOne(Integer id) {
        SysRole po = this.sysRoleMapper.selectByPrimaryKey(id);

        SysRoleVo vo = SysRoleVo.buildSysRole(po);

        return vo;
    }

    @Override
    public List<SysRoleVo> queryList(SysRoleQueryDto dto) {

        SysRole po = new SysRole().buildSysRole(dto);

        //返回查询结果
        List<SysRole> poList = this.sysRoleMapper.select(po);

        //将poList转换成voList
        List<SysRoleVo> voList = SysRoleVo.buildSysRoleList(poList);

        return voList;
    }


    /***************************给角色绑定权限*******************/

    @Override
    public boolean bindingPermissions(SysRolePermissionPkDto dto) {
        //先清空当前角色旧数据
        SysRolePermissionPk sysRolePermissionPk = new SysRolePermissionPk();
        sysRolePermissionPk.setRoleId(dto.getRoleId());
        sysRolePermissionPkMapper.delete(sysRolePermissionPk);

        //绑定新的权限信息
        List<SysRolePermissionPk> poList = new SysRolePermissionPk().buildPoList(dto);
        return sysRolePermissionPkMapper.saveBatch(poList) > 0;
    }

    @Override
    public List<SysPermissionListVo> queryRoleHavePermissions(Integer roleId) {

        List<SysPermission> poList = this.permissionMapper.selectRoleHavePermissions(roleId);

        List<SysPermissionListVo> voList = SysPermissionListVo.buildVoList(poList);

        return voList;
    }

    @Override
    public List<SysPermissionListVo> queryRoleHaveNoPermissions(SysRolePermissionPkQueryDto dto) {

        List<SysPermission> poList = this.permissionMapper.selectRoleHaveNoPermissions(dto.getRoleId(),dto.getName());

        List<SysPermissionListVo> voList = SysPermissionListVo.buildVoList(poList);

        return voList;
    }

}
