package cn.sq.users.core.service.impl;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.mapper.SysRoleMapper;
import cn.sq.users.core.mapper.SysUserMapper;
import cn.sq.users.core.mapper.SysUserRolePkMapper;
import cn.sq.users.core.po.SysRole;
import cn.sq.users.core.po.SysUser;
import cn.sq.users.core.po.SysUserRolePk;
import cn.sq.users.core.service.ISysUserService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysSimpleRoleVo;
import cn.sq.users.core.vo.SysUserListVo;
import cn.sq.users.core.vo.SysUserVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SysUserService implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRolePkMapper sysUserRolePkMapper;

    @Resource
    private SysRoleMapper roleMapper;

    @Override
    public boolean save(SysUserDto dto) {
        SysUser sysUser = new SysUser().buildSysUser(dto);
        boolean bl = sysUserMapper.insertSelective(sysUser) > 0;
        return bl;
    }

    @Override
    public boolean update(SysUserUpdateDto dto) {
        SysUser sysUser = new SysUser().buildSysUser(dto);
        boolean bl = sysUserMapper.updateByPrimaryKeyAndVersionSelective(sysUser) > 0;
        return bl;
    }

    @Override
    public boolean updatePassword(SysUserPasswordDto passwordDto) {
        SysUser sysUser = new SysUser().buildSysUser(passwordDto);
        boolean bl = sysUserMapper.updateByPrimaryKeyAndVersionSelective(sysUser) > 0;
        return bl;
    }

    @Override
    public boolean updateState(SysUserStateDto stateDto) {
        SysUser sysUser = new SysUser().buildSysUser(stateDto);
        boolean bl = sysUserMapper.updateByPrimaryKeyAndVersionSelective(sysUser) > 0;
        return bl;
    }

    @Override
    public boolean delete(Integer id) {
        boolean bl = sysUserMapper.deleteByPrimaryKey(id) > 0;
        return bl;
    }

    @Override
    public PageBean<SysUserListVo> queryPageList(SysUserQueryDto dto) {

        //开启分页
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        //组装查询条件
        SysUser sysUser = new SysUser().buildSysUser(dto);

        //返回查询结果
        List<SysUser> list = this.sysUserMapper.selectPageList(sysUser);

        //将poList转换成voList
        List<SysUserListVo> voList = SysUserListVo.buildSysUserVoList(list);

        //封装查询结果到PageBean
        PageBean<SysUserListVo> pageBean = new PageBean<SysUserListVo>(voList);

        return pageBean;
    }

    @Override
    public SysUserVo queryOne(Integer id) {
        SysUser sysUser = this.sysUserMapper.selectByPrimaryKey(id);
        SysUserVo vo = SysUserVo.buildSysUserVo(sysUser);
        return vo;
    }

    @Override
    public List<SysUserListVo> queryList(SysUserQueryDto dto) {
        //组装查询条件
        SysUser sysUser = new SysUser(dto.getRealName(), dto.getSex(), dto.getTelephone());

        //返回查询结果
        List<SysUser> list = this.sysUserMapper.select(sysUser);

        //将poList转换成voList
        List<SysUserListVo> voList = SysUserListVo.buildSysUserVoList(list);

        return voList;
    }


    /*************************用户设置角色*********************/

    @Override
    public boolean bindingRoles(SysUserRolePkDto dto) {
        List<SysUserRolePk> sysUserRolePkList = new SysUserRolePk().buildSysGroupRole(dto);
        //根据用户ID，先清除之前绑定的关联信息
        SysUserRolePk sysUserRolePk = new SysUserRolePk();
        sysUserRolePk.setUserId(dto.getUserId());
        sysUserRolePkMapper.delete(sysUserRolePk);

        //保存最新的用户与角色关联信息
        return sysUserRolePkMapper.saveBatch(sysUserRolePkList) > 0;
    }

    @Override
    public List<SysSimpleRoleVo> queryUserHaveRoles(Integer userId) {
        List<SysRole> roleList = this.roleMapper.selectUserHaveRoles(userId);

        List<SysSimpleRoleVo> sysGroupRoleVoList = SysSimpleRoleVo.buildSysGroupRoleVoList(roleList);

        return sysGroupRoleVoList;
    }

    @Override
    public List<SysSimpleRoleVo> queryUserHaveNoRoles(SysUserRolePkQueryDto dto) {
        List<SysRole> roleList = this.roleMapper.selectUserHaveNoRoles(dto.getUserId(), dto.getName());

        List<SysSimpleRoleVo> sysGroupRoleVoList = SysSimpleRoleVo.buildSysGroupRoleVoList(roleList);

        return sysGroupRoleVoList;
    }
}
