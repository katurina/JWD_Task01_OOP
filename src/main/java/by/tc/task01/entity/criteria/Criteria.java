package by.tc.task01.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Criteria<E> {

	private Map<E, Object> criteria = new HashMap<>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public List<String> getCriteriaList() {
		Set<Map.Entry<E, Object>> entries = criteria.entrySet();
		List<String> list = new ArrayList<>();
		for (Map.Entry<E, Object> entry : entries) {
			list.add(entry.getKey() + "=" + entry.getValue());
		}
		return list;
	}

	public String getParamClassName() {
		for (E e : criteria.keySet()) {
			String classParam = e.getClass().getCanonicalName();
			return classParam.substring(classParam.lastIndexOf('.') + 1, classParam.length());
		}
		return null;
	}

	public Map<E, Object> getCriteria() {
		return criteria;
	}

}
