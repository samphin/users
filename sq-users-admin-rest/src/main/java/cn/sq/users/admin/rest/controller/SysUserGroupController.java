package cn.sq.users.admin.rest.controller;

import cn.sq.users.admin.rest.constants.BaseUrlConstants;
import cn.sq.users.core.checktor.SysGroupRoleDtoChecktor;
import cn.sq.users.core.checktor.SysUserGroupDtoChecktor;
import cn.sq.users.core.checktor.SysUserGroupPkDtoChecktor;
import cn.sq.users.core.dto.*;
import cn.sq.users.core.service.impl.SysUserGroupService;
import cn.sq.users.core.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "SysUserGroupController", tags = "用户组管理接口")
@RestController
@RequestMapping(value = BaseUrlConstants.base_sys_api_prefix + "/user_group")
public class SysUserGroupController {

    @Resource
    private SysUserGroupService userGroupService;

    @ApiOperation(value = "创建用户组", httpMethod = "POST", notes = "创建用户组相关信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户组名称", required = true, dataType = "String")
    })
    @PostMapping
    public Result save(@RequestBody SysUserGroupDto dto) {
        SysUserGroupDtoChecktor.check(dto);
        boolean bl = userGroupService.save(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure(null);
        }
    }

    @ApiOperation(value = "用户组列表信息", httpMethod = "GET", notes = "通过分页查询方式，查询所有用户组的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "int")
    })
    @GetMapping
    public Result queryPageList(@ModelAttribute SysUserGroupQueryDto dto) {
        PageBean<SysUserGroupVo> groups = userGroupService.queryPageList(dto);
        return Result.ok().setData(groups);
    }

    @ApiOperation(value = "修改用户组信息", httpMethod = "PATCH", notes = "修改用户组基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户组ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "用户组名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "version", value = "数据版本号", required = true, dataType = "Integer")
    })
    @PatchMapping
    public Result update(@RequestBody SysUserGroupUpdateDto dto) {
        SysUserGroupDtoChecktor.check(dto, dto.getId());
        boolean bl = userGroupService.update(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure(null);
        }
    }

    @ApiOperation(value = "查询单个用户组信息", httpMethod = "GET", notes = "通过用户组ID，查询用户组详情")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户组ID", required = true, dataType = "int")
    @GetMapping("/{id}")
    public Result queryOne(@PathVariable("id") Integer id) {
        SysUserGroupVo sysGroupVo = userGroupService.queryOne(id);
        return Result.ok().setData(sysGroupVo);
    }

    @ApiOperation(value = "向用户组添加用户信息", httpMethod = "POST", notes = "向用户组添加一个或多个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "用户组ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "userIds", value = "用户ID拼接字符串，多个ID用逗号隔开", required = true, dataType = "string")
    })
    @PostMapping("/users")
    public Result addUserIntoGroup(@RequestBody SysUserGroupPkDto dto) {
        SysUserGroupPkDtoChecktor.check(dto);
        boolean bl = userGroupService.saveBatch(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "删除用户组", httpMethod = "DELETE", notes = "删除不需要的用户组，同时删除该组对应的角色信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户组ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean bl = userGroupService.delete(id);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "解散用户组", httpMethod = "DELETE", notes = "将用户组里面的用户清空")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户组ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}/empty")
    public Result dismissGroup(@PathVariable Integer id) {
        boolean bl = userGroupService.dismissGroup(id);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "查询当前用户组所有用户信息", httpMethod = "GET", notes = "通过用户组来获取当前当前组员信息")
    @ApiImplicitParam(paramType = "path", name = "groupId", value = "用户组ID", required = true, dataType = "Integer")
    @GetMapping("/{id}/users")
    public Result queryUsersByGroupId(@PathVariable("id") Integer id) {
        List<SysUserGroupPkVo> voList = userGroupService.queryGroupHaveUsers(id);
        return Result.ok().setData(voList);
    }

    @ApiOperation(value = "查询不属于当前用户组的用户信息", httpMethod = "GET", notes = "查询不属于当前用户组的用户信息，用于向当前用户组添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "用户组ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "realName", value = "用户姓名", required = false, dataType = "String")
    })
    @GetMapping("/other/users")
    public Result queryOtherUsersByGroupId(@ModelAttribute SysUserGroupPkQueryDto dto) {
        PageBean<SysUserGroupPkVo> groups = userGroupService.queryGroupHaveNoUsers(dto);
        return Result.ok().setData(groups);
    }

    @ApiOperation(value = "用户组分配角色", httpMethod = "POST", notes = "用户组分配一个或多个角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "用户组ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "roleIds", value = "角色ID拼接字符串，多个ID用逗号隔开", required = true, dataType = "string")
    })
    @PostMapping("/roles")
    public Result bindingsRoles(@RequestBody SysGroupRolePkDto dto) {
        SysGroupRoleDtoChecktor.check(dto);
        boolean bl = userGroupService.bindingRoles(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "查询用户组已拥有的角色", httpMethod = "GET", notes = "查询用户组已拥有的角色列表")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户组ID", required = true, dataType = "Integer")
    @GetMapping("/{id}/roles")
    public Result queryHaveRoles(@PathVariable Integer id) {
        List<SysSimpleRoleVo> haveRoleList = userGroupService.queryUserGroupHaveRoles(id);
        return Result.ok().setData(haveRoleList);
    }


    @ApiOperation(value = "查询用户组未拥有的角色", httpMethod = "GET", notes = "查询用户组未拥有的角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "用户组ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "角色名称", required = false, dataType = "String")
    })
    @GetMapping("/other/roles")
    public Result queryHaveNoRoles(@ModelAttribute SysUserGroupRolePkQueryDto dto) {
        List<SysSimpleRoleVo> haveRoleList = userGroupService.queryUserGroupHaveNoRoles(dto);
        return Result.ok().setData(haveRoleList);
    }
}
