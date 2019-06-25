package cn.sq.users.admin.rest.controller;

import cn.sq.users.admin.rest.constants.BaseUrlConstants;
import cn.sq.users.core.checktor.SysPermissionDtoChecktor;
import cn.sq.users.core.checktor.SysPermissionResourceDtoChecktor;
import cn.sq.users.core.dto.*;
import cn.sq.users.core.service.impl.SysPermissionService;
import cn.sq.users.core.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SysPermissionController", tags = "权限管理接口")
@RestController
@RequestMapping(value = BaseUrlConstants.base_sys_api_prefix + "/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value = "保存权限信息", httpMethod = "POST", notes = "保存权限信息")
    @PostMapping
    public Result save(@ModelAttribute SysPermissionDto dto) {
        SysPermissionDtoChecktor.check(dto);
        boolean bl = sysPermissionService.save(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "修改权限信息", httpMethod = "PATCH", notes = "修改权限信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "权限编号", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "权限名称", required = true, dataType = "String")
    })
    @PatchMapping
    public Result update(@ModelAttribute SysPermissionUpdateDto dto) {
        SysPermissionDtoChecktor.check(dto, dto.getId());
        boolean bl = sysPermissionService.update(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "启用或禁用权限信息", httpMethod = "PATCH", notes = "方便快速启/禁用权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "权限编号", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "state", value = "权限状态", required = true, dataType = "boolean")
    })
    @PatchMapping("/state")
    public Result updateState(@ModelAttribute SysPermissionStateDto dto) {
        boolean bl = sysPermissionService.updateState(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "删除权限信息", httpMethod = "DELETE", notes = "根据权限ID，删除权限信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "权限ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean bl = sysPermissionService.delete(id);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "分页查询权限信息", httpMethod = "GET", notes = "分页查询权限信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
    @GetMapping
    public Result queryPageList(@ModelAttribute SysPermissionQueryDto dto) {
        PageBean<SysPermissionListVo> pageList = sysPermissionService.queryPageList(dto);
        return Result.ok().setData(pageList);
    }

    @ApiOperation(value = "查询所有权限信息", httpMethod = "GET", notes = "适有竽权限数量较少时，一次性展示")
    @GetMapping("/all")
    public Result queryList(@ModelAttribute SysPermissionQueryDto dto) {
        List<SysPermissionListVo> list = sysPermissionService.queryList(dto);
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "查询权限详情", httpMethod = "GET", notes = "根据权限编号，查询权限详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "权限ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result queryOne(@PathVariable Integer id) {
        SysPermissionVo vo = sysPermissionService.queryOne(id);
        return Result.ok().setData(vo);
    }

    @ApiOperation(value = "保存权限资源信息", httpMethod = "GET", notes = "保存当前权限绑定的资源信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "permissionId", value = "权限ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "resourceType", value = "资源类型：Menu或Button", required = true, dataType = "string"),
            @ApiImplicitParam(name = "resourceIds", value = "资源ID拼接字符串，多个ID用逗号隔开", required = true, dataType = "string")
    })
    @PostMapping("/resource")
    public Result bindPermissions(@ModelAttribute SysPermissionResourcePkDto pkDto) {
        SysPermissionResourceDtoChecktor.check(pkDto);
        boolean bl = this.sysPermissionService.bindingResource(pkDto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "查询权限绑定的资源信息", httpMethod = "GET", notes = "查询当前权限绑定的资源信息")
    @GetMapping("/resource")
    public Result queryHaveResource(@ModelAttribute SysPermissionResourcePkDto pkDto) {
        SysPermissionResourceDtoChecktor.baseCheck(pkDto);
        List<SysPermissionResourceVo> permissionVoList = this.sysPermissionService.queryPermissionHaveResource(pkDto);
        return Result.ok().setData(permissionVoList);
    }
}
