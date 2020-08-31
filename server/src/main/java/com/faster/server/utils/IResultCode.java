package com.faster.server.utils;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    int getCode();

    String getMsg();
}
