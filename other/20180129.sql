alter table bill_d add  start_dat  timestamp with time zone;
alter table bill_d add  end_dat  timestamp with time zone;
update bill_d set start_dat='2013-1-1 00:00:00',end_dat=t2.create_dat from bill_m t2 where bill_d.bill_uuid=t2.bill_uuid;


DROP VIEW v_bill_d;

CREATE OR REPLACE VIEW v_bill_d AS 
 SELECT t1.start_dat,t1.end_dat,t1.effective, t1.un_effective_dat, t1.un_effective_userid, 
    t1.create_dat, t1.create_userid, t1.bill_uuid, t1.detail_uuid, t1.bank_code, 
    t1.business_code, t1.search_par_code, t1.search_par_value, 
    t2.s_value AS bank_name, t3.s_value AS business_name, 
    t4.s_value AS search_par_name
   FROM bill_d t1, sys_code t2, sys_code t3, sys_code t4
  WHERE t1.bank_code = t2.s_code::bpchar AND t2.s_id::text = 'bank_code'::text AND t1.business_code = t3.s_code::bpchar AND t3.s_id::text = 'business_code'::text AND t1.search_par_code = t4.s_code::bpchar AND t4.s_id::text = 'search_par_code'::text;


alter table data_core_private_account_info add timepoint timestamp with time zone;
alter table data_core_public_account_info add timepoint timestamp with time zone;

update data_core_private_account_info set timepoint='2018-01-01';
update data_core_public_account_info set timepoint='2018-01-01';


DROP VIEW v_data_core_private_account_info;

CREATE OR REPLACE VIEW v_data_core_private_account_info AS 
 SELECT data_core_private_account_info.private_account_id, timepoint,
    data_core_private_account_info.private_account_name, 
    data_core_private_account_info.private_custom_id, 
    data_core_private_account_info.private_card_no, 
    data_core_private_account_info.bank_code, 
    data_core_private_account_info.private_open_dat, 
    data_core_private_account_info.private_close_dat, 
    data_core_private_account_info.private_acount_status
   FROM data_core_private_account_info;


DROP VIEW v_data_core_public_account_info;

CREATE OR REPLACE VIEW v_data_core_public_account_info AS 
 SELECT data_core_public_acount_info.bank_code, 
    data_core_public_acount_info.public_account_id,  timepoint,
    data_core_public_acount_info.public_account_name, 
    data_core_public_acount_info.public_account_status, 
    data_core_public_acount_info.public_open_dat, 
    data_core_public_acount_info.public_close_dat, 
    data_core_public_acount_info.public_custom_id
   FROM data_core_public_account_info data_core_public_acount_info;


insert into menu_d values('0001','0004','待审查询','wait_permit','../bills/all_bills_init.action?bill_status=wait_permit',3,false,'等待许可的申请','#','#','icon_14');

insert into sys_role_menu_d values('manager','0001','0004');

/*
insert into menu_d values('0001','0004','待审查询','wait_permit','../bills/wait_permit_bills_init.action',3,false,'等待许可的申请','#','#','icon_14');

insert into sys_role_menu_d values('manager','0001','0004');
*/

alter table bill_m add if_room boolean;
alter table bill_m add if_output boolean;
update bill_m set if_room=false,if_output=false;


DROP VIEW v_bill_m;

CREATE OR REPLACE VIEW v_bill_m AS 
 SELECT t1.if_room,t1.if_output,t1.bill_type, t6.s_value AS bill_type_name, t1.uneffective_dat, 
    t1.uneffective_user_id, t1.detail_num, t1.pics_num, t0.dept_name, 
    t1.create_user_id, t1.create_dat, t1.bill_status, t1.contract_name, 
    t1.contract_tell, t1.contract_mail, t1.audit_user_id, t1.last_audit_dat, 
    t1.pro_name, t1.bill_uuid, t1.dept_id, t1.last_modify_dat, t1.search_reason, 
    t1.download_user_id, t1.download_dat, t1.download_uuid, t1.effective, 
        CASE
            WHEN t2.name IS NULL THEN ''::character varying
            ELSE t2.name
        END AS create_user_name, 
        CASE
            WHEN t3.name IS NULL THEN ''::character varying
            ELSE t3.name
        END AS audit_user_name, 
        CASE
            WHEN t4.name IS NULL THEN ''::character varying
            ELSE t4.name
        END AS download_user_name, 
        CASE
            WHEN t5.name IS NULL THEN ''::character varying
            ELSE t5.name
        END AS uneffective_user_name
   FROM sys_dept t0, sys_code t6, 
    bill_m t1
   LEFT JOIN sys_user t2 ON t1.create_user_id = t2.id
   LEFT JOIN sys_user t3 ON t1.audit_user_id = t3.id
   LEFT JOIN sys_user t4 ON t1.download_user_id = t4.id
   LEFT JOIN sys_user t5 ON t1.uneffective_user_id = t5.id
  WHERE t0.dept_uuid = t1.dept_id AND t1.bill_type = t6.s_code::bpchar AND t6.s_id::text = 'bill_type'::text;

  alter table sys_user rename id to user_id;

    alter table sys_user rename name to user_name;

  DROP VIEW v_sys_user;

CREATE OR REPLACE VIEW v_sys_user AS 
 SELECT t1.user_id , t1.user_name, t1.create_time, t1.pwd, t1.user_login, 
    t1.tel, t1.effective, t1.online, t1.last_online_time, t1.email, t1.dept_id, 
    t2.dept_name, t3.role_id, t4.role_name
   FROM sys_user t1, sys_dept t2, sys_user_role t3, sys_role t4
  WHERE t1.dept_id = t2.dept_uuid AND t3.user_id::bpchar = t1.user_id AND t4.role_id::text = t3.role_id::text;


  
insert into sys_code values('message_type','消息类型','0001','流程日志');
insert into sys_code values('message_type','消息类型','0002','审核日志');
insert into sys_code values('message_type','消息类型','0003','查看日志');


CREATE TABLE bill_message
(
  message_uuid character(36) NOT NULL,
  bill_uuid character(36),
  message_type character(4),
  create_dat timestamp with time zone,
  ip_addr character varying(32),
  dept_id character(36),
  message character varying(1024),
  create_message_user_id character(36),
  CONSTRAINT pk_bill_message PRIMARY KEY (message_uuid)
)
WITH (
  OIDS=FALSE
);

create view v_bill_message as
select t1.*,t2.user_name,t3.dept_name,t4.s_value message_type_name from bill_message t1,sys_user t2,sys_dept t3,sys_code t4
where t1.create_message_user_id=t2.user_id and t1.dept_id=t3.dept_uuid and t4.s_id='message_type' and t4.s_code=t1.message_type;




update bill_m set bill_status='查看结果' where bill_status='返回待审';


update bill_m set audit_user_id='3c548809-4930-4f7e-903c-53d9ec7473a8' ,last_audit_dat=create_dat ;


DROP VIEW v_bill_d;

CREATE OR REPLACE VIEW v_bill_d AS 
 SELECT t1.start_dat, t1.end_dat, t1.effective, t1.un_effective_dat, 
    t1.un_effective_userid, t1.create_dat, t1.create_userid, t1.bill_uuid, 
    t1.detail_uuid, t1.bank_code, t1.business_code, t1.search_par_code, 
    t1.search_par_value, t2.bank_simple_name as bank_name, t3.s_value AS business_name, 
    t4.s_value AS search_par_name
   FROM bill_d t1, bank_info t2, sys_code t3, sys_code t4
  WHERE t1.bank_code = t2.bank_code::bpchar AND t1.business_code = t3.s_code::bpchar AND t3.s_id::text = 'business_code'::text AND t1.search_par_code = t4.s_code::bpchar AND t4.s_id::text = 'search_par_code'::text;



update sys_code set s_value='对公存款' where s_id='business_code' and s_code='0001';

update sys_code set s_value='对私存款' where s_id='business_code' and s_code='0002';


DROP VIEW v_statistics_bills_result_by_type;




DROP VIEW v_statistics_bills_result;



DROP VIEW v_bill_d_back;

CREATE OR REPLACE VIEW v_bill_d_back AS 
 SELECT t2.start_dat,t2.end_dat,t7.pro_name, t7.dept_id, t5.bank_simple_name AS bank_name, 
    t4.s_value AS search_par_name, t1.account_name, t6.dept_name, t6.dept_type, 
    t6.type_name, t3.s_value AS business_name, t7.download_dat, t2.bill_uuid, 
    t2.detail_uuid, t2.bank_code, t2.business_code, t2.search_par_code, 
    t2.search_par_value, t2.effective, t2.un_effective_dat, 
    t9.user_name AS download_user_name, t2.un_effective_userid, 
    t2.create_userid, t2.create_dat AS bill_d_create_dat, t1.account_id, 
    t1.detail_count, t1.custom_id, t7.create_dat AS bill_m_create_dat, 
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
    t8.user_name AS create_user_name, t8.user_id AS download_user_id
   FROM v_sys_dept t6, bill_d_back t1, bill_d t2, sys_code t3, sys_code t4, 
    bank_info t5, bill_m t7, sys_user t8, sys_user t9
  WHERE t1.bill_uuid = t2.bill_uuid AND t1.detail_uuid = t2.detail_uuid AND t2.business_code = t3.s_code::bpchar AND t3.s_id::text = 'business_code'::text AND t4.s_id::text = 'search_par_code'::text AND t4.s_code::bpchar = t2.search_par_code AND t5.bank_code = t2.bank_code AND t6.dept_uuid = t7.dept_id AND t7.bill_uuid = t2.bill_uuid AND t8.user_id = t7.create_user_id AND t9.user_id = t7.download_user_id;


CREATE OR REPLACE VIEW v_statistics_bills_result AS 
 SELECT t.dept_id, t.dept_type, t.dept_name, t.bill_m_create_dat AS create_dat, 
    t.bill_uuid, 
    array_to_string(group_concat(t.bank_name), ','::text) AS bank_names, 
    sum(t.public_count) AS public_count, sum(t.private_count) AS private_count, 
    sum(t.public_detail) AS public_detail, 
    sum(t.private_detail) AS private_detail, t.pro_name, t.download_user_name, 
    t.download_user_id, t.download_dat, t.type_name
   FROM v_bill_d_back t
  GROUP BY t.dept_id, t.dept_name, t.dept_type, t.bill_m_create_dat, t.bill_uuid, t.public_count, t.pro_name, t.download_user_name, t.download_user_id, t.download_dat, t.type_name;


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

create view v_trans_not_back as
 SELECT t4.bank_code, t4.bill_uuid
   FROM ( SELECT bill_d.bank_code, bill_d.bill_uuid
           FROM bill_d
          GROUP BY bill_d.bank_code, bill_d.bill_uuid) t4
   LEFT JOIN ( SELECT t1.bank_code, t2.bill_uuid
           FROM data_trans_back t1, data_trans_d t2
          WHERE t1.trans_uuid = t2.trans_uuid
          GROUP BY t1.bank_code, t2.bill_uuid) t3 ON (t4.bill_uuid = t3.bill_uuid and t4.bank_code=t3.bank_code)
  WHERE t3.bank_code IS NULL;

  update sys_par set value='重庆市地方金融数据查询管理系统',select_items='重庆市地方金融数据查询管理系统' where code='app_name';
  insert into sys_role_menu_d values('manager','0003','0001');

  