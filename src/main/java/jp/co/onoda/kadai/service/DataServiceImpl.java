package jp.co.onoda.kadai.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.onoda.kadai.db.DataAccessor;
import jp.co.onoda.kadai.form.DataForm;

@Service
public class DataServiceImpl implements DataService {

	final static Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

	@Autowired
	DataAccessor accessor;

	@Override
	public void create(DataForm eventdata){
		logger.info("create start: {}", eventdata);
		int updateCount = accessor.insertEventInfo(
				eventdata.getEventName(), eventdata.getEventDate(), eventdata.getRemarks());

		logger.info("create count: {}", updateCount);
	}

}
