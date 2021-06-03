package top.knpf.dao.b.dbconf.handler;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;

@MappedJdbcTypes(JdbcType.NVARCHAR)
public class ArrayTypeHandler  extends BaseTypeHandler<String[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        Connection conn = preparedStatement.getConnection();
        String str = ArrayUtil.join(parameter, ",");
        preparedStatement.setString(i, str);
    }

    @Override
    public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getStringArray(rs.getString(columnName));
    }

    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getStringArray(rs.getString(columnIndex));
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getStringArray(cs.getString(columnIndex));
    }

    private String[] getStringArray(String str) {

        if(StrUtil.isBlank(str)){
            return null;
        }

        try {
            return StrUtil.splitToArray(str, ',');
        } catch (Exception e) {
        }

        return null;
    }
}
