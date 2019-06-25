package cn.sq.users.admin.rest.controller;

import cn.sq.users.admin.rest.constants.BaseUrlConstants;
import cn.sq.users.core.checktor.SysMenuDtoChecktor;
import cn.sq.users.core.dto.SysMenuDto;
import cn.sq.users.core.dto.SysMenuQueryDto;
import cn.sq.users.core.dto.SysMenuUpdateDto;
import cn.sq.users.core.service.impl.SysMenuService;
import cn.sq.users.core.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SysMenuController",tags = "菜单管理接口")
@RestController
@RequestMapping(value = BaseUrlConstants.base_sys_api_prefix + "/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "创建菜单信息", httpMethod = "POST", notes = "新增一条菜单记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "菜单名称", required = true, dataType = "String")
    })
    @PostMapping
    public Result save(@RequestBody SysMenuDto dto) {
        SysMenuDtoChecktor.check(dto);
        boolean bl = sysMenuService.save(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "修改菜单信息", httpMethod = "PATCH", notes = "修改菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "version", value = "数据版本号", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "菜单名称", required = true, dataType = "String"),
    })
    @PatchMapping
    public Result update(@RequestBody SysMenuUpdateDto dto) {
        SysMenuDtoChecktor.check(dto, dto.getId());
        boolean bl = sysMenuService.update(dto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "删除菜单信息", httpMethod = "DELETE", notes = "根据菜单ID，删除菜单一条信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "菜单ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean bl = sysMenuService.delete(id);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "分页查询菜单列表信息", httpMethod = "GET", notes = "分页查询菜单列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
    @GetMapping
    public Result queryPageList(@ModelAttribute SysMenuQueryDto dto) {
        PageBean<SysMenuListVo> pageList = sysMenuService.queryPageList(dto);
        return Result.ok().setData(pageList);
    }


    @ApiOperation(value = "通过树型结构展示菜单信息", httpMethod = "GET", notes = "通过树型结构展示菜单信息")
    @GetMapping("/all")
    public Result queryList() {
        List<SysMenuListVo> list = sysMenuService.queryList();
        return Result.ok().setData(list);
    }

    @ApiOperation(value = "查询菜单详情", httpMethod = "GET", notes = "根据菜单ID，查询菜单详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "菜单ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result queryOne(@PathVariable Integer id) {
        SysMenuVo vo = sysMenuService.queryOne(id);
        return Result.ok().setData(vo);
    }

    @ApiOperation(value = "查询菜单绑定的按钮信息", httpMethod = "GET", notes = "根据菜单ID，查询菜单绑定的按钮信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "菜单ID", required = true, dataType = "Integer")
    @GetMapping("/{id}/buttons")
    public Result queryMenuButtons(@PathVariable Integer id) {
        List<SysButtonListVo> buttonVoList = sysMenuService.queryMenuButtons(id);
        return Result.ok().setData(buttonVoList);
    }
}
