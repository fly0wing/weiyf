package ${basePackage}.dao;

<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
import ${basePackage}.model.${className};
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on ${.now}.
 */
@MyBatisRepository
public interface ${className}Dao {

    ${className} get(@Param("id") Long id);

    List<${className}> search(Map<String, Object> params);

    void save(${className} obj);

    void update(${className} obj);

    void delete(@Param("id") Long id);
<#list table.columns as column><#if column.unique && !column.pk>

    ${className} getBy${column.columnName}(@Param("${column.columnNameLower}")${column.simpleJavaType} ${column.columnNameLower});
</#if></#list>
}
