package com.huidatech.app.dao.mapper;



import java.util.List;

public interface MaterialMapper {

//	选择物资名称：用可以模糊查询的下拉单选控件，查询范围，该所属单位下的农资
//
//	参数：
//
//	第一个过滤条件： 所属的单位
//	-> 根据用户得到所属单位id
//	-> 结合所属单位id 和 物资ID 决定该单位下的物资有哪些
//
//	第二个过滤条件：  所属物资类型
	List<String> getMaterialNameByMaterialTypeAndOffice();
}
