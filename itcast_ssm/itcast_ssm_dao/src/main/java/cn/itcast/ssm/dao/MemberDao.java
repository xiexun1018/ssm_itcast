package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;

public interface MemberDao {
    Member findById(String id);
}
