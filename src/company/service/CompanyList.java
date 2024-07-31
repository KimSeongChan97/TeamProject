package company.service;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyList implements Company {

	@Override
	public void execute() {
		System.out.println("이름\t아이디\t입사일\t\t전화번호\t\t출결현황");
		System.out.println("----------------------------------------");
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		CompanyDTO companyDTO = new CompanyDTO();
		
		companyDAO.list(companyDTO);
	}

}
