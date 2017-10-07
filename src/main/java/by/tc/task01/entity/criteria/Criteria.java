package by.tc.task01.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Criteria<E> {

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public List<String> getListCriteria() {
		Set<Map.Entry<E, Object>> entries = criteria.entrySet();
		List<String> list = new ArrayList<>();
		for (Map.Entry<E, Object> entry : entries) {
			list.add(entry.getKey() + "=" + entry.getValue());
		}
		return list;
	}
}
