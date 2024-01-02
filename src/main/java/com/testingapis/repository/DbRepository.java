package com.testingapis.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.testingapis.model.PropertyData;
import com.testingapis.model.PropertyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DbRepository {

    @Autowired
    private DataSource dataSource;
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;

    public int[] insertRealEstateData(List<PropertyData> propertyData) {
        String sql = "insert into property_info " +
                "(street_number, street, property_type, zipcode, state, last_sales_date, last_sales_amount, " +
                "max_sales_amount, total_records) " +
                " values(:snum, :street, :property_type, :zip_code, :state, :last_sales_date, :last_sales_amt, " +
                ":max_sales_amt, :total_records)";

        List<MapSqlParameterSource> paramSources = new ArrayList<MapSqlParameterSource>();

        for (PropertyData rec : propertyData) {
            MapSqlParameterSource paramSource = new MapSqlParameterSource();
            paramSource.addValue("snum", rec.getId().getStreetNumber());
            paramSource.addValue("street", rec.getId().getStreet());
            paramSource.addValue("property_type", rec.getId().getPropertyType());
            paramSource.addValue("zip_code", Integer.valueOf(rec.getId().getZipcode()));
            paramSource.addValue("state", rec.getId().getState());
            paramSource.addValue("last_sales_date", rec.getLastSalesDate());
            paramSource.addValue("last_sales_amt", rec.getLastSalesAmount());
            paramSource.addValue("max_sales_amt", rec.getMaxSalesAmount());
            paramSource.addValue("total_records", rec.getTotalRecords());
            paramSources.add(paramSource);
        }
        return namedParameterJdbcTemplate.batchUpdate(sql, paramSources.toArray(new MapSqlParameterSource[paramSources.size()]));
    }

    public List<PropertyData> getRealEstateData(List<PropertyData> propertyData) {
        String sql = "select * from property_info";
        namedParameterJdbcTemplate.query(sql,)
    }
}

