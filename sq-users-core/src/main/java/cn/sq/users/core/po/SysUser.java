package cn.sq.users.core.po;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.util.Pkcs7Encoder;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class SysUser extends BaseOperatorPo<Integer> {

    private String username;

    private String password;

    private String realName;

    private Integer sex;

    private Date birthday;

    private String email;

    private String telephone;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String districtCode;

    private String districtName;

    private String idCard;

    private Integer state;

    private Integer version;

    public SysUser() {
    }

    public SysUser(String realName, Integer sex, String telephone) {
        this.realName = realName;
        this.sex = sex;
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    //保存：转换Dto-->Po
    public SysUser buildSysUser(SysUserDto saveDto) {
        BeanUtils.copyProperties(saveDto, this);
        String pwd = Pkcs7Encoder.AESEncode(saveDto.getPassword());
        this.setPassword(pwd);
        this.setCreateTime(new Date());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //修改：Dto-->Po
    public SysUser buildSysUser(SysUserUpdateDto updateDto) {
        BeanUtils.copyProperties(updateDto, this);
        this.setId(updateDto.getId());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //修改密码：Dto-->Po
    public SysUser buildSysUser(SysUserPasswordDto passwordDto) {
        this.setId(passwordDto.getId());
        String pwd = Pkcs7Encoder.AESEncode(passwordDto.getNewPassword());
        this.setPassword(pwd);
        this.setLastUpdateTime(new Date());
        return this;
    }

    //修改状态：Dto-->Po
    public SysUser buildSysUser(SysUserStateDto stateDto) {
        this.setId(stateDto.getId());
        this.setState(stateDto.getState());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //查询：转换Dto-->Po
    public SysUser buildSysUser(SysUserQueryDto dto) {
        BeanUtils.copyProperties(dto, this);
        return this;
    }
}