package cerlace.tastetrack.requestmapper.impl;

import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.requestmapper.RequestMapper;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.http.HttpServletRequest;

public class UserRequestMapper implements RequestMapper<UserDTO> {
    @Override
    public UserDTO getDTO(HttpServletRequest request) {
        return UserDTO.builder()
                .fullName(RequestMapperUtil.getStringParam(request, ServletConstants.USER_FULL_NAME_PARAM))
                .birthDate(RequestMapperUtil.getDateParam(request, ServletConstants.USER_BIRTHDATE_PARAM))
                .gender(Gender.valueOf(RequestMapperUtil.getStringParam(request, ServletConstants.USER_GENDER_PARAM)))
                .email(RequestMapperUtil.getStringParam(request, ServletConstants.USER_EMAIL_PARAM))
                .height(RequestMapperUtil.getFloatParam(request, ServletConstants.USER_HEIGHT_PARAM))
                .weight(RequestMapperUtil.getFloatParam(request, ServletConstants.USER_WEIGHT_PARAM))
                .activity(Activity.valueOf(
                        RequestMapperUtil.getStringParam(request, ServletConstants.USER_ACTIVITY_PARAM)))
                .goal(Goal.valueOf(
                        RequestMapperUtil.getStringParam(request, ServletConstants.USER_GOAL_PARAM)))
                .build();
    }
}
