package com.diquest.ir.extension.opt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.diquest.ir.common.exception.IRException;
import com.diquest.ir.common.msg.protocol.Protocol;
import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.SelectSet;
import com.diquest.ir.common.msg.protocol.result.Result;
import com.diquest.ir.server.extension.IResultModifier;

public class optResultModifier implements IResultModifier{

	public optResultModifier() {
	}
	
	public void modify(Query query, Result result) throws IRException {
		
		String mnoStr = query.getUserName()==null ? "" : new String(query.getUserName());
		
		System.out.println("##IResultModifier##");
		System.out.println("mnoStr==" + mnoStr);
		System.out.println("###################");
		
		char[][][] optResult = result.getResults();
		
//		new SelectSet("RSLT_PRODUCT_CD", Protocol.SelectSet.NONE),				// 0
//		new SelectSet("RSLT_KINDCD", Protocol.SelectSet.NONE),					// 1
//		new SelectSet("RSLT_SIGONG_KIND", Protocol.SelectSet.NONE),				// 2
//		new SelectSet("RSLT_SIGONG_TYPE", Protocol.SelectSet.NONE),				// 3
//		new SelectSet("RSLT_PRODUCT_NAME", Protocol.SelectSet.HIGHLIGHT),		// 4
//		new SelectSet("RSLT_PRODUCT_MDM", Protocol.SelectSet.HIGHLIGHT),		// 5
//		new SelectSet("RSLT_PRODUCT_ST", Protocol.SelectSet.NONE),				// 6
//		new SelectSet("RSLT_PRODUCT_PRICE", Protocol.SelectSet.NONE),			// 7
//		new SelectSet("RSLT_SALES_PRICE", Protocol.SelectSet.NONE),				// 8
//		new SelectSet("RSLT_SALES_RATE", Protocol.SelectSet.NONE),				// 9
//		new SelectSet("RSLT_GROUPCD_MST", Protocol.SelectSet.NONE),				// 10
//		new SelectSet("RSLT_GROUPCD_SUB", Protocol.SelectSet.NONE),				// 11
//		new SelectSet("RSLT_GROUPCD_MST_NAME", Protocol.SelectSet.NONE),		// 12
//		new SelectSet("RSLT_GROUPCD_SUB_NAME", Protocol.SelectSet.NONE),		// 13
//		new SelectSet("RSLT_P_PRODCD", Protocol.SelectSet.NONE),				// 14
//		new SelectSet("RSLT_PRODUCT_IMAGE_PATH", Protocol.SelectSet.NONE),		// 15
//		new SelectSet("RSLT_BRAND_NAME", Protocol.SelectSet.NONE),				// 16
//		new SelectSet("RSLT_NEW_YN", Protocol.SelectSet.NONE),					// 17
//		new SelectSet("RSLT_DLV_FEE_YN", Protocol.SelectSet.NONE),				// 18
//		new SelectSet("RSLT_PRODUCT_RIMAGE_PATH", Protocol.SelectSet.NONE), 	// 19
//		new SelectSet("RSLT_WISH_YN", Protocol.SelectSet.NONE),					// 20
//		new SelectSet("RSLT_PRODUCT_STATUSCD", Protocol.SelectSet.NONE),		// 21
//		new SelectSet("ORD_MD_WEIGHT", Protocol.SelectSet.NONE),				// 22
//		new SelectSet("ORD_CLICK_WEIGHT_RATE", Protocol.SelectSet.NONE),		// 23
//		new SelectSet("ORD_SALES_AMOUNT_WEIGHT_RATE", Protocol.SelectSet.NONE),	// 24
//		new SelectSet("ORD_MD_WEIGHT_RATE", Protocol.SelectSet.NONE),			// 25
//		new SelectSet("ORD_CLICK_WEIGHT_MAX", Protocol.SelectSet.NONE),			// 26
//		new SelectSet("ORD_SALES_AMOUNT_WEIGHT_MAX", Protocol.SelectSet.NONE),	// 27
//		new SelectSet("ORD_MD_WEIGHT_MAX", Protocol.SelectSet.NONE),			// 28
//		new SelectSet("POPULAR_POINT", Protocol.SelectSet.NONE),				// 29
//		new SelectSet("KEYWORD_ACCURACY_POINT", Protocol.SelectSet.NONE),		// 30
//		new SelectSet("WEIGHT", Protocol.SelectSet.NONE)						// 31
		
		int likeIdx = 20;
		int wpointIdx = 30;
		int weightIdx = 31;
		
		String likeYn = "N";
		String like = "";
		String weight = "";
		
		String[] arr_l = null;
		
		for (int i = 0; i < optResult.length; i++) {
//			TreeMap<Integer, String> map_t = new TreeMap<Integer, String>();
//			HashMap<String, String> map_p = new HashMap<String, String>();
			
			try {
				
				like = String.valueOf(optResult[i][likeIdx]);	// LIKE_YN
				weight = String.valueOf(optResult[i][weightIdx]);	// WEIGHT
				
				arr_l = like.split(",");
				
				// LIKE_YN
				likeYn = "N";
				
				if (mnoStr.equals("")) {
					likeYn = "N";
				} else {
					for (int j=0; j<arr_l.length; j++) {
						if (mnoStr.equals(arr_l[j])) {
							likeYn = "Y";
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			optResult[i][likeIdx] = likeYn.toCharArray();
			optResult[i][wpointIdx] = weight.toCharArray();
		}
		
	}

}
