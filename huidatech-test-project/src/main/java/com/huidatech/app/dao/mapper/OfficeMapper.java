package com.huidatech.app.dao.mapper;


public interface OfficeMapper {

	/**
	 * 根据用户实体的officeId获得所属单位coopName(合作社名称)
	 * */
	public String getOfficeNameByOfficeId(String officeId);
}
