package xin.jerome.study.mybatis.mapper;

import xin.jerome.study.mybatis.model.Bank;

/**
 * todo
 *
 * @author JeromeSoar
 * @since 2020年01月10日 11:56
 */
public interface BankMapper {

	/**
	 * 根据id查询对象
	 * @param id 目标id
	 * @return 查询结果
	 */
	Bank selectBank(int id);
}
