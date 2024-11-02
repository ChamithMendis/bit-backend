package com.bit.backend.services;

import com.bit.backend.dtos.CommonDataDto;
import com.bit.backend.dtos.CommonDataListDto;

import java.util.List;

public interface CommonDataServiceI {
    List<CommonDataDto> getAvailablePrivilegesByGroupID(int id);
    List<CommonDataDto> getAssignedPrivilegesByGroupID(int id);
    CommonDataListDto saveData(int id, CommonDataListDto commonDataListDto);
}
