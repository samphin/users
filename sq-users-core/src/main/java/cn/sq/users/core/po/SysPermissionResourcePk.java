package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysPermissionResourcePkDto;

import java.util.ArrayList;
import java.util.List;

public class SysPermissionResourcePk {

    private Integer permissionId;

    private String resourceType;

    private Integer resourceId;

    public SysPermissionResourcePk() {
    }

    public SysPermissionResourcePk(Integer permissionId, String resourceType, Integer resourceId) {
        this.permissionId = permissionId;
        this.resourceType = resourceType;
        this.resourceId = resourceId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public SysPermissionResourcePk buildPo(SysPermissionResourcePkDto dto){
        this.setPermissionId(dto.getPermissionId());
        this.setResourceType(dto.getResourceType());
        return this;
    }

    public List<SysPermissionResourcePk> buildPoList(SysPermissionResourcePkDto dto){

        List<SysPermissionResourcePk> poList = new ArrayList<>();

        String[] resourceIds = dto.getResourceIds().split(",");

        for (String resourceId : resourceIds) {
            SysPermissionResourcePk po = new SysPermissionResourcePk(dto.getPermissionId(),dto.getResourceType(),Integer.valueOf(resourceId));
            poList.add(po);
        }

        return poList;
    }
}