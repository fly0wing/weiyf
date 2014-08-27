<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:jee="http://www.springframework.org/schema/jee"
       xmlns:tx="http://www.springframework.org/schema/tx" xmlns:mvc="http://www.springframework.org/schema/task"
       xsi:schemaLocation="http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
        http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-4.0.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task.xsd">
<#macro escapeDollar value>${r"${"}${value}}</#macro>
<#macro escapeMapper value>${r"#{"}${value}}</#macro>
${gg.setOverride(false)}
    <!-- 加载数据库属性配置文件 -->
    <context:property-placeholder location="classpath:db-${moduleName}.properties" />

    <!-- 数据库连接池c3p0配置 -->
    <bean id="${moduleName}DataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
          destroy-method="close">
        <property name="jdbcUrl" value="<@escapeDollar  "db.product.url"/>"/>
        <property name="driverClass" value="<@escapeDollar "db.product.driverClassName"/>"/>
        <property name="user" value="<@escapeDollar "db.product.username"/>"/>
        <property name="password" value="<@escapeDollar "db.product.password"/>"/>
        <property name="maxPoolSize" value="<@escapeDollar "db.product.maxPoolSize"/>"/>
        <property name="minPoolSize" value="<@escapeDollar "db.product.minPoolSize"/>"/>
        <property name="initialPoolSize" value="<@escapeDollar "db.product.initialPoolSize"/>"/>
        <property name="maxIdleTime" value="<@escapeDollar "db.product.maxIdleTime"/>"/>
    </bean>

    <bean id="${moduleName}SqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean" primary="true">
        <property name="dataSource" ref="${moduleName}DataSource" />
        <property name="mapperLocations" value="classpath:${moduleName}_mapper/*Mapper.xml" />
        <property name="typeAliasesPackage" value="com.billing.${moduleName}.orm" />
    </bean>

    <bean id="${moduleName}TransactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="${moduleName}DataSource" />
    </bean>
</beans>