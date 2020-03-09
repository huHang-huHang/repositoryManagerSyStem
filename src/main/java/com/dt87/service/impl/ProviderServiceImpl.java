package com.dt87.service.impl;

import com.dt87.entity.Provider;
import com.dt87.mapper.ProviderMapper;
import com.dt87.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProviderServiceImpl implements ProviderService {
    @Resource
    private ProviderMapper providerMapper;
    //查询所有供应商 上面界面用
    public List<Provider> findAllProvider(Provider provider) {
        return providerMapper.findAllProvider(provider);
    }

}
