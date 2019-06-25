package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户列表查询条件对象")
public class SysUserQueryDto extends PageParam {

    @ApiModelProperty(value = "登录名",notes = "登录名")
    private String username;

    @ApiModelProperty(value = "真实姓名",notes = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "性别",notes = "性别",allowableValues = "0,1,2")
    private int sex;

    @ApiModelProperty(value = "手机号码",notes = "手机号码")
    private String telephone;

    @ApiModelProperty(value = "所在省份编码",notes = "所在省份编码")
    private String provinceCode;

    @ApiModelProperty(value = "所在城市编码",notes = "所在城市编码")
    private String cityCode;

    @ApiModelProperty(value = "所在区县编码",notes = "所在区县编码")
    private String districtCode;

    @ApiModelProperty(value = "身份证号码",notes = "身份证号码")
    private String idCard;

    @ApiModelProperty(value = "用户状态",notes = "用户状态",allowableValues = "1,2,3,4 ")
    private boolean state;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
