package com.hand.infra.util;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

@Intercepts(
        {@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
                @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
                @Signature(type = StatementHandler.class, method = "batch", args = { Statement.class })}
)
public class SqlStatementInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            long endTime = System.currentTimeMillis();

            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();
            sql = sql.replace("\n", "").replace("\t", "").replaceAll("\\s+", " ");
            System.out.println("执行SQL: "+sql+"花费"+(endTime - startTime)+"ms");

        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}