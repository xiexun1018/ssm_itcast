package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog);
    List<SysLog> findAll();
}
