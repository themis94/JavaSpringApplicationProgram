package gr.Accenture2.TradingPlatform.repository.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import gr.Accenture2.TradingPlatform.core.entity.Company;
import gr.Accenture2.TradingPlatform.core.entity.Stock;
import gr.Accenture2.TradingPlatform.core.entity.User;
import gr.Accenture2.TradingPlatform.core.entity.UserStockTrade;

@Transactional
public interface UserStockTradeRepository extends CrudRepository<UserStockTrade, Long>, JpaRepository<UserStockTrade, Long> {
	
	@Query("SELECT s FROM UserStockTrade s WHERE s.user = :user1 AND s.stock.company = :company1 AND active = true")
	public Page<UserStockTrade> findUserStockTrades(@Param(value = "company1") Company company,@Param(value = "user1") User user ,Pageable pageable);
	
	@Query("SELECT COUNT(s) FROM UserStockTrade s WHERE s.user = :user1 AND s.stock.company = :company1 AND active = true")
	public Long getNumberOfUserStockTrades(@Param(value = "company1") Company company, @Param(value = "user1")  User user);
	
}
