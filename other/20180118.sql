DROP VIEW v_statistics_bills_result_by_type;
DROP VIEW v_statistics_bills_result;
DROP VIEW v_bill_d_back;

CREATE OR REPLACE VIEW v_bill_d_back AS 
 SELECT t7.pro_name,t7.dept_id,t5.s_value AS bank_name, t4.s_value AS search_par_name, t1.account_name, 
    t6.dept_name, t6.dept_type, t6.type_name, t3.s_value AS business_name, t7.download_dat,
    t2.bill_uuid, t2.detail_uuid, t2.bank_code, t2.business_code, 
    t2.search_par_code, t2.search_par_value, t2.effective, t2.un_effective_dat, t9.name as download_user_name,
    t2.un_effective_userid, t2.create_userid, 
    t2.create_dat AS bill_d_create_dat, t1.account_id, t1.detail_count, 
    t1.custom_id, t7.create_dat AS bill_m_create_dat, 
        CASE
            WHEN t2.business_code = '0001'::bpchar THEN 1
            ELSE 0
        END AS public_count, 
        CASE
            WHEN t2.business_code = '0002'::bpchar THEN 1
            ELSE 0
        END AS private_count, 
        CASE
            WHEN t2.business_code = '0001'::bpchar THEN t1.detail_count
            ELSE 0::numeric
        END AS public_detail, 
        CASE
            WHEN t2.business_code = '0002'::bpchar THEN t1.detail_count
            ELSE 0::numeric
        END AS private_detail, 
    t8.name AS create_user_name, t8.id AS download_user_id
   FROM v_sys_dept t6, bill_d_back t1, bill_d t2, sys_code t3, sys_code t4, 
    sys_code t5, bill_m t7, sys_user t8,sys_user t9
  WHERE t1.bill_uuid = t2.bill_uuid AND t1.detail_uuid = t2.detail_uuid AND t2.business_code = t3.s_code::bpchar AND t3.s_id::text = 'business_code'::text 
  AND t4.s_id::text = 'search_par_code'::text AND t4.s_code::bpchar = t2.search_par_code 
  AND t5.s_id::text = 'bank_code'::text AND t5.s_code::bpchar = t2.bank_code AND t6.dept_uuid = t7.dept_id AND t7.bill_uuid = t2.bill_uuid AND t8.id = t7.create_user_id and t9.id=t7.download_user_id;




CREATE OR REPLACE VIEW v_statistics_bills_result AS 
 SELECT t.dept_id, t.dept_type, t.dept_name, t.bill_m_create_dat as create_dat, t.bill_uuid, 
    array_to_string(group_concat(t.bank_name), ','::text) AS bank_names, 
    sum(t.public_count) as public_count, sum(t.private_count) as private_count
    , sum(t.public_detail) as public_detail, sum(t.private_detail) as private_detail, 
    t.pro_name, t.download_user_name, t.download_user_id, t.download_dat, 
    t.type_name
   FROM v_bill_d_back t
  GROUP BY t.dept_id, t.dept_name, t.dept_type, t.bill_m_create_dat, t.bill_uuid, t.public_count,  t.pro_name, t.download_user_name, t.download_user_id, t.download_dat, t.type_name;



CREATE OR REPLACE VIEW v_statistics_bills_result_by_type AS 
 SELECT sum(v_statistics_bills_result.public_count) AS public_count, 
    sum(v_statistics_bills_result.private_count) AS private_count, 
    sum(v_statistics_bills_result.public_detail) AS public_detail, 
    sum(v_statistics_bills_result.private_detail) AS private_detail, 
    v_statistics_bills_result.dept_type, v_statistics_bills_result.type_name, 
    v_statistics_bills_result.dept_name, 
    to_date(to_char(v_statistics_bills_result.create_dat, 'YYYY-MM-DD'::text), 'YYYY-MM-DD'::text) AS create_date
   FROM v_statistics_bills_result
  GROUP BY to_date(to_char(v_statistics_bills_result.create_dat, 'YYYY-MM-DD'::text), 'YYYY-MM-DD'::text), v_statistics_bills_result.dept_type, v_statistics_bills_result.type_name, v_statistics_bills_result.dept_name;



update menu_m set menu_name='数据追踪',"desc"='跟踪疑点数据流向' where menu_id='0003';
update menu_d set menu_d_name='区县处室查询数据流向追踪',menu_d_js_method='search_data_route'
,menu_d_js_url='../route/search_data_route_init.action',web_attention_tips='查询数据的流向' where menu_id='0003' and menu_d_id='0001';

