package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.SysLogDao;
import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/16
 * @time:10:29
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
