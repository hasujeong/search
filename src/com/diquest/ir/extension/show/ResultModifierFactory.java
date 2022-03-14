package com.diquest.ir.extension.show;

import com.diquest.ir.common.exception.IRException;
import com.diquest.ir.server.extension.IResultModifier;
import com.diquest.ir.server.extension.IResultModifierFactory;

/**
 * @author cmyun
 * ResultModifierFactory : ResultModifier instance 를 생성하는 Factory class
 * 
 * 
 * *주의) package 명은 반드시 com.diquest.ir.extension.(modifier_name) 로 설정한다.
 *        검색 API 에서 Query.setResultModifier("modifier_name") 으로 동일하게 설정한다.
 *        ResultModifierFactory 의 클래스 명은 변경하지 않는다.
 *
 */
public class ResultModifierFactory implements IResultModifierFactory {
	
	/* (non-Javadoc)
	 * @see com.diquest.ir.server.extension.IResultModifierFactory#create()
	 * 
	 * 사용할 ResultModifer instance 를 리턴한다
	 */
	public IResultModifier create() throws IRException {
		return new showResultModifier();
	}

}
