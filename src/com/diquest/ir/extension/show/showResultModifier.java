package com.diquest.ir.extension.show;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.diquest.ir.common.exception.IRException;
import com.diquest.ir.common.msg.protocol.Protocol;
import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.SelectSet;
import com.diquest.ir.common.msg.protocol.result.Result;
import com.diquest.ir.server.extension.IResultModifier;

public class showResultModifier implements IResultModifier{

	public showResultModifier() {
	}
	
	public void modify(Query query, Result result) throws IRException {
		
		String showStr = query.getUserName()==null ? "" : new String(query.getUserName());
		String lanStr = query.getExtData()==null ? "" : new String(query.getExtData());
		
		System.out.println("##IResultModifier##");
		System.out.println("showStr==" + showStr);
		System.out.println("lanStr==" + lanStr);
		System.out.println("###################");
		
		char[][][] showResult = result.getResults();
		
//		new SelectSet("V_CASE_ID", Protocol.SelectSet.NONE),				// 0
//		new SelectSet("V_IMG_PATH", Protocol.SelectSet.NONE),				// 1
//		new SelectSet("V_ORG_IMG_PATH", Protocol.SelectSet.NONE),			// 2
//		new SelectSet("V_TITLE", Protocol.SelectSet.NONE),					// 3
//		new SelectSet("V_INTRO", Protocol.SelectSet.NONE),				// 4
//		new SelectSet("V_STYLE", Protocol.SelectSet.NONE),				// 5
//		new SelectSet("N_INQ_CNT", Protocol.SelectSet.NONE),				// 6
//		new SelectSet("N_LIKE_CNT", Protocol.SelectSet.NONE),				// 7
//		new SelectSet("V_REG_USERID", Protocol.SelectSet.NONE),				// 8
//		new SelectSet("V_REG_DTM", Protocol.SelectSet.NONE),				// 9
//		new SelectSet("V_FLAG_SCRAP", Protocol.SelectSet.NONE),				// 10
//		new SelectSet("V_FLAG_MINE", Protocol.SelectSet.NONE),				// 11
//		new SelectSet("V_CATEGORY_TYPENM", Protocol.SelectSet.NONE),				// 12
//		new SelectSet("V_STYLENM", Protocol.SelectSet.NONE)					// 13
		
		int scrapIdx = 10;
		int mineIdx = 11;
		int typeIdx = 12;
		int styleIdx = 13;
		
		String scrapYn = "N";
		String scrap = "";
		String mineYn = "N";
		String mine = "";
		String typeYn = "ko";
		
		String[] arr_s = null;
		String[] arr_m = null;
//		String[] arr_t = null;
		
		for (int i = 0; i < showResult.length; i++) {

			try {
				
				scrap = String.valueOf(showResult[i][scrapIdx]);	// V_FLAG_SCRAP
				mine = String.valueOf(showResult[i][mineIdx]);	// V_FLAG_MINE
//				type = String.valueOf(showResult[i][typeIdx]);	// V_CATEGORY_TYPENM
				
				arr_s = scrap.split(",");
				arr_m = mine.split(",");
//				arr_t = mine.split(",");
				
				scrapYn = "N";
				mineYn = "N";
				typeYn = "ko";
				
				if (showStr.equals("")) {
					scrapYn = "N";
					mineYn = "N";
				} else {
					for (int j=0; j<arr_s.length; j++) {
						if (showStr.equals(arr_s[j])) {
							scrapYn = "Y";
						}
					}
					for (int k=0; k<arr_m.length; k++) {
						if (showStr.equals(arr_m[k])) {
							mineYn = "Y";
						}
					}
				}
				
				if (lanStr.equals("")) {
					typeYn = "ko";
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			showResult[i][scrapIdx] = scrapYn.toCharArray();
			showResult[i][mineIdx] = mineYn.toCharArray();
			if (lanStr.equals("")) {
				showResult[i][typeIdx] = typeYn.toCharArray();
				showResult[i][styleIdx] = typeYn.toCharArray();
			}
		}
		
	}

}
