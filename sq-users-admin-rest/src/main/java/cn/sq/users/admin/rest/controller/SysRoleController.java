package cn.sq.users.admin.rest.controller;

import cn.sq.users.admin.rest.constants.BaseUrlConstants;
import cn.sq.users.core.checktor.SysRoleDtoChecktor;
import cn.sq.users.core.dto.*;
import cn.sq.users.core.service.impl.SysRoleService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.Result;
import cn.sq.users.core.vo.SysPermissionListVo;
import cn.sq.users.core.vo.SysRoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SysRoleController", tags = "角色管理接口")
@RestController
@RequestMapping(value = BaseUrlConstants.base_sys_api_prefix + "/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "创建角色信息", httpMethod = "POST", notes = "新增一条角色信息")
    @ApiImplicitParam(name = "name", value = "角色名称", required = true, dataType = "String")
    @PostMapping
    public Result save(@RequestBody SysRoleDto dto) {
        SysRoleDtoChecktor.check(dto);
        boolean bl = sysRoleService.save(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "修改角色信息", httpMethod = "PATCH", notes = "修改角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "角色名称", required = true, dataType = "String")
    })
    @PatchMapping
    public Result update(@RequestBody SysRoleUpdateDto dto) {
        SysRoleDtoChecktor.check(dto, dto.getId());
        boolean bl = sysRoleService.update(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "删除角色信息", httpMethod = "DELETE", notes = "根据角色ID，删除一条角色信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "角色ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean bl = sysRoleService.delete(id);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "查询角色列表", httpMethod = "GET", notes = "分页查询角色列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
    @GetMapping
    public Result queryPageList(@ModelAttribute SysRoleQueryDto dto) {
        PageBean<SysRoleVo> pageList = sysRoleService.queryPageList(dto);
        return Result.ok().setData(pageList);
    }

    @ApiOperation(value = "查询角色详情", httpMethod = "GET", notes = "根据角色ID，查询角色详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "角色ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result queryOne(@PathVariable Integer id) {
        SysRoleVo vo = sysRoleService.queryOne(id);
        return Result.ok().setData(vo);
    }

    @ApiOperation(value = "给角色绑定权限信息", httpMethod = "POST", notes = "根据角色ID，给角色绑定一个或多个权限信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "permissionIds", value = "权限ID拼接字符串，多个ID用逗号隔开", required = true, dataType = "string")
    })
    @PostMapping("/permissions")
    public Result bindPermissions(@RequestBody SysRolePermissionPkDto dto) {
        boolean bl = this.sysRoleService.bindingPermissions(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "查询角色已拥有的权限信息", httpMethod = "GET", notes = "根据角色ID，查询角色已拥有的权限信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "角色ID", required = true, dataType = "Integer")
    @GetMapping("/{id}/permissions")
    public Result queryHavePermissions(@PathVariable Integer id) {
        List<SysPermissionListVo> permissionVoList = this.sysRoleService.queryRoleHavePermissions(id);
        return Result.ok().setData(permissionVoList);
    }

    @ApiOperation(value = "查询角色未拥有的权限信息", httpMethod = "GET", notes = "根据角色ID，查询角色未拥有的权限信息")
    @GetMapping("/other/permissions")
    public Result queryHaveNoPermissions(@ModelAttribute SysRolePermissionPkQueryDto dto) {
        List<SysPermissionListVo> permissionVoList = this.sysRoleService.queryRoleHaveNoPermissions(dto);
        return Result.ok().setData(permissionVoList);
    }
}
