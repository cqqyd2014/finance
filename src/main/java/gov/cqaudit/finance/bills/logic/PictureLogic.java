package gov.cqaudit.finance.bills.logic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;

import org.hibernate.Session;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

public class PictureLogic {
	 private static  String CHARSET = "utf-8";  
	    private static  int BLACK = 0xFF000000;  
	    private static  int WHITE = 0xFFFFFFFF;  
	
	
	public static String decode_barcode(byte[] bytes) {  
		
		

		
		
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);    //将b作为输入流；
		
		  
        
        try {  
            
        	BufferedImage image = ImageIO.read((InputStream)in);     //将in作为输入流，读取图片存入image中，而这里in可以为ByteArrayInputStream();
        	LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();  
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码  
  
            return result.getText();  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }  
	
	
	
	public static gov.cqaudit.finance.bills.model.Picture getModelFromView(gov.cqaudit.finance.hibernate.entites.VPicture vp){
		gov.cqaudit.finance.bills.model.Picture p=new gov.cqaudit.finance.bills.model.Picture();
		p.setBin_data(vp.getId().getBinData());
		p.setContent_type(vp.getId().getFileType());
		p.setEffective(vp.getId().getEffective());
		p.setFile_name(vp.getId().getFileName());
		p.setLength(vp.getId().getFileLength());
		p.setOp_dat(vp.getId().getOpDat());
		p.setUser_id(vp.getId().getUserId());
		p.setUser_name(vp.getId().getUserName());
		p.setUuid(vp.getId().getUuid());
		p.setBill_uuid(vp.getId().getBillUuid());
		return p;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VPicture> vps){
		java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> ps=new java.util.ArrayList<>();
		for (int i=0;i<vps.size();i++) {
			gov.cqaudit.finance.bills.model.Picture p=getModelFromView(vps.get(i));
			ps.add(p);
		}
		return ps;
	}
	
	public static void save(Session session,gov.cqaudit.finance.bills.model.Picture p) {
		gov.cqaudit.finance.hibernate.entites.Picture p_h=new gov.cqaudit.finance.hibernate.entites.Picture();
		p_h.setBillUuid(p.getBill_uuid());
		p_h.setBinData(p.getBin_data());
		p_h.setEffective(p.isEffective());
		p_h.setFileLength(p.getLength());
		p_h.setFileName(p.getFile_name());
		p_h.setFileType(p.getContent_type());
		p_h.setOpDat(p.getOp_dat());
		p_h.setUserId(p.getUser_id());
		p_h.setUuid(p.getUuid());
		session.saveOrUpdate(p_h);
	}
}
