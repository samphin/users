package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysUserGroupPkDto;
import cn.sq.users.core.util.Data2LongSerizlizer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserGroupPk{

    private Integer userId;

    private Integer groupId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public List<SysUserGroupPk> buildSysUserGroup(SysUserGroupPkDto dto){
        //将用户信息转换成用户数组
        String[] userIds = dto.getUserIds().split(",");

        List<SysUserGroupPk> userGroups = new ArrayList<>(userIds.length);
        for (int i = 0;i<userIds.length;i++){
            SysUserGroupPk userGroup = new SysUserGroupPk();
            userGroup.setGroupId(dto.getGroupId());
            userGroup.setUserId(Integer.valueOf(userIds[i]));
            userGroups.add(userGroup);
        }
        return userGroups;
    }
}