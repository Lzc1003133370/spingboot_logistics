package com.entor.service.impl;

import com.entor.entity.Member;
import com.entor.mapper.MemberMapper;
import com.entor.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
