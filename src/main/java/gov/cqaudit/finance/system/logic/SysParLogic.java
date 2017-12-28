package gov.cqaudit.finance.system.logic;

public class SysParLogic {
	public static gov.cqaudit.finance.system.model.SysPar getModelFromEntity(gov.cqaudit.finance.hibernate.entities.SysPar sp_h){
		gov.cqaudit.finance.system.model.SysPar sp=new gov.cqaudit.finance.system.model.SysPar();
		sp.setCode(sp_h.getCode());
		sp.setDesc(sp_h.getCodeDesc());
		sp.setValue(sp_h.getValue());
		java.util.ArrayList<gov.cqaudit.finance.system.model.SysParItem> sp_items=new java.util.ArrayList<>();
		String[] array_items=sp_h.getSelectItems().split(",");
		for (int i=0;i<array_items.length;i++) {
			sp_items.add(new gov.cqaudit.finance.system.model.SysParItem(array_items[i]));
		}
		sp.setItems(sp_items);
		return sp;
	}

}
