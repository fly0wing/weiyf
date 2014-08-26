<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 ${gg.setOverride(false)}
<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro namespace>${className}_</#macro>
<mapper namespace="${basePackage}.dao.${className}Dao">

</mapper>