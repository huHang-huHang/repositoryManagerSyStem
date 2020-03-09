package com.dt87.service;

import com.dt87.entity.Provider;

import java.util.List;

public interface ProviderService {
    //查询所有供应商  商品界面用的
    public List<Provider> findAllProvider(Provider provider);
}
