package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.SysLog;

import java.util.List;

public interface SysLogDao {
    public void save(SysLog sysLog);

    List<SysLog> findAll();
}
