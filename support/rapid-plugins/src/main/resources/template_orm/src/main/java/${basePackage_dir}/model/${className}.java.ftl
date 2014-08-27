package ${basePackage}.model;

<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.billing.utils.date.DateConvertUtils;
${gg.setOverride(true)}
/**
 * Created by gencode on ${.now}.
 */
public class ${className} implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    <#list table.columns as column>
    /**
     * db_column: ${column.sqlName}
    <#if (column.remarks?length > 0) >
     * remarks from db:${column.remarks}
    </#if>
     */
    private ${column.simpleJavaType} ${column.columnNameLower};
    </#list>

    <@generateConstructor className/>
    <@generateJavaColumns/>
    <@generateJavaOneToMany/>
    <@generateJavaManyToOne/>

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            <#list table.pkColumns as column>
            .append(get${column.columnName}())
            </#list>
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof ${className} == false) return false;
        if(this == obj) return true;
        ${className} other = (${className})obj;
        return new EqualsBuilder()
            <#list table.pkColumns as column>
            .append(get${column.columnName}(),other.get${column.columnName}())
            </#list>
            .isEquals();
    }

}