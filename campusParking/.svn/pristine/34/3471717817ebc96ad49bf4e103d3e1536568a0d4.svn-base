package com.cp.service.codeTable;

import java.util.List;
import java.util.Map;

import com.cp.dto.CodeTableDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.search.CodeTableSearchDTO;

public interface CodeTableService {

	boolean addCodeTable(CodeTableDTO codeTableDTO);

	boolean updateCodeTable(CodeTableDTO codeTableDTO);

	boolean deleteCodeTables(String[] ids);

	Map<String, Object> getCodeTable(String id);

	int getCodeTablesCount(CodeTableSearchDTO ctsDTO);

	List<Map<String, Object>> getCodeTables(LimitShowDTO limitShowDTO, CodeTableSearchDTO ctsDTO);
}
