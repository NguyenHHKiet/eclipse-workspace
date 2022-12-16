package com.management.repositories.repositoryInterface;

import com.management.ConnectionSQL;

public interface ProjectRepositoryInterface extends CRUDRepository {

	void DisplaySrotInvestment(ConnectionSQL conn);
}
