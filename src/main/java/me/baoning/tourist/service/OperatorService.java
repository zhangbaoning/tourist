package me.baoning.tourist.service;

import me.baoning.tourist.dao.OperatorDao;
import me.baoning.tourist.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;

/**
 * Operator业务层
 * @author qyn
 * 
 */
@Service
public class OperatorService implements Serializable{
	@Autowired private OperatorDao operatorDao;

    /**
     * 后台登陆操作
     * @param opname
     * @param oppwd
     * @return
     * @throws IOException
     */
	public Operator login(String opname, String oppwd) throws IOException {

		Operator operator=operatorDao.findByOpname(opname);
		if(operator==null||!oppwd.equals(operator.getOppwd())){
			return null;
		}
		return operator;
	}
}
