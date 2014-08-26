<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro namespace>${className}.</#macro>

<mapper namespace="${basePackage}.dao.${className}Dao">


    <!-- 字段名转换 -->
    <resultMap id="RM.${className}" type="${basepackage}.model.${className}">
    <#list table.columns as column>
        <result property="${column.columnNameLower}" column="${column.sqlName}"/>
    </#list>
    </resultMap>

    <!-- 查询字段 -->
    <sql id="<@namespace/>columns">
        <![CDATA[
    <#list table.columns as column>${column.sqlName}<#if column_has_next>,</#if></#list>
        ]]>
    </sql>


    <select id="get" parameterType="long" resultType="RM.${className}">
        <![CDATA[
        select
        <include refid="<@namespace/>columns" />
        from ${table.sqlName}
        WHERE
        <#list table.compositeIdColumns as column>
            <if test="@Ognl@isNotEmpty(${column.columnNameLower})">
                1 = 0 AND
            </if>
            ${column.sqlName} = <@mapperEl column.columnNameLower/> <#if column_has_next> AND </#if>
        </#list>
        ]]>
    </select>

    <!-- 查询用户,演示: 1.输入用map传入多个参数 2.<where>语句, 智能添加where和and关键字 3.输出直接映射对象 -->
    <select id="search" parameterType="map" resultType="RM.${className}">
        <![CDATA[
        select
        <include refid="<@namespace/>columns" />
        from ${table.sqlName}
        <where>
            <#list table.columns as column>
                <#if column.isDateTimeColumn>
                    <if test="@Ognl@isNotEmpty(${column.columnNameFirstLower}Begin)">
            AND ${column.sqlName} >= <@mapperEl column.columnNameFirstLower+"Begin"/>
                    </if>
                    <if test="@Ognl@isNotEmpty(${column.columnNameFirstLower}End)">
            AND ${column.sqlName} &lt;= <@mapperEl column.columnNameFirstLower+"End"/>
                    </if>
                <#else>
                    <if test="@Ognl@isNotEmpty(${column.columnNameFirstLower})">
            AND ${column.sqlName} = <@mapperEl column.columnNameFirstLower/>
                    </if>
                </#if>
            </#list>
        </where>
        ]]>
    </select>

    <!-- 插入 -->
    <insert id="save" parameterType="${basepackage}.model.${className}" useGeneratedKeys="true" keyProperty="${table.idColumn.columnNameFirstLower}">
        <![CDATA[
        INSERT INTO ${table.sqlName} (
            <#list table.columns as column> ${column.sqlName}<#if column_has_next>,</#if></#list>
        ) VALUES (
            <#list table.columns as column> <@mapperEl column.columnNameFirstLower/><#if column_has_next>,</#if></#list>
        )
        ]]>
    </insert>

    <delete id="delete">
        <![CDATA[
        DELETE FROM ${table.sqlName} WHERE
    <#list table.compositeIdColumns as column>
        ${column.sqlName} = <@mapperEl column.columnNameFirstLower/> <#if column_has_next> AND </#if>
    </#list>
        ]]>
    </delete>

    <update id="update" >
        <![CDATA[
        UPDATE ${table.sqlName} SET
    <#list table.notPkColumns as column>${column.sqlName} = <@mapperEl column.columnNameFirstLower/> <#if column_has_next>,</#if> </#list>
        WHERE
    <#list table.compositeIdColumns as column>${column.sqlName} = <@mapperEl column.columnNameLower/> <#if column_has_next> AND </#if> </#list>
        ]]>
    </update>

    <#list table.columns as column>
        <#if column.unique && !column.pk>
    <select id="<@namespace/>getBy${column.columnName}" resultMap="RM.${className}" parameterType="${column.javaType}">
        SELECT <include refid="<@namespace/>columns"/>
        FROM ${table.sqlName} where ${column.sqlName} = <@mapperEl column.columnNameLower/>
    </select>

        </#if>
    </#list>
</mapper>