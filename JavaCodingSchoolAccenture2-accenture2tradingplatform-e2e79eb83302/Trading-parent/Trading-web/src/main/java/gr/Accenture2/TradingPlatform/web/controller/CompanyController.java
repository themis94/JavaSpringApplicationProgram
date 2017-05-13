package gr.Accenture2.TradingPlatform.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.repository.service.CompanyRepository;

@RestController
@RequestMapping("/services/companies")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("")
	public Set<Company> getCompanies() {
		return companyRepository.findAllIdAndName();
	}
	
	@GetMapping("/{companyId}")
	public Company getCompanyStocks(@PathVariable Long companyId) {
		return companyRepository.findOne(companyId);
	}
}
