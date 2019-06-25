package cn.sq.users.admin.rest.controller;

import cn.sq.users.admin.rest.constants.BaseUrlConstants;
import cn.sq.users.core.checktor.SysButtonDtoChecktor;
import cn.sq.users.core.dto.SysButtonDto;
import cn.sq.users.core.dto.SysButtonQueryDto;
import cn.sq.users.core.dto.SysButtonUpdateDto;
import cn.sq.users.core.service.impl.SysButtonService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.Result;
import cn.sq.users.core.vo.SysButtonVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "SysButtonController", tags = "按钮管理接口")
@RestController
@RequestMapping(value = BaseUrlConstants.base_sys_api_prefix + "/button")
public class SysButtonController {

    @Autowired
    private SysButtonService sysButtonService;

    @ApiOperation(value = "创建按钮信息", httpMethod = "POST", notes = "新增按钮信息")
    @ApiImplicitParam(name = "buttonDto", value = "按钮新增对象", required = true, dataType = "SysButtonDto")
    @PostMapping
    public Result save(@RequestBody SysButtonDto buttonDto) {
        SysButtonDtoChecktor.check(buttonDto);
        boolean bl = sysButtonService.save(buttonDto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "修改按钮信息", httpMethod = "PATCH", notes = "修改按钮信息")
    @ApiImplicitParam(name = "buttonUpdateDto", value = "按钮修改对象", required = true, dataType = "SysButtonUpdateDto")
    @PatchMapping
    public Result update(@RequestBody SysButtonUpdateDto buttonUpdateDto) {
        SysButtonDtoChecktor.check(buttonUpdateDto, buttonUpdateDto.getId());
        boolean bl = sysButtonService.update(buttonUpdateDto);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "删除按钮信息", httpMethod = "DELETE", notes = "删除按钮信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "按钮ID", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean bl = sysButtonService.delete(id);
        if (bl) {
            return Result.ok();
        } else {
            return Result.failure();
        }
    }

    @ApiOperation(value = "查询按钮列表信息", httpMethod = "GET", notes = "查询按钮列表")
    @GetMapping
    public Result queryPageList(@ModelAttribute SysButtonQueryDto dto) {
        PageBean<SysButtonVo> pageList = sysButtonService.queryPageList(dto);
        return Result.ok().setData(pageList);
    }

    @ApiOperation(value = "查询按钮详情", httpMethod = "GET", notes = "根据按钮ID查询按钮详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "按钮ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result queryOne(@PathVariable("id") Integer id) {
        SysButtonVo vo = sysButtonService.queryOne(id);
        return Result.ok().setData(vo);
    }
}
