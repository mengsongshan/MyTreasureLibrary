package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IService {

    public HttpServletResponse service(HttpServletRequest req, HttpServletResponse resp);

}
