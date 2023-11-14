package com.ipbd.ipbdsms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInfoDto {

    private Integer stuId;
    private String stuName;
    private String signUp;
    private String signOut;
    private String signUpRemark;
    private String signOutRemark;

    private Boolean showSignUp;
    private Boolean showSignOut;

}
