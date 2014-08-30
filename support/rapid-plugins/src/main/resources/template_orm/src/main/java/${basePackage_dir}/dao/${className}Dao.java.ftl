package ${basePackage}.dao;

<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
import ${basePackage}.model.${className};
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
${gg.setOverride(false)}
/**
 * Created by gencode on ${.now}.
 */
@MyBatisRepository
public interface ${className}Dao {

    ${className} get(<#list table.pkColumns as column>@Param(${className}.FN_${column.columnNameLower}) ${column.simpleJavaType} ${column.columnNameFirstLower}<#if column_has_next>, </#if></#list>);

    List<${className}> search(Map<String, Object> params);

    boolean save(${className} obj);

    boolean update(${className} obj);

    boolean delete(@Param("id") Long id);
<#list table.columns as column><#if column.unique && !column.pk>

    ${className} getBy${column.columnName}(@Param(${className}.FN_${column.columnNameLower})${column.simpleJavaType} ${column.columnNameLower});
</#if></#list>
}
