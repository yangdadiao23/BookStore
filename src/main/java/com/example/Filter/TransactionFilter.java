package com.example.Filter;

import Variety.utils.jdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
            jdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            jdbcUtils.RollbackAndClose();
            throw  new RuntimeException(e);
        }
    }
}
