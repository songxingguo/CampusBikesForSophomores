package com.cp.service.operator;

import java.util.List;
import java.util.Map;

import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.OperatorDTO;
import com.cp.dto.search.OperatorSearchDTO;

public interface OperatorService {

	boolean addOperator(OperatorDTO operatorDTO, String userId);

	boolean updateOperator(OperatorDTO operatorDTO);

	Map<String, Object> getOperator(String id);

	boolean deleteOperators(String[] ids);

	List<Map<String, Object>> getOperators(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			OperatorSearchDTO osDTO);

	int getOperatorsCount(LoginInfoDTO loginInfoDTO, OperatorSearchDTO osDTO);
}
