package cn.sq.users.admin.rest.controller;

import cn.sq.users.admin.rest.constants.BaseUrlConstants;
import cn.sq.users.core.checktor.SysUserDtoChecktor;
import cn.sq.users.core.checktor.SysUserPasswordDtoChecktor;
import cn.sq.users.core.checktor.SysUserRoleDtoChecktor;
import cn.sq.users.core.dto.*;
import cn.sq.users.core.service.impl.SysUserService;
import cn.sq.users.core.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SysUserController", tags = "用户管理接口")
@RestController
@RequestMapping(value = BaseUrlConstants.base_sys_api_prefix + "/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "创建用户信息", httpMethod = "POST", notes = "新增一条用户信息")
    @PostMapping
    public Result save(@RequestBody SysUserDto dto) {
        SysUserDtoChecktor.check(dto);
        boolean bl = sysUserService.save(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "修改用户信息", httpMethod = "PATCH", notes = "修改一条用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "username", value = "登录名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "realName", value = "用户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "idCard", value = "身份证号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "state", value = "用户状态： 1 ：在职 2 ：离职 3 ：停职 4 ：退休", required = true, dataType = "Integer")
    })
    @PatchMapping
    public Result update(@RequestBody SysUserUpdateDto dto) {
        SysUserDtoChecktor.check(dto);
        boolean bl = sysUserService.update(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "修改用户密码", httpMethod = "PATCH", notes = "修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    @PatchMapping("/password")
    public Result updatePassword(@RequestBody SysUserPasswordDto dto) {
        SysUserPasswordDtoChecktor.check(dto);
        boolean bl = sysUserService.updatePassword(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "注销用户信息", httpMethod = "PATCH", notes = "修改用户状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "state", value = "用户状态", required = true, dataType = "Integer")
    })
    @PatchMapping("/state")
    public Result logon(@RequestBody SysUserStateDto dto) {
        boolean bl = sysUserService.updateState(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "彻底删除用户信息", httpMethod = "DELETE", notes = "删除用户信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean bl = sysUserService.delete(id);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "分页查询用户信息", httpMethod = "GET", notes = "通过分页方式查询用户列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
    @GetMapping
    public Result queryPageList(@ModelAttribute SysUserQueryDto dto) {
        PageBean<SysUserListVo> pageList = sysUserService.queryPageList(dto);
        return Result.ok().setData(pageList);
    }

    @ApiOperation(value = "查询用户详情", httpMethod = "GET", notes = "根据用户ID，查询用户详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result queryOne(@PathVariable Integer id) {
        SysUserVo vo = sysUserService.queryOne(id);
        return Result.ok().setData(vo);
    }


    @ApiOperation(value = "用户分配角色", httpMethod = "POST", notes = "根据用户ID，给用户分配一个或多个角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "roleIds", value = "角色ID拼接字符串，多个ID用逗号隔开", required = true, dataType = "string")
    })
    @PostMapping("/roles")
    public Result bindingsRoles(@RequestBody SysUserRolePkDto dto) {
        SysUserRoleDtoChecktor.check(dto);
        boolean bl = this.sysUserService.bindingRoles(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "查询用户已拥有的角色信息", httpMethod = "GET", notes = "查询用户已拥有的角色信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("/{id}/roles")
    public Result queryUserHaveRoles(@PathVariable Integer id) {
        List<SysSimpleRoleVo> sysGroupRoleVoList = this.sysUserService.queryUserHaveRoles(id);
        return Result.ok().setData(sysGroupRoleVoList);
    }

    @ApiOperation(value = "查询用户未拥有的角色信息", httpMethod = "GET", notes = "查询用户未拥有的角色信息")
    @GetMapping("/other/roles")
    public Result queryUserHaveNoRoles(@ModelAttribute SysUserRolePkQueryDto dto) {
        List<SysSimpleRoleVo> sysGroupRoleVoList = this.sysUserService.queryUserHaveNoRoles(dto);
        return Result.ok().setData(sysGroupRoleVoList);
    }
}
