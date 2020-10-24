package com.usecase.service;

import com.usecase.dao.MockDBMapper;
import com.usecase.model.DBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MockServiceImpl {

    @Autowired
    private MockDBMapper mockMapper;

    public int count(DBModel model) {
        return mockMapper.count(model);
    }

    public boolean makeFile(String path) {
        File file = new File(path);
        return file.exists();
    }

    public void remove() {

    }

}
