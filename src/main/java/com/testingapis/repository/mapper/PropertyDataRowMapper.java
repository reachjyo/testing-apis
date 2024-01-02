package com.testingapis.repository.mapper;

import com.testingapis.model.PropertyData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyDataRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new PropertyData(
                rs.getString("property_id"),
                rs.getDate("last_sales_date"),
                rs.getInt("last_sales_amount"),
                rs.getInt("max_sales_amount"),
                rs.getInt("total_records"));
    }
}
