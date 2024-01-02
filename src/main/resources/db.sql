CREATE TABLE property_info (
    property_id SERIAL primary key,
	street_number varchar(10) ,
	street varchar(100),
	property_type varchar(50),
	zipcode int,
	state varchar(2),
	last_sales_date date,
	last_sales_amount int4,
	max_sales_amount int4,
	total_records int4,
	last_modified_date TIMESTAMP default current_timestamp
);