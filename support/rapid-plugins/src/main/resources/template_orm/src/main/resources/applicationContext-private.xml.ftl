<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">


    <!-- 自动加载构建bean -->
    <context:annotation-config />

    <context:component-scan base-package="com.billing.product.orm">
        <context:include-filter type="annotation" expression="com.billing.utils.mybatis.MyBatisRepository"/>
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
    </context:component-scan>

    <!-- 扫描basePackage下所有以@MyBatisRepository标识的 接口-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.billing" />
        <property name="annotationClass" value="com.billing.utils.mybatis.MyBatisRepository"/>
    </bean>
</beans>