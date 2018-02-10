package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DataCorePublicAccountTradeDetail generated by hbm2java
 */
@Entity
@Table(name = "data_core_public_account_trade_detail", schema = "public")
public class DataCorePublicAccountTradeDetail implements java.io.Serializable {

	private DataCorePublicAccountTradeDetailId id;
	private BigDecimal publicAmount;
	private String publicOpAccountId;
	private String publicOpBankId;
	private String publicOpBankName;
	private String publicOpAccountName;
	private String publicTradeCode;
	private String publicTradeName;
	private BigDecimal publicBalance;
	private String publicBankOrgId;
	private String publicBankOrgName;
	private String publicRemark;
	private String publicAccountName;

	public DataCorePublicAccountTradeDetail() {
	}

	public DataCorePublicAccountTradeDetail(DataCorePublicAccountTradeDetailId id) {
		this.id = id;
	}

	public DataCorePublicAccountTradeDetail(DataCorePublicAccountTradeDetailId id, BigDecimal publicAmount,
			String publicOpAccountId, String publicOpBankId, String publicOpBankName, String publicOpAccountName,
			String publicTradeCode, String publicTradeName, BigDecimal publicBalance, String publicBankOrgId,
			String publicBankOrgName, String publicRemark, String publicAccountName) {
		this.id = id;
		this.publicAmount = publicAmount;
		this.publicOpAccountId = publicOpAccountId;
		this.publicOpBankId = publicOpBankId;
		this.publicOpBankName = publicOpBankName;
		this.publicOpAccountName = publicOpAccountName;
		this.publicTradeCode = publicTradeCode;
		this.publicTradeName = publicTradeName;
		this.publicBalance = publicBalance;
		this.publicBankOrgId = publicBankOrgId;
		this.publicBankOrgName = publicBankOrgName;
		this.publicRemark = publicRemark;
		this.publicAccountName = publicAccountName;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", nullable = false, length = 4)),
			@AttributeOverride(name = "publicAccountId", column = @Column(name = "public_account_id", nullable = false, length = 128)),
			@AttributeOverride(name = "publicTradeSeq", column = @Column(name = "public_trade_seq", nullable = false, length = 128)),
			@AttributeOverride(name = "publicTradeDat", column = @Column(name = "public_trade_dat", nullable = false, length = 35)) })
	public DataCorePublicAccountTradeDetailId getId() {
		return this.id;
	}

	public void setId(DataCorePublicAccountTradeDetailId id) {
		this.id = id;
	}

	@Column(name = "public_amount", precision = 131089, scale = 0)
	public BigDecimal getPublicAmount() {
		return this.publicAmount;
	}

	public void setPublicAmount(BigDecimal publicAmount) {
		this.publicAmount = publicAmount;
	}

	@Column(name = "public_op_account_id", length = 128)
	public String getPublicOpAccountId() {
		return this.publicOpAccountId;
	}

	public void setPublicOpAccountId(String publicOpAccountId) {
		this.publicOpAccountId = publicOpAccountId;
	}

	@Column(name = "public_op_bank_id", length = 128)
	public String getPublicOpBankId() {
		return this.publicOpBankId;
	}

	public void setPublicOpBankId(String publicOpBankId) {
		this.publicOpBankId = publicOpBankId;
	}

	@Column(name = "public_op_bank_name", length = 256)
	public String getPublicOpBankName() {
		return this.publicOpBankName;
	}

	public void setPublicOpBankName(String publicOpBankName) {
		this.publicOpBankName = publicOpBankName;
	}

	@Column(name = "public_op_account_name", length = 256)
	public String getPublicOpAccountName() {
		return this.publicOpAccountName;
	}

	public void setPublicOpAccountName(String publicOpAccountName) {
		this.publicOpAccountName = publicOpAccountName;
	}

	@Column(name = "public_trade_code", length = 128)
	public String getPublicTradeCode() {
		return this.publicTradeCode;
	}

	public void setPublicTradeCode(String publicTradeCode) {
		this.publicTradeCode = publicTradeCode;
	}

	@Column(name = "public_trade_name", length = 256)
	public String getPublicTradeName() {
		return this.publicTradeName;
	}

	public void setPublicTradeName(String publicTradeName) {
		this.publicTradeName = publicTradeName;
	}

	@Column(name = "public_balance", precision = 131089, scale = 0)
	public BigDecimal getPublicBalance() {
		return this.publicBalance;
	}

	public void setPublicBalance(BigDecimal publicBalance) {
		this.publicBalance = publicBalance;
	}

	@Column(name = "public_bank_org_id", length = 64)
	public String getPublicBankOrgId() {
		return this.publicBankOrgId;
	}

	public void setPublicBankOrgId(String publicBankOrgId) {
		this.publicBankOrgId = publicBankOrgId;
	}

	@Column(name = "public_bank_org_name", length = 128)
	public String getPublicBankOrgName() {
		return this.publicBankOrgName;
	}

	public void setPublicBankOrgName(String publicBankOrgName) {
		this.publicBankOrgName = publicBankOrgName;
	}

	@Column(name = "public_remark", length = 2048)
	public String getPublicRemark() {
		return this.publicRemark;
	}

	public void setPublicRemark(String publicRemark) {
		this.publicRemark = publicRemark;
	}

	@Column(name = "public_account_name", length = 256)
	public String getPublicAccountName() {
		return this.publicAccountName;
	}

	public void setPublicAccountName(String publicAccountName) {
		this.publicAccountName = publicAccountName;
	}

}
