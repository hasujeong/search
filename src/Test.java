import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		
		Double ORD_CLICK_CNT = nullToDouble("50", 500.0);
		Double ORD_CLICK_WEIGHT_MAX = 500.0;
		Double ORD_CLICK_WEIGHT_RATE = 35.0;
		
		Double po1 = ((double)(9) / (double)(500)) * (double)(35);
		Double po2 = ((double)(0) / (double)(2000000)) * (double)(25);
		Double po3 = ((double)(50) / (double)(100)) * (double)(40);
		
		System.out.println(po1);
		System.out.println(po2);
		System.out.println(po3);
		
		System.out.println(String.format("%.1f", (po1+po2+po3)));
		
		String OPT_USER	= "0000:1478:4:9:112003:T00032:1010020001:Y:Y:1:USER#@4,0000:1479:4:10:112003:T00033:1010020001:Y:Y:1:USER#@4,0000:1480:4:11:112003:T00034:1010020001:Y:Y:1:USER#@4,0000:1481:4:477:112003:T00035:1010020001:Y:Y:1:USER#@4,0000:1482:4:478:112003:T00036:1010020001:Y:Y:1:USER#@4,0000:1753:178:594:112002:T00010:1010020001:Y:Y:9:USER#@178,0000:1754:178:595:112002:T00002:1010020001:Y:Y:9:USER#@178,0000:1755:178:596:112002:T00029:1010020001:Y:Y:9:USER#@178,0000:1756:178:597:112002:T00003:1010020001:Y:Y:9:USER#@178";
		String OPT_SIZE	= "0001:1478:4:9:112003:T00032:1010020001:Y:Y:1:SIZE#@4,0002:1479:4:10:112003:T00033:1010020001:Y:Y:1:SIZE#@4,0003:1480:4:11:112003:T00034:1010020001:Y:Y:1:SIZE#@4";
		String OPT_PROD	= "0001:1753:178:594:112002:T00010:1010020001:Y:Y:9:PROD#@178,0002:1754:178:595:112002:T00002:1010020001:Y:Y:9:PROD#@178,0003:1755:178:596:112002:T00029:1010020001:Y:Y:9:PROD#@178,0004:1756:178:597:112002:T00003:1010020001:Y:Y:9:PROD#@178";
		
		String OPT_PROP = "P00001#111001,P00002#111001,P00003#111001,P00004#111001,P00005#111001,P00006#111002,P00007#111002,P00008#111002,P00009#111002,P00010#111002,P00011#111003,P00012#111003,P00013#111003,P00014#111003,P00015#111004,P00016#111004,P00017#111004,P00018#111004,P00019#111004,P00020#111004,P00021#111004,P00022#111004,P00023#111004,P00024#111004,P00025#111004,P00026#111004,P00027#111004,P00028#111002,P00029#111002,P00030#111005,P00031#111005,P00032#111005,P00033#111005,P00034#111005,P00035#111005,P00036#111005,P00037#111005,P00038#111005,P00039#111005,P00040#111005,P00041#111005,P00042#111005,P00043#111005,P00044#111005,P00045#111005,P00046#111005,P00047#111005,P00048#111005,P00049#111005,P00050#111005,P00051#111005,T00001#112002,T00002#112002,T00003#112002,T00004#112002,T00005#112002,T00006#112002,T00007#112002,T00008#112002,T00009#112002,T00010#112002,T00011#112002,T00012#112002,T00013#112002,T00014#112002,T00015#112002,T00016#112002,T00017#112002,T00018#112002,T00019#112002,T00020#112002,T00021#112002,T00022#112002,T00023#112002,T00024#112002,T00025#112002,T00026#112002,T00027#112002,T00028#112002,T00029#112002,T00030#112002,T00031#112002,T00032#112003,T00033#112003,T00034#112003,T00035#112003,T00036#112003,T00037#112003,T00038#112003,T00039#112003,T00040#112003,T00041#112003,T00042#112003,T00043#112003,T00044#112003,T00045#112003,T00046#112003,T00047#112003,T00048#112003,T00049#112003,T00050#112003,T00051#112003,T00052#112003,T00053#112003,T00054#112003,T00055#112003,T00056#112004,T00057#112004,T00058#112005,T00059#112005,T00060#112005,T00061#112006,T00062#112006,T00063#112006,T00064#112006,T00065#112008,T00066#112008,T00067#112008,T00068#112008,T00069#112008,T00070#112010,T00071#112010,T00072#112010,T00073#112010,T00074#112010,T00075#112011,T00076#112011,T00077#112011,T00078#112011,T00079#112011,T00080#112011,T00081#112011,T00082#112011,T00083#112012,T00084#112012,T00085#112013,T00086#112013,T00087#112013,T00088#112014,T00089#112014,T00090#112014,T00091#112015,T00092#112015,T00093#112015,T00094#112001,T00095#112001,T00096#112001,T00097#112001,T00098#112001,T00099#112001,T00100#112001,T00101#112007,T00102#112007,T00103#112009,T00104#112009,T00105#112009,T00106#112009,T00107#112016,T00108#112016,T00109#112016,T00110#112016,T00111#112016,T00112#112016,T00113#112016,T00114#112017,T00115#112017,T00116#112017,T00117#112017,T00118#112017,T00119#112003,T00120#112018,T00121#112018,T00122#112019,T00123#112019,T00124#112019,T00125#112019,T00126#112019,T00127#112019,T00128#112015,T00129#112020,T00130#112020,T00132#112014,T00133#112002,T00134#112021,T00135#112021,T00136#112021,T00137#112021,T00138#112021,T00139#112021,T00140#112021,T00141#112021,T00142#112021,T00143#112021,T00144#112021,T00145#112021,T00146#112021,T00147#112021,T00148#112021,T00149#112021,T00150#112021,T00151#112021,T00152#112021,T00153#112021,T00154#112021,T00155#112021,T00156#112021,T00157#112021,T00158#112021,T00159#112021,T00160#112021,T00161#112021,T00162#112021,T00163#112021,T00164#112021,T00165#112021,T00166#112021,T00167#112021,T00168#112021,T00169#112021,T00170#112021,T00171#112021,T00172#112002,T00173#112002,T00174#112002,T00175#112023,T00176#112023,T00177#112023,T00178#112023,T00179#112023,T00180#112023,T00182#112024,T00183#112024,T00184#112024,T00185#112024,T00186#112003,T00187#112006";
//		0001:1753:178:594:112002:T00010:1010020001:Y:Y:9:PROD
//		0002:1754:178:595:112002:T00002:1010020001:Y:Y:9:PROD
//		0003:1755:178:596:112002:T00029:1010020001:Y:Y:9:PROD
//		0004:1756:178:597:112002:T00003:1010020001:Y:Y:9:PROD
		String optStr = "";
//		String optStr = "T00011,T00034,T00032,T00033";
		
		String[] arr_d = OPT_PROD.split(",");
		String[] arr_s = OPT_SIZE.split(",");
		String[] arr_u = OPT_USER.split(",");
		String[] arr_p = OPT_PROP.split(",");
		
		TreeMap<Integer, String> map_t = new TreeMap<Integer, String>();
//		HashMap<String, String> map_t = new HashMap<String, String>();
//		HashMap<String, String> map_t = new HashMap<String, String>();
		HashMap<String, String> map_p = new HashMap<String, String>();
		
		for (int i=0; i<arr_p.length; i++) {
			map_p.put(arr_p[i].split("#")[0], arr_p[i].split("#")[1]);
		}
		
		for (int i=0; i<arr_d.length; i++) {
			String[] tempArr = arr_d[i].split("#@");
			
			if (tempArr.length == 2) {
				String val = tempArr[0];
				int key = Integer.parseInt(tempArr[1]);
				
				boolean check = true;
				
				if (optStr.equals("")) {
					if (map_t.get(key) != null) {
						if (val.compareTo(map_t.get(key)) < 0) {
							map_t.put(key, val);
						}
					} else {
						map_t.put(key, val);
					}
				} else {
					String[] optArr = optStr.split(",");
					
					for (int j=0; j<optArr.length; j++) {
						String propStr = map_p.get(optArr[j]);
						
						if (val.indexOf(propStr) == -1 && check) {
							if (map_t.get(key) != null) {
								if (val.compareTo(map_t.get(key)) < 0) {
									map_t.put(key, val);
								}
							} else {
								map_t.put(key, val);
							}
						} else {
							check = false;
						}
					}
				}
			}
		}
		
		System.out.println(map_t);
		
		optStr = "T00011,T00034,T00032,T00033";
		
		for (int i=0; i<arr_s.length; i++) {
			String[] tempArr = arr_s[i].split("#@");
			
			if (tempArr.length == 2) {
				String val = tempArr[0];
				int key = Integer.parseInt(tempArr[1]);
				
				if (map_t.get(key) != null) {
					if (val.compareTo(map_t.get(key)) < 0) {
						map_t.put(key, val);
					}
				} else {
					map_t.put(key, val);
				}
			}
		}
		
		System.out.println(map_t);
		
		if (!optStr.equals("")) {
			for (int i=0; i<arr_u.length; i++) {
				String[] tempArr = arr_u[i].split("#@");
				
				if (tempArr.length == 2) {
					String val = tempArr[0];
					int key = Integer.parseInt(tempArr[1]);
					
					String[] optArr = optStr.split(",");
					
					for (int j=0; j<optArr.length; j++) {
						if (val.indexOf(optArr[j]) > -1) {
							if (map_t.get(key) != null) {
								if (val.compareTo(map_t.get(key)) < 0) {
									map_t.put(key, val);
								}
							} else {
								map_t.put(key, val);
							}
						}
					}
				}
			}
		}
		
		System.out.println(map_t);
		
		String imgOpt = "";
		
		Iterator<Integer> keys = map_t.keySet().iterator();
		
		while (keys.hasNext()) {
		    int key = keys.next();
		    imgOpt = imgOpt + map_t.get(key).split(":")[4] + ":" + map_t.get(key).split(":")[5];
		    
		    if (keys.hasNext()) {
		    	imgOpt = imgOpt + ",";
		    }
		}
		
		String img = "https://temp-product-image-origin.oround.com/api/??/1/" + imgOpt + ".jpg";
		
		System.out.println(img);
		
	}
	
	public static double nullToDouble(String object, double convertDouble) {
		double tempDouble = 0.0;

		if (object == null || object.equals("")) {
			tempDouble = convertDouble;
		} else {
			tempDouble = Double.parseDouble(object);
		}

		return tempDouble;
	}

}
