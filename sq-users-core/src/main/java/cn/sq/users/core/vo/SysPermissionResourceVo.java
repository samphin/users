package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysPermissionResourcePk;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 显示权限已拥有的资源信息
 */
public class SysPermissionResourceVo {

    private Integer resourceId;

    private String resourceType;

    public SysPermissionResourceVo() {
    }

    public SysPermissionResourceVo(Integer resourceId,String resourceType) {
        this.resourceId = resourceId;
        this.resourceType = resourceType;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public static List<SysPermissionResourceVo> buildVoList(List<SysPermissionResourcePk> poList){
        if(CollectionUtils.isEmpty(poList)){
            return null;
        }
        List<SysPermissionResourceVo> voList = Lists.transform(poList, new Function<SysPermissionResourcePk, SysPermissionResourceVo>() {
            @Override
            public SysPermissionResourceVo apply(SysPermissionResourcePk po) {
                SysPermissionResourceVo vo = new SysPermissionResourceVo(po.getResourceId(),po.getResourceType());
                return vo;
            }
        });
        return voList;
    }
}