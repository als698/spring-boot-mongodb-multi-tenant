package com.example.tenant.interceptor;

import com.example.tenant.database.ConnectionStorage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TenantFilter extends OncePerRequestFilter {

    private static final String TENANT_HEADER = "X-Tenant";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017/TENANT?readPreference=primary";
    private static final String TENANT_REPLACEMENT = "TENANT";

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String tenantHeader = request.getHeader(TENANT_HEADER);
        if (tenantHeader == null || tenantHeader.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            String dbConnectionString = CONNECTION_STRING.replace(TENANT_REPLACEMENT, tenantHeader);

            ConnectionStorage.setConnection(dbConnectionString);

            filterChain.doFilter(request, response);

            ConnectionStorage.clear();
        }
    }

}