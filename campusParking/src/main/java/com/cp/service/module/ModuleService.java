package com.cp.service.module;

import java.util.List;
import java.util.Map;

import com.cp.dto.LimitShowDTO;
import com.cp.dto.ModuleDTO;
import com.cp.dto.search.ModuleSearchDTO;

public interface ModuleService {

	boolean addModule(ModuleDTO moduleDTO);

	boolean updateModule(ModuleDTO moduleDTO);

	boolean deleteModules(String[] ids);

	Map<String, Object> getModule(String id);

	List<Map<String, Object>> getModules(LimitShowDTO limitShowDTO, ModuleSearchDTO msDTO);

	int getModulesCount(ModuleSearchDTO msDTO);

	List<Map<String, Object>> getMenu(int i, int j);

}
